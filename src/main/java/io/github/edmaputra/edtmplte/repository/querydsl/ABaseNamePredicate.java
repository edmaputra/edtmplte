package io.github.edmaputra.edtmplte.repository.querydsl;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.PathBuilder;
import com.querydsl.core.types.dsl.StringPath;
import io.github.edmaputra.edtmplte.domain.ABaseIdEntity;

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
        PathBuilder<ABaseIdEntity> entityPath = new PathBuilder<>(ABaseIdEntity.class, entity);

        StringPath path = entityPath.getString(criteria.getKey());
        if (criteria.getOperation().equalsIgnoreCase(":")) {
            return path.containsIgnoreCase(criteria.getValue().toString());
        }

        return null;
    }

}
