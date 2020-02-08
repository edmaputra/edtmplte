package io.github.edmaputra.edtmplte.service;

import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.Optional;

/**
 * Base Service Interface for Business Object Layer.
 * Define basic method for all Create, Read, Update and Delete purpose
 *
 * @param <T>  the domain which extends {@link Serializable}
 * @param <ID> the type of the id of the entity
 * @author edmaputra
 * @since 0.0.1
 */
public interface ABaseService<T extends Serializable, ID> {

    /**
     * Retrieves all entities without an parameters
     *
     * @return Collection of T
     */
    Iterable<T> retrieveAll() throws Exception;

    /**
     * Retrieves all entities with parameter
     *
     * @param pageable the {@link Pageable} interface
     * @param search   if user want to filter with value
     * @param option   RECORDED for recorded is true, ALL for all saved data
     * @return Collection of T
     */
    Iterable<T> retrieveAll(Pageable pageable, String search, String option) throws Exception;

    /**
     * Retrieves an entity by its id.
     *
     * @param id must not be {@literal null}.
     * @return the entity with the given id or {@literal Optional#empty()} if none found
     */
    T retrieveOne(ID id) throws Exception;

    /**
     * Saves an entity, and then return {@link Optional} of the entity for further usability
     *
     * @param t must not be {@literal null}.
     * @return the saved entity will never be {@literal null}.
     */
    T add(T t) throws Exception;

    /**
     * Update an entity, and then return {@link Optional} of the entity for further usability
     *
     * @param t  must not be {@literal null}.
     * @param id must not be {@literal null}.
     * @return the saved entity will never be {@literal null}.
     */
    T update(T t, ID id) throws Exception;

    /**
     * Update an entity to be deleted but data is still exist.
     * Return {@link Optional} of the entity for further usability
     *
     * @param id must not be {@literal null}.
     * @return the deleted entity will never be {@literal null}.
     */
    T delete(ID id) throws Exception;

}
