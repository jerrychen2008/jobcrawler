package com.newcapec.jobcrawler.entity;

public class Job {
	
	private int id;
	private String jobName;
	private String companyName;
	private String salRange;
	private String publicDate;
	private String jobDesc;
	private String companyDesc;
	private boolean validated;
	private String createDate;
	private String updateDate;
	public Job() {
		super();
	}
	public Job(int id, String jobName, String companyName, String salRange, String publicDate, String jobDesc,
			String companyDesc, boolean validated, String createDate, String updateDate) {
		super();
		this.id = id;
		this.jobName = jobName;
		this.companyName = companyName;
		this.salRange = salRange;
		this.publicDate = publicDate;
		this.jobDesc = jobDesc;
		this.companyDesc = companyDesc;
		this.validated = validated;
		this.createDate = createDate;
		this.updateDate = updateDate;
	}
	public Job(String jobName, String companyName, String salRange, String publibDate, String jobDesc,
			String companyDesc, boolean validated, String createDate, String updateDate) {
		super();
		this.jobName = jobName;
		this.companyName = companyName;
		this.salRange = salRange;
		this.publicDate = publicDate;
		this.jobDesc = jobDesc;
		this.companyDesc = companyDesc;
		this.validated = validated;
		this.createDate = createDate;
		this.updateDate = updateDate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getJobName() {
		return jobName;
	}
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getSalRange() {
		return salRange;
	}
	public void setSalRange(String salRange) {
		this.salRange = salRange;
	}
	public String getPublicDate() {
		return publicDate;
	}
	public void setPublicDate(String publicDate) {
		this.publicDate = publicDate;
	}
	public String getJobDesc() {
		return jobDesc;
	}
	public void setJobDesc(String jobDesc) {
		this.jobDesc = jobDesc;
	}
	public String getCompanyDesc() {
		return companyDesc;
	}
	public void setCompanyDesc(String companyDesc) {
		this.companyDesc = companyDesc;
	}
	public boolean isValidated() {
		return validated;
	}
	public void setValidated(boolean validated) {
		this.validated = validated;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}
	
	
	@Override
	public String toString() {
		return "Job [id=" + id + ", jobName=" + jobName + ", companyName=" + companyName + ", salRange=" + salRange
				+ ", publibDate=" + publicDate + ", jobDesc=" + jobDesc + ", companyDesc=" + companyDesc
				+ ", validated=" + validated + ", createDate=" + createDate + ", updateDate=" + updateDate + "]";
	}
	
	
	
	

}
