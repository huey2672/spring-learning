package com.huey.learning.spring.batch.quickstart;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {

    @Bean
    public ItemReader<Student> studentItemReader() {
        return new FlatFileItemReaderBuilder<Student>()
                .name("studentItemReader")
                .resource(new ClassPathResource("input.csv"))
                .delimited()
                .names("studentNbr", "studentName", "dateOfBirth", "gender")
                .fieldSetMapper(new BeanWrapperFieldSetMapper<Student>() {{
                    setTargetType(Student.class);
                }})
                .build();
    }

    @Bean
    public ItemProcessor<Student, Student> studentItemProcessor() {
        return item -> "M".equals(item.getGender()) ? item : null;
    }

    @Bean
    public ItemWriter<Student> studentItemWriter() {
        return items -> System.out.println("数据持久化保存：" + items);
    }

    @Bean
    public Step studentImportStep(StepBuilderFactory stepBuilderFactory,
            ItemReader<Student> studentItemReader,
            ItemProcessor<Student, Student> studentItemProcessor,
            ItemWriter<Student> studentItemWriter) {
        return stepBuilderFactory.get("studentImportStep")
                .<Student, Student>chunk(10)
                .reader(studentItemReader)
                .processor(studentItemProcessor)
                .writer(studentItemWriter)
                .build();
    }

    @Bean
    public Job studentImportJob(JobBuilderFactory jobBuilderFactory, Step studentImportStep) {
        return jobBuilderFactory.get("studentImportJob")
                .incrementer(new RunIdIncrementer())
                .flow(studentImportStep)
                .end()
                .build();
    }

}
