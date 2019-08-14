package io.github.edmaputra.edtmplte.service.impl;

import io.github.edmaputra.edtmplte.domain.ABaseEntity;
import io.github.edmaputra.edtmplte.exception.DataEmptyException;
import io.github.edmaputra.edtmplte.exception.DataNotFoundException;
import io.github.edmaputra.edtmplte.logger.LogEntity;
import io.github.edmaputra.edtmplte.repository.ABaseRepository;
import io.github.edmaputra.edtmplte.service.ABaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Optional;

/**
 * Class that implements {@link ABaseService} for Business Object Layer.
 *
 * @param <T>  the domain which extends {@link ABaseEntity}
 * @param <ID> the type of the id of the entity
 * @author edmaputra
 * @since 1.0
 */
@Slf4j
public class ABaseServiceImpl<T extends ABaseEntity, ID> implements ABaseService<T, ID> {

    /**
     * Domain Class Name from Generic Class T
     */
    private final String domainClassName;
    private final String layerName = this.getClass().getName();

    /**
     * The Repository
     */
    private ABaseRepository<T, ID> repository;

    public ABaseServiceImpl(ABaseRepository<T, ID> repository) {
        this.repository = repository;
        this.domainClassName = getGenericName();
    }

    /**
     * Retrieve All T Item with no parameters
     *
     * @return {@link Iterable}
     */
    @Override
    public Iterable<T> retrieveAll() throws Exception {
        List list = repository.findAll();
        if (list.isEmpty()) {
            throw new DataEmptyException(layerName, domainClassName);
        }
        return list;
    }

    /**
     * Retrieves all entities by some parameter for limiter
     *
     * @param page number of the page
     * @param size how many data to displayed
     * @return {@link Iterable}
     * @since 1.0
     */
    @Override
    public Iterable<T> retrieveAll(Integer page, Integer size) throws Exception {
        log.info(domainClassName + ": Retrieving All With Pages");
        PageRequest request = PageRequest.of(page - 1, size);
        Optional<Page<T>> collections = repository.findByRecordedTrue(request);
        if (!collections.isPresent()) {
            throw new DataNotFoundException(layerName, domainClassName);
        }
        if (collections.get().isEmpty()) {
            throw new DataEmptyException(layerName, domainClassName);
        }
        log.info("Returning the result");
        return collections.get();
    }

    /**
     * Retrieves all entities by some parameter for limiter
     *
     * @param page   number of the page
     * @param size   how many data to displayed
     * @param sort   type of sort in {@link String}
     * @param search if user want to filter with value
     * @return {@link Iterable}
     * @since 1.0
     */
    @Override
    public Iterable<T> retrieveAll(Integer page, Integer size, String sortBy, String search) throws Exception {
        PageRequest request = PageRequest.of(page - 1, size, Sort.Direction.ASC, sortBy);
        Iterable<T> collections = repository.findAll(request);
        if (!collections.iterator().hasNext()) {
            throw new DataEmptyException("Record is Empty");
        }
        return collections;
    }

    /**
     * Retrieves an entity by its id.
     *
     * @param id must not be {@literal null}.
     * @return the entity with the given id
     * @since 1.0
     */
    @Override
    public T retrieveOne(ID id) throws Exception {
        Optional<T> optional = repository.findById(id);
        if (!optional.isPresent())
            throw new DataNotFoundException("ID - " + id);
        return optional.get();
    }

    /**
     * Saves an entity, and then return the entity
     *
     * @param t must not be {@literal null}.
     * @return the saved entity will never be {@literal null}.
     * @since 1.0
     */
    @Override
    public T add(T t) throws Exception {
        try {
            T tt = repository.save(t);
            return tt;
        } catch (Exception ex) {
            throw new Exception(this.getClass().getSimpleName() + ": Add Failed");
        }
    }

    /**
     * Update an entity, and then the entity
     *
     * @param t  must not be {@literal null}.
     * @param id must not be {@literal null}.
     * @return the saved entity will never be {@literal null}.
     * @since 1.0
     */
    @Override
    public T update(T t, ID id) throws Exception {
        try {
            Optional<T> saved = repository.findById(id);
            if (!saved.isPresent()) {
                throw new DataNotFoundException("ID - " + id);
            }
            T s = saved.get();
            BeanUtils.copyProperties(t, s, "id");
            T updated = repository.save(s);
            return updated;
        } catch (Exception ex) {
            throw new Exception(this.getClass().getSimpleName() + ": Update Failed. " + ex.getMessage());
        }
    }

    /**
     * Update an entity to be deleted but data is still exist.
     * Return the entity
     *
     * @param id must not be {@literal null}.
     * @return the deleted entity will never be {@literal null}.
     * @since 1.0
     */
    @Override
    public T delete(ID id) throws Exception {
        try {
            Optional<T> t = repository.findById(id);
            if (!t.isPresent())
                throw new DataNotFoundException("ID - " + id);
            T e = t.get();
            log.info(new LogEntity(domainClassName, "Get Saved Entity for Deletion with ID: "+id).toString());
            e.setRecorded(false);
            log.info(new LogEntity(domainClassName, "Set Recorded to False for Entity with ID: "+id).toString());
            T saved = repository.save(e);
            return saved;
        } catch (Exception ex) {
            log.warn(new LogEntity(layerName, domainClassName, "Delete By ID " + id + " Failed").toString());
            throw new Exception("Delete By ID " + id + " Failed");
        }
    }

    /**
     * Method for get name of Generic Class
     *
     * @return Generic Class Name
     */
    protected String getGenericName() {
        return ((Class<T>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0]).getTypeName();
    }

}
