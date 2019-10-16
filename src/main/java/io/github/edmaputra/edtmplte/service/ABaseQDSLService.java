package io.github.edmaputra.edtmplte.service;

import java.io.Serializable;
import java.util.Optional;

/**
 * Base Service Interface for Business Object Layer with QueryDSL Feature
 *
 * @param <T>  the domain which extends {@link Serializable}
 * @param <ID> the type of the id of the entity
 * @author edmaputra
 * @since 1.0.3.1
 */
public interface ABaseQDSLService<T extends Serializable, ID> extends ABaseService<T, ID>{

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
    Iterable<T> retrieveAll(Integer page, Integer size, String sortBy, String search, String entity) throws Exception;

}
