package io.github.edmaputra.edtmplte.service;

import java.io.Serializable;
import java.util.Optional;

public interface ABaseService<T extends Serializable, ID> {

    Iterable<T> retrieveAll() throws Exception;

    Iterable<T> retrieveAll(Integer page, Integer size) throws Exception;

    Iterable<T> retrieveAll(Integer page, Integer size, String sortBy, String search) throws Exception;

    Optional<T> retrieveOne(ID id) throws Exception;

    Optional<T> add(T t) throws Exception;

    Optional<T> update(T t, ID id) throws Exception;

    Optional<T> delete(ID id) throws Exception;

}
