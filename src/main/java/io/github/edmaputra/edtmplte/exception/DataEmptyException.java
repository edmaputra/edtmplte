package io.github.edmaputra.edtmplte.exception;

import io.github.edmaputra.edtmplte.logger.LogEntity;
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
     * Default Message for this Custom Exception
     */
    private static final String DEFAULT_MESSAGE = "Data is Empty";

    /**
     * Default Constructor
     *
     * @since 1.0
     */
    public DataEmptyException() {
        super();
    }

    /**
     * Exception Constructor with Entity Object
     *
     * @param message
     * @since 1.0
     */
    public DataEmptyException(String entity) {
        super(DEFAULT_MESSAGE);
        log.warn(new LogEntity(entity, DEFAULT_MESSAGE).toString());

    }

    /**
     * Exception Constructor with Layer and Entity object
     *
     * @param message
     * @param ABaseEntity
     * @since 1.0
     */
    public DataEmptyException(String layer, String entity) {
        super(DEFAULT_MESSAGE);
        log.warn(new LogEntity(layer, entity, DEFAULT_MESSAGE).toString());
    }
}
