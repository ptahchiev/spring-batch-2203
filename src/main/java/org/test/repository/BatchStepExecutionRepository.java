package org.test.repository;

import org.springframework.batch.core.repository.dao.StepExecutionDao;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.test.model.BatchStepExecutionModel;

@Repository(value = BatchStepExecutionRepository.NAME)
@RepositoryRestResource(itemResourceRel = BatchStepExecutionModel.NAME, path = BatchStepExecutionModel.NAME)
public interface BatchStepExecutionRepository extends StepExecutionDao, BaseEntityRepository<BatchStepExecutionModel, Long>, PagingAndSortingRepository<BatchStepExecutionModel, Long> {

    public static final String NAME = "batchStepExecutionRepository";
}
