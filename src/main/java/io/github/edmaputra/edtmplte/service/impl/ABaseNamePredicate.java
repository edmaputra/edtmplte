package io.github.edmaputra.edtmplte.service.impl;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.PathBuilder;
import com.querydsl.core.types.dsl.StringPath;
import io.github.edmaputra.edtmplte.domain.ABaseNamedEntity;

public class ABaseNamePredicate {

    private SearchCriteria criteria;

    private String entity;

    public ABaseNamePredicate() {
    }

    public ABaseNamePredicate(SearchCriteria criteria) {
        this.criteria = criteria;
    }

    public ABaseNamePredicate(SearchCriteria criteria, String entity) {
        this.criteria = criteria;
        this.entity = entity;
    }

    public BooleanExpression getPredicate() {
        PathBuilder<ABaseNamedEntity> entityPath = new PathBuilder<>(ABaseNamedEntity.class, entity);

        StringPath path = entityPath.getString(criteria.getKey());
        if (criteria.getOperation().equalsIgnoreCase(":")) {
            return path.containsIgnoreCase(criteria.getValue().toString());
        }

        return null;
    }

}
