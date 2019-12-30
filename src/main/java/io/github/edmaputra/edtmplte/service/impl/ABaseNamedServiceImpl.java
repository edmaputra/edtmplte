package io.github.edmaputra.edtmplte.service.impl;

import io.github.edmaputra.edtmplte.domain.ABaseEntity;
import io.github.edmaputra.edtmplte.domain.ABaseNamedEntity;
import io.github.edmaputra.edtmplte.exception.DataEmptyException;
import io.github.edmaputra.edtmplte.exception.DataNotFoundException;
import io.github.edmaputra.edtmplte.logger.LogEntity;
import io.github.edmaputra.edtmplte.repository.ABaseRepository;
import io.github.edmaputra.edtmplte.service.ABaseNamedService;
import io.github.edmaputra.edtmplte.service.ABaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Optional;

/**
 * Class that implements {@link ABaseService} for Business Object Layer.
 *
 * @param <T>  the domain which extends {@link ABaseEntity}
 * @param <ID> the type of the id of the entity
 * @author edmaputra
 * @since 1.0
 */
public class ABaseNamedServiceImpl<T extends ABaseNamedEntity, ID> extends ABaseServiceImpl implements ABaseNamedService {

    /**
     * Domain Class Name from Generic Class T
     */
    private final String domainClassName;
    private final String layerName = this.getClass().getName();
    private static final Logger log = LoggerFactory.getLogger(ABaseNamedServiceImpl.class);


    /**
     * The Repository
     */
    private ABaseRepository<T, ID> repository;

    public ABaseNamedServiceImpl(ABaseRepository<T, ID> repository) {
        super(repository);
        this.repository = repository;
        this.domainClassName = getGenericName();
    }

    @Override
    public Iterable<T> findByName(String name) throws Exception {
        return null;
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
