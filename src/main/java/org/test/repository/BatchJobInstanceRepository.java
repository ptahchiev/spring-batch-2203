package org.test.repository;

import org.springframework.batch.core.repository.dao.JobInstanceDao;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.test.model.BatchJobInstanceModel;

@Repository(value = BatchJobInstanceRepository.NAME)
@RepositoryRestResource(itemResourceRel = BatchJobInstanceModel.NAME, path = BatchJobInstanceModel.NAME)
public interface BatchJobInstanceRepository extends JobInstanceDao, BaseEntityRepository<BatchJobInstanceModel, Long>, PagingAndSortingRepository<BatchJobInstanceModel, Long> {

    public static final String NAME = "batchJobInstanceRepository";
}