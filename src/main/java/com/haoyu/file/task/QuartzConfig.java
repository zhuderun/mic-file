package com.haoyu.file.task;

import java.io.IOException;
import java.util.Properties;

import org.quartz.Scheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

@Configuration
public class QuartzConfig {
	
	@Autowired
	private SpringJobFactory springJobFactory;

	@Bean
	public SchedulerFactoryBean schedulerFactoryBean() {
		SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
		Properties properties  = new Properties();
		
		try {
			properties.load(QuartzConfig.class.getClassLoader().getResourceAsStream("quartz.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		schedulerFactoryBean.setQuartzProperties(properties);
		schedulerFactoryBean.setJobFactory(springJobFactory);
		return schedulerFactoryBean;
	}

	@Bean
	public Scheduler scheduler() {
		return schedulerFactoryBean().getScheduler();
	}
}