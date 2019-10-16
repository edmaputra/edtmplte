package io.github.edmaputra.edtmplte.repository.querydsl;

import com.querydsl.core.types.dsl.BooleanExpression;
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

        StringPath path = entityPath.getString(criteria.getKey());
        if (criteria.getOperation().equalsIgnoreCase(":")) {
            return path.containsIgnoreCase(criteria.getValue().toString());
        }

        return null;
    }

}
