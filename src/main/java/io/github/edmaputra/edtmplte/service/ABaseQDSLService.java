package io.github.edmaputra.edtmplte.service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

/**
 * Base Service Interface for Business Object Layer with QueryDSL Feature
 *
 * @param <T>  the domain which extends {@link Serializable}
 * @param <ID> the type of the id of the entity
 * @author edmaputra
 * @since 1.0.3.1
 */
public interface ABaseQDSLService<T extends Serializable, ID>{

    /**
     * Retrieves all entities
     *
     * @return
     * @since 1.0
     */
    Iterable<T> retrieveAll() throws Exception;

    /**
     * Retrieves all entities by some parameter for limiter
     *
     * @param page number of the page
     * @param size how many data to displayed
     * @return {@link Iterable}
     * @since 1.0
     */
    Iterable<T> retrieveAll(Integer page, Integer size) throws Exception;

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
    Iterable<T> retrieveAll(Integer page, Integer size, String sortBy, String search) throws Exception;

    /**
     * Retrieves an entity by its id.
     *
     * @param id must not be {@literal null}.
     * @return the entity with the given id or {@literal Optional#empty()} if none found
     * @since 1.0
     */
    T retrieveOne(ID id) throws Exception;

    /**
     * Saves an entity, and then return {@link Optional} of the entity for further usability
     *
     * @param t must not be {@literal null}.
     * @return the saved entity will never be {@literal null}.
     * @since 1.0
     */
    T add(T t) throws Exception;

    /**
     * Update an entity, and then return {@link Optional} of the entity for further usability
     *
     * @param t  must not be {@literal null}.
     * @param id must not be {@literal null}.
     * @return the saved entity will never be {@literal null}.
     * @since 1.0
     */
    T update(T t, ID id) throws Exception;

    /**
     * Update an entity to be deleted but data is still exist.
     * Return {@link Optional} of the entity for further usability
     *
     * @param id must not be {@literal null}.
     * @return the deleted entity will never be {@literal null}.
     * @since 1.0
     */
    T delete(ID id) throws Exception;

    /**
     * Retrieves all entities by some parameter for limiter
     *
     * @param page   number of the page
     * @param size   how many data to displayed
     * @param sort   type of sort in {@link String}
     * @param search if user want to filter with value
     * @param entity name of the entity
     * @param filterBy List of key for filtering
     * @return {@link Iterable}
     * @since 1.0.3.1
     */
    Iterable<T> retrieveAll(Integer page, Integer size, String sortBy, String search, String entity, List<String> filterBy) throws Exception;

    /**
     * Retrieves all entities by some parameter for limiter
     *
     * @param page   number of the page
     * @param size   how many data to displayed
     * @param sort   type of sort in {@link String}
     * @param search if user want to filter with value
     * @param entity name of the entity
     * @param filterBy List of key for filtering
     * @param showInactive Show all or just active entity
     * @return {@link Iterable}
     * @since 1.0.3.1
     */
    Iterable<T> retrieveAll(Integer page, Integer size, String sortBy, String search, String entity, List<String> filterBy, boolean showInactive) throws Exception;

}
