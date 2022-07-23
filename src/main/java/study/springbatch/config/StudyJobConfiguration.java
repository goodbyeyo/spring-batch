package study.springbatch.config;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@RequiredArgsConstructor
@Configuration
public class StudyJobConfiguration {

    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;

    @Bean
    public Job studyJob(){
        return jobBuilderFactory.get("studyJob")
                .start(studyStep1())
                .next(studyStep2())
                .build();   //Job 인터페이스의 구현체르 생성
    }


    @Bean
    public Step studyStep1() {
        return stepBuilderFactory.get("studyStep1")
                .tasklet(new Tasklet() {    // defalut : 무한반복
                    @Override
                    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
                        System.out.println(" Study Spring Batch Setp1 ");
                        return RepeatStatus.FINISHED;
                    }
                })
                .build();
    }

    @Bean
    public Step studyStep2() {
        return stepBuilderFactory.get("studyStep1")
                .tasklet(new Tasklet() {    // defalut : 무한반복
                    @Override
                    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
                        System.out.println(" Study Spring Batch Setp2 ");
                        return RepeatStatus.FINISHED;
                    }
                })
                .build();
    }
}
