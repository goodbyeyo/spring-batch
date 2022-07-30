package study.batch.batchService.listener;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

import java.util.Objects;

public class ApiJobListener implements JobExecutionListener {

    @Override
    public void beforeJob(JobExecution jobExecution) {

    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        long time = Objects.requireNonNull(jobExecution.getEndTime()).getTime() - Objects.requireNonNull(jobExecution.getStartTime()).getTime();
        System.out.println("총 소요시간 = " + time);

    }
}
