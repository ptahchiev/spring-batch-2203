package org.test.repository;

import java.io.Serializable;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

@NoRepositoryBean
// @Secured(value = { "ROLE_ADMIN" })
public interface BaseEntityRepository<T, PK extends Serializable> extends Repository<T, PK> {

    /**
     * Retrieves and entity by its UID which can be NOT unique. For example CatalogableEntities have the same uid for
     * every catalog version
     * 
     * @param uid
     * @param pageable
     * @return
     */
    Page<T> findByUid(@Param("uid") final String uid, final Pageable pageable);
}
