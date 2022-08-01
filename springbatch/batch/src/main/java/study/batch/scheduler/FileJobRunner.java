package study.batch.scheduler;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class FileJobRunner extends JobRunner {

    @Autowired
    private Scheduler scheduler;

    @Override
    protected void dorRun(ApplicationArguments args) {
        String[] sourceArgs = args.getSourceArgs(); // 어플리케이션 program argument 로 넘긴 파라미터 값
        JobDetail jobDetail = buildJobDetail(FileSchJob.class, "fileJob", "batch", new HashMap());
        Trigger trigger = buildJobTrigger("0/40 * * * * ?");
        jobDetail.getJobDataMap().put("requestDate", sourceArgs[0]);    // 스프링 배치로 전달

        try {
            scheduler.scheduleJob(jobDetail, trigger);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }
}
