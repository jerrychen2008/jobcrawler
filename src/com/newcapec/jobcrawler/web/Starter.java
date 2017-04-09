package com.newcapec.jobcrawler.web;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import com.newcapec.jobcrawler.entity.Job;
import com.newcapec.jobcrawler.service.JobService;
import com.newcapec.jobcrawler.util.PureNetUtil;

public class Starter {

	//需要过滤的公司名称
	static String extendCompanies = "智游|英之诚企业管理咨询|昂那克软件";
	/**
	 * 程序入口
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println(">>>>>>>>>>>>>>欢迎使用招聘数据采集项目<<<<<<<<<<<<<<<<<");
		Scanner s = new Scanner(System.in);
		while (true) {
			System.out.println("\n\n");
			System.out.println("请输入你期望工作的城市(如： 郑州)：");
			String city = "";
			s = new Scanner(System.in);
			while (true) {
				city = s.nextLine();
				if ("".equals(city)) {
					System.out.println("城市不能为空，请重新输入：");
				} else {
					break;
				}
			}
			System.out.println("请输入你期望的工作职位（如： java）：");
			String job = "";

			while (true) {
				job = s.nextLine();
				if ("".equals(job)) {
					System.out.println("工作职位不能为空，请重新输入：");
				} else {
					break;
				}
			}

			String url = "http://sou.zhaopin.com/jobs/searchresult.ashx?jl=" + city + "&kw=" + job
					+ "&sm=0&sg=57a1f48c24c848a79508ba9e057b2bc7&p=1";
			System.out.println("采集招聘网址 " + url);

			
			String[] jobUrls = parseJobUrls(url);
			
			JobService jobService = new JobService();
			for(String jobUrl : jobUrls){
				if(null == jobUrl || jobUrl.isEmpty()){
					continue;
				}
				System.out.println("jobUrl= "+ jobUrl);
				Job assembleJobEntity = assembleJobEntity(jobUrl);
				
				jobService.addJobInfo(assembleJobEntity);
				
			}
			System.out.println("》》》》》》》》采集完毕《《《《《《《《《《《");
		}

	}

	/**
	 * 由查询列表中的结果，解析出每一个招聘工作的具体url
	 * @param url 查询结果
	 * @return 返回一个job url的字符串数组
	 */
	public static String[] parseJobUrls(String url){
		String[] url_list ;
		String html = "";
				  
		html = PureNetUtil.get(url);
		
		Document doc = Jsoup.parse(html);
		
		Element content = doc.getElementById("h_job_id");
		String v = content.attr("value");
		String[] list = v.split("\\|");
		String url_list_str = "";
		for(int i = 0 ;i<list.length;i++){
			
			String url_job = "";
			if(list[i].indexOf("CZ")>-1){
				url_job = list[i].split("_")[0];	
			}else{
				String url1 = list[i].split("J90")[0].replace("CC", "");
				String url2 = list[i].split("J90")[1];
				url2 = url2.split("000_")[0];
				url_job = url1 + url2;
			}
			url_list_str += "http://jobs.zhaopin.com/"+url_job+".htm,";
		}
		url_list_str += ",";
		url_list_str = url_list_str.replace(",,","");
		url_list = url_list_str.split(",");
		return url_list;
	}
	/**
	 * 由招聘工作的具体url 获取html页面内容，然后提取数据，封装成job entity
	 * @param jobUrl
	 * @return Job entity
	 */
	public static Job assembleJobEntity(String jobUrl) {

		Job job = new Job();
		String html = PureNetUtil.get(jobUrl);
		Document doc = Jsoup.parse(html);
		String jobName = doc.select("div.inner-left > h1").first().text();
		String companyName = doc.select("div.inner-left > h2").first().text();
		String salRange = doc.select("div.terminalpage-left > ul > li").first().text().replace("职位月薪：", "");
		String publicDate = doc.select("div.terminalpage-left > ul > li").get(2).text().replace("发布日期：", "");
		String jobDesc = doc.select("div.tab-inner-cont").first().text();
		String companyDesc = doc.select("div.tab-inner-cont").get(1).text();
		
		String[] extend_list = extendCompanies.split("\\|");
		for(int i = 0 ;i<extend_list.length;i++){
			if(companyName.contains(extend_list[i])){
				System.out.println("！！！该公司是要排除的！！！");
				job = null;
				break;
			}
		}
		
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
		return job;
	}

}
