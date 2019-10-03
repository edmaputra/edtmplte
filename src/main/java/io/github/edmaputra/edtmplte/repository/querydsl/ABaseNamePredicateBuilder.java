package io.github.edmaputra.edtmplte.repository.querydsl;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.Expressions;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ABaseNamePredicateBuilder {

    private List<SearchCriteria> params;

    private String entity;

    public ABaseNamePredicateBuilder() {
        this.params = new ArrayList<>();
    }

    public ABaseNamePredicateBuilder(String entity) {
        this.params = new ArrayList<>();
        this.entity = entity;
    }

    public ABaseNamePredicateBuilder with(String key, String operation, Object value) {
        params.add(new SearchCriteria(key, operation, value));
        return this;
    }

    public BooleanExpression build() {
        if (params.size() == 0) {
            return null;
        }

        List<BooleanExpression> predicates = params.stream().map(param -> {
            ABaseNamePredicate predicate = new ABaseNamePredicate(param, entity );
            return predicate.getPredicate();
        }).filter(Objects::nonNull).collect(Collectors.toList());

        BooleanExpression result = Expressions.asBoolean(true).isTrue();
        for (BooleanExpression p: predicates) {
            result = result.and(p);
        }

        return result;
    }
}
