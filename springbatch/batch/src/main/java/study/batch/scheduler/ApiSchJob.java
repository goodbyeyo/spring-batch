package study.batch.scheduler;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class ApiSchJob extends QuartzJobBean{

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {

    }
}
