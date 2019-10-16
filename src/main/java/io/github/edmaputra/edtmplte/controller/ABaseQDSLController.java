package io.github.edmaputra.edtmplte.controller;

import io.github.edmaputra.edtmplte.domain.ABaseEntity;
import io.github.edmaputra.edtmplte.service.ABaseQDSLService;
import io.github.edmaputra.edtmplte.service.ABaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.security.Principal;

/**
 * Base Controller for Presentation Layer.
 *
 * @param <T>  the domain which extends {@link ABaseEntity}
 * @param <ID> the type of the id of the entity
 * @author edmaputra
 * @since 1.0
 */
public abstract class ABaseQDSLController<T extends Serializable, ID> {

    /**
     * Service Class
     */
    private ABaseQDSLService<T, ID> service;

    private static final Logger log = LoggerFactory.getLogger(ABaseQDSLController.class);

    private final String entity;

    public ABaseQDSLController(ABaseQDSLService<T, ID> service, String entity) {
        this.service = service;
        this.entity = entity;
    }

    /**
     * Retrieve All Entity, produces JSON
     *
     * @param page number of the page
     * @param size amount of the data
     * @return {@link ResponseEntity} with data in the body
     */
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity retrieveAll(@RequestParam(name = "page", defaultValue = "1", required = false) Integer page,
                                      @RequestParam(name = "size", defaultValue = "10", required = false) Integer size,
                                      Principal principal
    ) throws Exception {
        Iterable<T> data = service.retrieveAll(page, size);
        return ResponseEntity.ok(data);
    }

    /**
     * Retrieve All Entity, produces JSON
     *
     * @param page number of the page
     * @param size amount of the data
     * @param sortBy Sort data based on
     * @param search search keyword
     * @return {@link ResponseEntity} with data in the body
     */
    @GetMapping(value = "/q", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity retrieveAll(@RequestParam(name = "page", defaultValue = "1", required = false) Integer page,
                                      @RequestParam(name = "size", defaultValue = "10", required = false) Integer size,
                                      @RequestParam(name = "sortBy", defaultValue = "", required = false) String sortBy,
                                      @RequestParam(name = "search", defaultValue = "", required = false) String search,
                                      Principal principal
    ) throws Exception {
        Iterable<T> data = service.retrieveAll(page, size, sortBy, search, entity);
        return ResponseEntity.ok(data);
    }

    /**
     * Retrieve Entity By ID, produces JSON
     *
     * @param id Id of the entity
     * @return {@link ResponseEntity} with data in the body
     */
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity find(@PathVariable ID id) throws Exception {
        T t = service.retrieveOne(id);
        return ResponseEntity.ok().body(t);
    }

    /**
     * Post New Entity, consumes and produces JSON
     *
     * @param t Entity Object
     * @return {@link ResponseEntity} with data in the body
     */
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity add(@Valid @RequestBody T t) throws Exception {
        T result = service.add(t);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    /**
     * Update Saved Entity, consumes and produces JSON
     *
     * @param t  Entity Object
     * @param id ID of the Entity
     * @return {@link ResponseEntity} with data in the body
     */
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<T> update(@Valid @RequestBody T t, @PathVariable("id") ID id) throws Exception {
        T result = service.update(t, id);
        return ResponseEntity.ok().body(result);
    }

    /**
     * Delete Saved Entity, produces JSON
     *
     * @param id ID of the Entity
     * @return {@link ResponseEntity} with data in the body
     */
    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteById(@PathVariable ID id) throws Exception {
        T result = service.delete(id);
        return ResponseEntity.ok().body(result);
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
