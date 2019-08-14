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

@Slf4j
public abstract class ABaseController<T extends Serializable, ID> {

    private ABaseService<T, ID> service;

    public ABaseController(ABaseService<T, ID> service) {
        this.service = service;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity retrieveAll(@RequestParam(name = "page", defaultValue = "1", required = false) Integer page,
                                         @RequestParam(name = "size", defaultValue = "10", required = false) Integer size,
                                         Principal principal
    ) throws Exception {
        Iterable<T> data = service.retrieveAll(page, size);
        return ResponseEntity.ok(data);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity find(@PathVariable ID id) throws Exception {
        T t = service.retrieveOne(id);
        return ResponseEntity.ok().body(t);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity add(@Valid @RequestBody T t) throws Exception {
        T result = service.add(t);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<T> update(@Valid @RequestBody T t, @PathVariable("id") ID id) throws Exception {
        T result = service.update(t, id);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteById(@PathVariable ID id) throws Exception {
        T result = service.delete(id);
        return ResponseEntity.ok().body(result);
    }
}
