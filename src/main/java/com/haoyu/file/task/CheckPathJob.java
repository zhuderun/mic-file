/**
 * 
 */
package com.haoyu.file.task;

import org.apache.commons.lang3.StringUtils;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;
import org.quartz.SchedulerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @author Administrator
 *
 */
public class CheckPathJob implements Job{
	
	private Logger logger = LoggerFactory.getLogger(CheckPathJob.class);

	/**
	 * 检查校验地址的合法性，合法则取消删除刚上传的vf
	 * @see com.haoyu.file.event.UpdateVirtualFileCheckPathEvent
	 */
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		 JobDataMap data = context.getJobDetail().getJobDataMap();
		 
		 String virtualFileId = data.getString("virtualFileId");
		 String relationId = data.getString("relationId");
		 String checkPath = data.getString("checkPath");
		 if(!StringUtils.isAnyEmpty(virtualFileId,relationId,checkPath)){
			 if(check(checkPath,relationId)){
				 try {
					if(context.getScheduler().checkExists(JobKey.jobKey(virtualFileId))){
						context.getScheduler().deleteJob(JobKey.jobKey(virtualFileId));
					}else{
						context.getScheduler().deleteJob(context.getJobDetail().getKey());
					}
				} catch (SchedulerException e) {
					logger.error(e.getMessage());
					e.printStackTrace();
				}
			 }
		 }
	}
	
	private boolean check(String checkPath,String relationId){
		return true;
	}

}
