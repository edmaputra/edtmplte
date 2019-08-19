package io.github.edmaputra.edtmplte.exception;

import io.github.edmaputra.edtmplte.logger.LogEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Data Not Found Exception, with {@link HttpStatus} NOT_FOUND response
 *
 * @author edmaputra
 * @since 1.0
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class DataNotFoundException extends Exception {

    /**
     * Default Message for this Custom Exception
     */
    private static final String DEFAULT_MESSAGE = "Data Not Found";
    private static final Logger log = LoggerFactory.getLogger(DataNotFoundException.class);

    /**
     * Default Constructor
     *
     * @since 1.0
     */
    public DataNotFoundException() {
    }

    /**
     * Exception Constructor with Entity Object
     *
     * @param message
     * @since 1.0
     */
    public DataNotFoundException(String entity) {
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
    public DataNotFoundException(String layer, String entity) {
        super(DEFAULT_MESSAGE);
        log.warn(new LogEntity(layer, entity, DEFAULT_MESSAGE).toString());
    }
}
