package io.github.edmaputra.edtmplte.controller;

import io.github.edmaputra.edtmplte.domain.ABaseEntity;
import io.github.edmaputra.edtmplte.service.ABaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

/**
 * Base Controller for Presentation Layer.
 *
 * @param <T>  the domain which extends {@link ABaseEntity}
 * @param <ID> the type of the id of the entity
 * @author edmaputra
 * @since 0.0.1
 */
public abstract class ABaseController<T extends Serializable, ID> {

    private final ABaseService<T, ID> service;

    private static final Logger log = LoggerFactory.getLogger(ABaseController.class);

    public ABaseController(ABaseService<T, ID> service) {
        this.service = service;
    }

    /**
     * Retrieve All Entity, produces JSON
     *
     * @param pageable Pageable
     * @param search search keyword
     * @param option option to show all or recorded only
     * @return {@link ResponseEntity} with data in the body
     */
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity retrieveAll(Pageable pageable,
                                      @RequestParam(name = "search", defaultValue = "", required = false) String search,
                                      @RequestParam(name = "option", defaultValue = "RECORDED", required = false) String option
//                                      Principal principal
    ) throws Exception {
        Iterable<T> data = service.retrieveAll(pageable, search, option);
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
