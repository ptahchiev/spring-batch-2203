package org.test.repository;

import org.springframework.batch.core.repository.dao.JobExecutionDao;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.test.model.BatchJobExecutionModel;
import org.test.model.BatchJobInstanceModel;

@Repository(value = BatchJobExecutionRepository.NAME)
@RepositoryRestResource(itemResourceRel = BatchJobExecutionModel.NAME, path = BatchJobExecutionModel.NAME)
public interface BatchJobExecutionRepository extends JobExecutionDao, BaseEntityRepository<BatchJobExecutionModel, Long>, PagingAndSortingRepository<BatchJobExecutionModel, Long> {

    public static final String NAME = "batchJobExecutionRepository";

    Iterable<BatchJobExecutionModel> findAllByJobInstance(BatchJobInstanceModel batchJobInstanceModel);
}