package com.test.spring.batch.config;

import com.test.spring.batch.entity.source.LetterHistDb2;
import com.test.spring.batch.entity.dest.LetterHistDest;
import com.test.spring.batch.repository.db1.Db2Repository;
import com.test.spring.batch.repository.db2.DestRepository;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.data.RepositoryItemReader;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;
import org.springframework.data.domain.Sort;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.HashMap;
import java.util.Optional;
import java.util.concurrent.ThreadPoolExecutor;

@Configuration
@EnableBatchProcessing
@Slf4j
@Data
//@EnableTransactionManagement
public class testBatch {
@Autowired
    private JobBuilderFactory jobBuilderFactory;
@Autowired
    private StepBuilderFactory stepBuilderFactory;

@Autowired
    private Db2Repository db2Repository;

    @Autowired DestRepository  destRepository;

    @Bean
//    @Transactional("primaryTransactionManager")
    public ItemReader<LetterHistDb2> reader() {
        RepositoryItemReader<LetterHistDb2> itemReader = new RepositoryItemReader<>();
        itemReader.setRepository(db2Repository);
        itemReader.setPageSize(10);
        itemReader.setMethodName("findAll");
        HashMap sorts = new HashMap<>();
        sorts.put("acctNbr", Sort.Direction.ASC);
        itemReader.setSort(sorts);
        log.info("inside reader - " +itemReader.toString());
        return itemReader;
    }

    @Bean
    public CustomerProcessor processor() {
        return new CustomerProcessor();
    }



    @Bean
//    @Transactional("secondaryTransactionManager")
    public RepositoryItemWriter<LetterHistDest> writer() {
        log.info("inside writer ");
        RepositoryItemWriter<LetterHistDest> writer = new RepositoryItemWriter<>();
        writer.setRepository(destRepository);

        writer.setMethodName("save");
        return writer;
    }

    @Bean
//    @Transactional("secondaryTransactionManager")
    public Step step1()
            throws Exception {
        log.info("inside step1 ");

//        return this.stepBuilderFactory.get("step1").<LetterHistDb2, LetterHistDest>chunk(5).reader(itemReader)
//                .processor(processor()).writer(itemWriter).build();
        return stepBuilderFactory.get("csv-step11").<LetterHistDb2, LetterHistDest>chunk(10)
                .reader(reader())
                .processor(processor())
                .writer(writer())
//                .transactionManager()
                .taskExecutor(taskExecutor())

                .build();
    }

    @Bean
    public Job runJob(JobCompletionNotificationListener listener, Step step1) {
//        return jobBuilderFactory.get("importCustomers")
//                .flow(step1()).end().build();

        return this.jobBuilderFactory.get("profileUpdateJob").incrementer(new RunIdIncrementer())
                .listener(listener).start(step1).build();
    }
    @Bean
    public TaskExecutor taskExecutor() {
        log.info("task executor");
//        SimpleAsyncTaskExecutor asyncTaskExecutor = new SimpleAsyncTaskExecutor();
//        asyncTaskExecutor.setConcurrencyLimit(200);
//        return asyncTaskExecutor;
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(200);
        executor.setMaxPoolSize(400);
        executor.setQueueCapacity(200);
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executor.setThreadNamePrefix("MultiThreaded-");
        return executor;

    }
}
