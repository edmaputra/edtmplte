package io.github.edmaputra.edtmplte.controller;

import io.github.edmaputra.edtmplte.exception.DataEmptyException;
import io.github.edmaputra.edtmplte.service.ABaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.Serializable;
import java.security.Principal;
import java.util.Optional;

@Slf4j
public abstract class ABaseController<T extends Serializable, ID> {

    private ABaseService<T, ID> service;

    public ABaseController(ABaseService<T, ID> service) {
        this.service = service;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<T> retrieveAll(@RequestParam(name = "page", defaultValue = "1", required = false) Integer page,
                                         @RequestParam(name = "size", defaultValue = "10", required = false) Integer size,
                                         Principal principal
    ) throws Exception {
        log.info("RetrieveAll");
        Iterable<T> data = service.retrieveAll(page, size);
        if (!data.iterator().hasNext()){
            log.info("data empty");
            throw new DataEmptyException("Record Empty");
        }
        log.info("Retrieved {}", data);
        return new ResponseEntity(data, HttpStatus.OK);

    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<T> find(@PathVariable ID id) throws Exception {

        Optional<T> t = service.retrieveOne(id);

        if (!t.isPresent()) {
            throw new Exception("id - " + id);
        }

        return new ResponseEntity<>(t.get(), HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<T> add(@Valid @RequestBody T t) throws Exception {
        Optional<T> result = service.add(t);
        return new ResponseEntity<>(result.get(), HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<T> update(@Valid @RequestBody T t, @PathVariable("id") ID id) throws Exception {
        Optional<T> result = service.update(t, id);
        return new ResponseEntity<>(result.get(), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<T> deleteById(@PathVariable ID id) throws Exception {
        Optional<T> result = service.delete(id);
        return new ResponseEntity<>(result.get(), HttpStatus.OK);
    }
}
