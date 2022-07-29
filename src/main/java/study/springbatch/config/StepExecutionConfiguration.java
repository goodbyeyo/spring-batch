//package study.springbatch.config;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.Step;
//import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
//import org.springframework.batch.repeat.RepeatStatus;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import study.springbatch.tasklet.CustomTasklet;
//
//@Configuration
//@RequiredArgsConstructor
//public class StepExecutionConfiguration {
//
//    private final JobBuilderFactory jobBuilderFactory;
//    private final StepBuilderFactory stepBuilderFactory;
//
//    @Bean   // 싱글톤 빈으로 생성
//    public Job BatchJob() {
//        return jobBuilderFactory.get("Job")
//                .start(step1())
//                .next(step2())
//                .build();
//    }
//
//    @Bean
//    public Step step1() {
//        return stepBuilderFactory.get("step1")
//                .tasklet(new CustomTasklet())
//                .build();
//    }
//
//    @Bean
//    public Step step2() {
//        return stepBuilderFactory.get("step2")
//                .tasklet((contribution, chunkContext) -> {
//                    System.out.println("step2 has executed");
//                    return RepeatStatus.FINISHED;
//                })
//                .build();
//    }
//
//    @Bean
//    public Step step3() {
//        return stepBuilderFactory.get("step3")
//                .tasklet((contribution, chunkContext) -> {
//                    System.out.println("step3 has executed");
//                    return RepeatStatus.FINISHED;
//                })
//                .build();
//    }
//
//}
