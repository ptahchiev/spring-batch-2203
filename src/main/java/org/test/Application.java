package org.test;

import javax.annotation.Resource;

import org.springframework.batch.core.repository.support.SimpleJobRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.test.repository.BatchExecutionContextRepository;
import org.test.repository.BatchJobExecutionRepository;
import org.test.repository.BatchJobInstanceRepository;
import org.test.repository.BatchStepExecutionRepository;

@Configuration
@ComponentScan
@EnableAutoConfiguration
public class Application {

    public static void main(final String[] args) {
        SpringApplication.run(Application.class, args);
    }
    
    @Resource(name = BatchJobExecutionRepository.NAME)
    private BatchJobExecutionRepository batchJobExecutionRepository;
    
    @Resource(name = BatchStepExecutionRepository.NAME)
    private BatchStepExecutionRepository batchStepExecutionRepository;
    
    @Resource(name = BatchJobInstanceRepository.NAME)
    private BatchJobInstanceRepository batchJobInstanceRepository;
    
    @Resource(name = BatchExecutionContextRepository.NAME)
    private BatchExecutionContextRepository batchExecutionContextRepository;
    
    
    @Bean(name = "jobRepository")
    public SimpleJobRepository defaultJobRepository() {
        return new SimpleJobRepository(batchJobInstanceRepository, batchJobExecutionRepository, batchStepExecutionRepository, batchExecutionContextRepository);
    }
    
}
