package io.github.edmaputra.edtmplte.repository.querydsl;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.BooleanPath;
import com.querydsl.core.types.dsl.PathBuilder;
import com.querydsl.core.types.dsl.StringPath;
import io.github.edmaputra.edtmplte.domain.ABaseEntity;
import io.github.edmaputra.edtmplte.domain.ABaseNamedEntity;

public class ABasePredicate {

    private SearchCriteria criteria;

    private String entity;

    public ABasePredicate() {
    }

    public ABasePredicate(SearchCriteria criteria) {
        this.criteria = criteria;
    }

    public ABasePredicate(SearchCriteria criteria, String entity) {
        this.criteria = criteria;
        this.entity = entity;
    }

    public BooleanExpression getPredicate() {
        PathBuilder<ABaseEntity> entityPath = new PathBuilder<>(ABaseEntity.class, entity);
        if(criteria.getDataType().equals(DataType.STRING)) {
            StringPath path = entityPath.getString(criteria.getKey());
            if (criteria.getOperation().equalsIgnoreCase(":")) {
                return path.containsIgnoreCase(criteria.getValue().toString());
            }
        }
        else if(criteria.getDataType().equals(DataType.BOOLEAN)) {
            BooleanPath path = entityPath.getBoolean(criteria.getKey());
            return path.eq((Boolean) criteria.getValue());
        }

        return null;
    }

}
