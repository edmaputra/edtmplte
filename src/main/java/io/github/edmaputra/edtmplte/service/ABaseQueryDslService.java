package io.github.edmaputra.edtmplte.service;

import java.io.Serializable;

public interface ABaseQueryDslService<T extends Serializable, ID> extends ABaseService<T, ID>{

    String printFilterableFields();

    String printSimpleName();

}
