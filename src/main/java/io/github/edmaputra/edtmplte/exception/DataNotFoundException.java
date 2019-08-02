package io.github.edmaputra.edtmplte.exception;

import org.springframework.data.domain.Page;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


/**
 * Data Not Found Exception, with {@link HttpStatus} NOT_FOUND response
 *
 * @author edmaputra
 * @since 1.0
 */
@ResponseStatus(
        value = HttpStatus.NOT_FOUND,
        reason = "Data Not Found"
)
public class DataNotFoundException extends Exception {

    /**
     * Default Constructor
     *
     * @since 1.0
     */
    public DataNotFoundException() {
    }

    /**
     * Exception Constructor with message
     *
     * @param message
     * @since 1.0
     */
    public DataNotFoundException(String message) {
        super(message);
    }
}
