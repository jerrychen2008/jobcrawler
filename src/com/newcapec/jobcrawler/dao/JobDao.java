package com.newcapec.jobcrawler.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.newcapec.jobcrawler.entity.Job;
import com.newcapec.jobcrawler.util.DBUtil;

public class JobDao {

	public void addJob(Job job) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DBUtil.getConnection();
			String sql = "INSERT INTO `jobcrawler`.`t_jobs`" + " (`jobname`,`companyname`,`salrange`,`publicdate`,"
					+ "`jobdesc`,`companydesc`,`validated`,`createdate`,`updatedate`)" + "VALUES "
					+ "(?,?,?,?,?,?,?,?,?);";

			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, job.getJobName());
			pstmt.setString(2, job.getCompanyName());
			pstmt.setString(3, job.getSalRange());
			pstmt.setString(4, job.getPublicDate());
			pstmt.setString(5, job.getJobDesc());
			pstmt.setString(6, job.getCompanyDesc());
			pstmt.setInt(7, job.isValidated() ? 1 : 0);
			pstmt.setString(8, job.getCreateDate());
			pstmt.setString(9, job.getUpdateDate());

			int resultRows = pstmt.executeUpdate();

			System.out.println("受影响的行数：" + resultRows);

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			DBUtil.myClose(null, pstmt, con);
		}

	}

	public void updateJob(Job job) {

	}

	public void deleteJob(int id) {

	}

}
