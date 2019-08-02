package io.github.edmaputra.edtmplte.repository;

import io.github.edmaputra.edtmplte.domain.ABaseEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Base Repository interface that use {@link NoRepositoryBean} annotation to prevent generate it as a bean.
 * @since 1.0
 * @author edmaputra
 */
@NoRepositoryBean
public interface ABaseRepository<T extends ABaseEntity, ID> extends PagingAndSortingRepository<T, ID> {

    /**
     * Returns a {@link Page} of entities with paging restriction provided in the {@code Pageable} object
     * with recorded field as TRUE
     *
     * @param pageable
     * @return a page of entities
     */
    Page<T> findByRecordedTrue(Pageable pageable);

}
