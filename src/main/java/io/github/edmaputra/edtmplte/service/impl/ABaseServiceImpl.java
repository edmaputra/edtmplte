package io.github.edmaputra.edtmplte.service.impl;

import io.github.edmaputra.edtmplte.domain.ABaseEntity;
import io.github.edmaputra.edtmplte.exception.DataEmptyException;
import io.github.edmaputra.edtmplte.exception.DataNotFoundException;
import io.github.edmaputra.edtmplte.logger.LogEntity;
import io.github.edmaputra.edtmplte.repository.ABaseRepository;
import io.github.edmaputra.edtmplte.service.ABaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
 * @since 0.0.1
 */
public class ABaseServiceImpl<T extends ABaseEntity, ID> implements ABaseService<T, ID> {

    private final ABaseRepository<T, ID> repository;
    private final String domainClassName;
    private final String layerName = this.getClass().getName();

    public ABaseServiceImpl(ABaseRepository<T, ID> repository) {
        this.repository = repository;
        this.domainClassName = getGenericName();
    }

    /**
     * Retrieve All T Item with no parameters
     *
     * @return collection of T
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
     * Retrieves all T with parameter
     *
     * @param pageable the Pageable
     * @param search if user want to filter with value
     * @param option RECORDED for recorded is true, ALL for all saved data
     * @return Collection of T
     */
    @Override
    public Iterable<T> retrieveAll(Pageable pageable, String search, String option) throws Exception {
        Iterable<T> collections = null;
        if (option.equalsIgnoreCase("RECORDED")) {
            Optional<Page<T>> temp = repository.findByRecordedTrue(pageable);
            collections = temp.get();
        } else if (option.equalsIgnoreCase("ALL")) {
            collections = repository.findAll(pageable);
        }

        if (collections == null) {
            throw new DataNotFoundException(layerName, domainClassName);
        }
        if (collections.iterator().hasNext()) {
            throw new DataEmptyException(layerName, domainClassName);
        }
        return collections;
    }

    /**
     * Retrieves an entity by its id.
     *
     * @param id must not be {@literal null}.
     * @return the entity with the given id
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
     */
    @Override
    public T delete(ID id) throws Exception {
        try {
            Optional<T> t = repository.findById(id);
            if (!t.isPresent())
                throw new DataNotFoundException("ID - " + id);
            T e = t.get();
            e.setRecorded(false);
            T saved = repository.save(e);
            return saved;
        } catch (Exception ex) {
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
