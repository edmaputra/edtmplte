package io.github.edmaputra.edtmplte.repository;

import io.github.edmaputra.edtmplte.domain.ABaseEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;

/**
 * Base Repository interface with QueryDsl that use {@link NoRepositoryBean} annotation to prevent generate it as a bean.
 *
 * @author edmaputra
 * @since 1.0
 */
@NoRepositoryBean
public interface ABaseQueryDslRepository<T extends ABaseEntity, ID> extends ABaseRepository<T, ID>, QuerydslPredicateExecutor<T> {

}
