/**
 * 
 */
package com.haoyu.file.task;

import javax.annotation.Resource;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;

import com.haoyu.file.service.IVirtualFileService;

/**
 * @author Administrator
 *
 */
public class DeleteVirtualFileJob implements Job{
	@Resource
	private IVirtualFileService virtualFileService;
	
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		JobKey jobKey = context.getJobDetail().getKey();
		String name = jobKey.getName();
		
		virtualFileService.deletePhysicsById(name);
		
	}

}
