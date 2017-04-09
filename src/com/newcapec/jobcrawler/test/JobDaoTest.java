package com.newcapec.jobcrawler.test;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import com.newcapec.jobcrawler.entity.Job;
import com.newcapec.jobcrawler.service.JobService;

public class JobDaoTest {
	
	@Test
	public void addJobTest(){
		
		JobService js = new JobService();
		Job job = new Job();
		String jobName = "Java实习生";
		String companyName = "郑州戌轮教育科技有限公司";
		String salRange = "6001-8000元/月";
		String publicDate = "017-04-01";
		String jobDesc = "岗位要求： 1. 在校生、应届毕业生及工作经验一年以下人员。 2. 大专及以上学历，理工科专业，计算机专业优先。 3. 有良好的逻辑思维能力，基本的英语阅读和书写能力。 岗位职责： 1. 从事公司项目组项目研发工作；2. 实习期4.5个月，转正后可选择到上海或者郑州任职，薪资上海6K起，上海4K起。'";
		String companyDesc = "xxxxxxxx";
		
		boolean validated = true;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		
		String createDate = sdf.format(date);
		String updateDate = createDate;
		
		job.setJobName(jobName);
		job.setCompanyName(companyName);
		job.setSalRange(salRange);
		job.setPublicDate(publicDate);
		job.setJobDesc(jobDesc);
		job.setCompanyDesc(companyDesc);
		job.setValidated(validated);
		job.setCreateDate(createDate);
		job.setUpdateDate(updateDate);
		
		js.addJobInfo(job);
		
	}

}
