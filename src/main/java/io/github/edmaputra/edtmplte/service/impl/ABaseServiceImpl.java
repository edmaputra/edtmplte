package io.github.edmaputra.edtmplte.service.impl;

import io.github.edmaputra.edtmplte.domain.ABaseEntity;
import io.github.edmaputra.edtmplte.exception.DataNotFoundException;
import io.github.edmaputra.edtmplte.repository.ABaseRepository;
import io.github.edmaputra.edtmplte.service.ABaseService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.Optional;

public class ABaseServiceImpl<T extends ABaseEntity, ID> implements ABaseService<T, ID> {

    private ABaseRepository<T, ID> repository;

    @Autowired
    public ABaseServiceImpl(ABaseRepository<T, ID> repository) {
        this.repository = repository;
    }

    @Override
    public Iterable<T> retrieveAll() throws Exception {
        return repository.findAll();

    }

    @Override
    public Iterable<T> retrieveAll(Integer page, Integer size) throws Exception {
        PageRequest request = PageRequest.of(page -1, size);
        Optional<Page<T>> collections = repository.findByRecordedTrue(request);
        return collections.get();
    }

    @Override
    public Iterable<T> retrieveAll(Integer page, Integer size,  String sortBy, String search) throws Exception {
        PageRequest request = PageRequest.of(page -1, size, Sort.Direction.ASC, sortBy);
        Iterable<T> collections = repository.findAll(request);
        return collections;
    }

    @Override
    public Optional<T> retrieveOne(ID id) throws Exception {
        Optional<T> optional = repository.findById(id);
        if (!optional.isPresent())
            throw new DataNotFoundException("ID - " + id);
        return optional;
    }

    @Override
    public Optional<T> add(T t) throws Exception {
        try {
            repository.save(t);
            return Optional.of(t);
        } catch (Exception ex) {
            throw new Exception(this.getClass().getSimpleName() + ": Add Failed");
        }
    }

    @Override
    public Optional<T> update(T t, ID id) throws Exception {
        try {
            Optional<T> saved = repository.findById(id);
            if (!saved.isPresent()) {
                throw new DataNotFoundException("ID - " + id);
            }
            T s = saved.get();
            BeanUtils.copyProperties(t, s, "id");
            repository.save(s);
            return Optional.of(s);
        } catch (Exception ex) {
            throw new Exception(this.getClass().getSimpleName() + ": Update Failed");
        }
    }

    @Override
    public Optional<T> delete(ID id) throws Exception {
        try {
            Optional<T> t = repository.findById(id);
            T e = t.get();
            e.setRecorded(false);
            repository.save(e);
            return t;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            throw new Exception(this.getClass().getSimpleName() + ": Delete By ID Failed");
        }
    }

}
