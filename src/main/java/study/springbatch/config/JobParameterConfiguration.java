//package study.springbatch.config;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.JobParameters;
//import org.springframework.batch.core.Step;
//import org.springframework.batch.core.StepContribution;
//import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
//import org.springframework.batch.core.scope.context.ChunkContext;
//import org.springframework.batch.core.step.tasklet.Tasklet;
//import org.springframework.batch.repeat.RepeatStatus;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.Map;
//
//
//@RequiredArgsConstructor
//@Configuration
//public class JobParameterConfiguration {
//
//    private final JobBuilderFactory jobBuilderFactory;
//    private final StepBuilderFactory stepBuilderFactory;
//
//    @Bean   // 싱글톤 빈으로 생성
//    public Job job() {
//        return jobBuilderFactory.get("job")
//                .start(step1())
//                .next(step2())
//                .build();
//    }
//
//    @Bean
//    public Step step1() {
//        return stepBuilderFactory.get("step1")
//                .tasklet(new Tasklet() {
//                    // StepContribution, ChunkContext 에서 JobParameter 값을 모두 참조할수 있다
//                    @Override
//                    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
//                        JobParameters jobParameters = contribution.getStepExecution().getJobExecution().getJobParameters();
//                        System.out.println("jobParameters.getString(\"name\") = " + jobParameters.getString("name"));
//                        System.out.println("jobParameters.getSeq(\"seq\") = " + jobParameters.getLong("seq"));
//                        System.out.println("jobParameters.getDate(\"date\") = " + jobParameters.getDate("date"));
//                        System.out.println("jobParameters.getDouble(\"seq\") = " + jobParameters.getDouble("age"));
//
//                        Map<String, Object> jobChunkParameters = chunkContext.getStepContext().getJobParameters();
//                        System.out.println("jobChunkParameters = " + jobChunkParameters.toString());
//                        System.out.println("step1 was executed");
//                        return RepeatStatus.FINISHED;
//                    }
//                }).build();
//    }
//
//    @Bean
//    public Step step2() {
//        return stepBuilderFactory.get("step2")
//                .tasklet(new Tasklet() {
//                    @Override
//                    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
//                        System.out.println("step2 was executed");
////                        throw new RuntimeException("step has failed");
//                        return RepeatStatus.FINISHED;
//                    }
//                }).build();
//    }
//}
