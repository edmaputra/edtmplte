package io.github.edmaputra.edtmplte.exception;

import io.github.edmaputra.edtmplte.domain.ABaseEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Data Empty Exception, with {@link HttpStatus} NOT_FOUND response
 *
 * @author edmaputra
 * @since 1.0
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
@Slf4j
public class DataEmptyException extends Exception {

    /**
     * Default Constructor
     *
     * @since 1.0
     */
    public DataEmptyException() {
        super();
    }

    /**
     * Exception Constructor with message
     *
     * @param message
     * @since 1.0
     */
    public DataEmptyException(String s) {
        super(s);
        log.warn("Data Is Empty");
    }

    /**
     * Exception Constructor with message and Entity object
     *
     * @param message
     * @param ABaseEntity
     * @since 1.0
     */
    public DataEmptyException(String s, ABaseEntity entity) {
        super(s);
        log.warn("Data Is Empty: " + entity);
    }
}
