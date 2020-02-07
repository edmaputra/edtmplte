package io.github.edmaputra.edtmplte.repository;

import io.github.edmaputra.edtmplte.domain.ABaseEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;

/**
 * Base Repository interface that use {@link NoRepositoryBean} annotation to prevent generate it as a bean.
 *
 * @author edmaputra
 * @since 1.0
 */
@NoRepositoryBean
public interface ABaseRepository<T extends ABaseEntity, ID> extends JpaRepository<T, ID> {

    /**
     * Returns a {@link java.util.Optional} of entities with paging restriction provided in the {@code Pageable} object
     * with recorded field as TRUE
     *
     * @param pageable
     * @return a page of entities
     */
    Optional<Page<T>> findByRecordedTrue(Pageable pageable);

}
