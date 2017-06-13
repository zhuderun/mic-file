/**
 * 
 */
package com.haoyu.file.listener;

import java.util.Date;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.quartz.DateBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.haoyu.file.domain.VirtualFile;
import com.haoyu.file.event.CreateVirtualFileEvent;
import com.haoyu.file.task.DeleteVirtualFileJob;

/**
 * @author Administrator
 *
 */
@Component
public class CreateVirtualFileListener implements ApplicationListener<CreateVirtualFileEvent>{
	
	@Resource
    private Scheduler scheduler;
	
	private Logger logger = LoggerFactory.getLogger(CreateVirtualFileListener.class);

	/* (non-Javadoc)
	 * @see org.springframework.context.ApplicationListener#onApplicationEvent(org.springframework.context.ApplicationEvent)
	 */
	@Override
	public void onApplicationEvent(CreateVirtualFileEvent event) {
		if(event.getSource()!=null){
			VirtualFile vf = (VirtualFile) event.getSource();
			if(StringUtils.isNotEmpty(vf.getId())){
				//创建定时任务删除该vf
				JobDetail job = JobBuilder.newJob(DeleteVirtualFileJob.class).withIdentity(vf.getId()).build();
//				Trigger trigger = TriggerBuilder.newTrigger().withIdentity(vf.getId()).startAt(DateBuilder.nextGivenMinuteDate(new Date(), 30)).build();
				Trigger trigger = TriggerBuilder.newTrigger().withIdentity(vf.getId()).startAt(DateBuilder.nextGivenMinuteDate(new Date(), 1)).build();
				try {
					scheduler.scheduleJob(job, trigger);
				} catch (SchedulerException e) {
					logger.error(e.getMessage());
					e.printStackTrace();
				}
				
			}
		}
	}

}
