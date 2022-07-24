package com.test.spring.batch.config;

import com.test.spring.batch.entity.LetterHistDb2;
import com.test.spring.batch.entity.LetterHistDest;
import com.test.spring.batch.repository.db1.Db2Repository;
import com.test.spring.batch.repository.db2.DestRepository;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;

@Configuration
@EnableBatchProcessing
@Slf4j
@Data
public class testBatch {
@Autowired
    private JobBuilderFactory jobBuilderFactory;
@Autowired
    private StepBuilderFactory stepBuilderFactory;

@Autowired
    private Db2Repository db2Repository;
@Autowired
    private DestRepository destRepository;
@Autowired
MyCustomReader myCustomReader;


//    @Bean
//    public ItemReader<LetterHistDb2> reader() {
//        RepositoryItemReader<LetterHistDb2> itemReader = new RepositoryItemReader<>();
//        itemReader.setRepository(db2Repository);
//        itemReader.setPageSize(1000);
//        itemReader.setMethodName("findAll");
//        HashMap sorts = new HashMap<>();
//        sorts.put("id", Sort.Direction.ASC);
//        itemReader.setSort(sorts);
//        return itemReader;
//    }

    @Bean
    public CustomerProcessor processor() {
        return new CustomerProcessor();
    }

    @Bean
    public RepositoryItemWriter<LetterHistDest> writer() {
        RepositoryItemWriter<LetterHistDest> writer = new RepositoryItemWriter<>();
        writer.setRepository(destRepository);
        writer.setMethodName("save(letterHistDb2)");
        return writer;
    }

    @Bean
    public Step step1() {
        return stepBuilderFactory.get("csv-step").<LetterHistDb2, LetterHistDest>chunk(1)
                .reader(myCustomReader)
                .processor(processor())
                .writer(writer())
                .taskExecutor(taskExecutor())
                .build();
    }

    @Bean
    public Job runJob() {
        return jobBuilderFactory.get("importCustomers")
                .flow(step1()).end().build();

    }

    @Bean
    public TaskExecutor taskExecutor() {
        SimpleAsyncTaskExecutor asyncTaskExecutor = new SimpleAsyncTaskExecutor();
        asyncTaskExecutor.setConcurrencyLimit(10);
        return asyncTaskExecutor;
    }

}
