/**
 * 
 */
package com.haoyu.file.listener;


import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.haoyu.file.domain.VirtualFile;
import com.haoyu.file.event.UpdateVirtualFileCheckPathEvent;
import com.haoyu.file.service.IVirtualFileService;
import com.haoyu.file.task.CheckPathJob;

/**
 * @author Administrator
 *
 */
@Component
public class UpdateVirtualFileCheckPathListener implements ApplicationListener<UpdateVirtualFileCheckPathEvent>{
	
	@Resource
	Scheduler scheduler;
	@Resource
	private IVirtualFileService virtualFileService;

	private Logger logger = LoggerFactory.getLogger(CreateVirtualFileListener.class);
	
	@Override
	public void onApplicationEvent(UpdateVirtualFileCheckPathEvent event) {
		//发起定时任务校验checkPath是否有效,有效则取消删除virtual的定时任务
		if(event.getSource()!=null){
			VirtualFile vf = (VirtualFile) event.getSource();
			vf = virtualFileService.findById(vf.getId());
			if(StringUtils.isNotEmpty(vf.getRelationId()) && StringUtils.isNotEmpty(vf.getId())){
				//总共检查三次，间隔5分钟
				JobDetail job = JobBuilder.newJob(CheckPathJob.class).usingJobData("virtualFileId", vf.getId()).usingJobData("checkPath", vf.getCheckPath()).usingJobData("relationId",vf.getRelationId()).withIdentity("checkGroup",vf.getId()).build();
				Trigger trigger = TriggerBuilder.newTrigger().withIdentity("checkGroup",vf.getId()).startNow().withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(5).withRepeatCount(2)).build();
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
