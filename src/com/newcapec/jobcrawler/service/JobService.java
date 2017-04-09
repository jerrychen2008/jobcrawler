package com.newcapec.jobcrawler.service;

import com.newcapec.jobcrawler.dao.JobDao;
import com.newcapec.jobcrawler.entity.Job;

public class JobService {
	
	// 对dao层对象的引用
	private JobDao jobDao = new JobDao();
	
	/**
	 * 添加招聘工作信息
	 * @param job pojo
	 */
	public void addJobInfo(Job job){
		
		jobDao.addJob(job);
		
	}

}
