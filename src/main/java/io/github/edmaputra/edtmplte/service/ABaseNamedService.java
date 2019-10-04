package io.github.edmaputra.edtmplte.service;

import io.github.edmaputra.edtmplte.domain.ABaseEntity;
import io.github.edmaputra.edtmplte.domain.ABaseNamedEntity;

import java.io.Serializable;

public interface ABaseNamedService<T extends ABaseNamedEntity, ID> extends ABaseService {

    /**
     * Retrieves List of entity by its name.
     *
     * @param name must not be {@literal null}.
     * @return list of the entity with the given name
     * @since 0.0.5
     */
    Iterable<T> findByName(String name) throws Exception;

}
