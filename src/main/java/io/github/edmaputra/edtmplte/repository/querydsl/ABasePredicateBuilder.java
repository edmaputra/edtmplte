package io.github.edmaputra.edtmplte.repository.querydsl;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.Expressions;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ABasePredicateBuilder {

    private List<SearchCriteria> params;

    private String entity;

    public ABasePredicateBuilder() {
        this.params = new ArrayList<>();
    }

    public ABasePredicateBuilder(String entity) {
        this.params = new ArrayList<>();
        this.entity = entity;
    }

    public ABasePredicateBuilder with(String key, String operation, Object value) {
        params.add(new SearchCriteria(key, operation, value));
        return this;
    }

    public ABasePredicateBuilder with(String key, String operation, Object value, DataType dataType) {
        params.add(new SearchCriteria(key, operation, value, dataType));
        return this;
    }

    public BooleanExpression build() {
        if (params.size() == 0) {
            return null;
        }

        List<BooleanExpression> predicates = params.stream().map(param -> {
            ABasePredicate predicate = new ABasePredicate(param, entity);
            return predicate.getPredicate();
        }).filter(Objects::nonNull).collect(Collectors.toList());

        BooleanExpression result = Expressions.asBoolean(true).isTrue();
        for (BooleanExpression p : predicates) {
            result = result.and(p);
        }

        return result;
    }

    public BooleanExpression buildOr() {
        if (params.size() == 0) {
            return null;
        }

        List<BooleanExpression> predicates = params.stream().map(param -> {
            ABasePredicate predicate = new ABasePredicate(param, entity);
            System.out.println(predicate.getPredicate());
            return predicate.getPredicate();
        }).filter(Objects::nonNull).collect(Collectors.toList());

        BooleanExpression result = Expressions.asBoolean(true).isTrue();
        for (BooleanExpression p : predicates) {
            result = result.or(p);
        }

        return result;
    }
}
