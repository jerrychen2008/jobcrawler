package com.newcapec.jobcrawler.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * 数据库连接工具类
 * @author jerrychen
 *
 */
public class DBUtil {

	/**
	 * JDBC 四大参数
	 */
	private static String driver =null;
	private static String url =null;
	private static String dbuser =null;
	private static String dbpassword =null;
	
	/**
	 * 静态代码块，类加载后即可执行，只执行一次。
	 */
	static{
		Properties p = new Properties();
		InputStream is = null;
		
		try {
			
			is = DBUtil.class.getClassLoader().getResourceAsStream("db_mysql.properties");
			p.load(is);// 将配置文件的内容 读入java对象p（Properties）中。
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally{
			if(is!=null){
				try {
					is.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				finally{
					is = null;
				}
			}
		}
		
		/**
		 * 从properties对象的属性中，读取四大参数的值，并赋值给四个成员变量
		 */
		driver = p.getProperty("driverClass"); // 双引号中的名字driver必须要跟db_mysql.properties文件中的名字一样
		url = p.getProperty("url"); // 双引号中的名字url必须要跟db_mysql.properties文件中的名字一样
		dbuser = p.getProperty("username"); // 双引号中的名字user必须要跟db_mysql.properties文件中的名字一样
		dbpassword = p.getProperty("password"); // 双引号中的名字password必须要跟db_mysql.properties文件中的名字一样
		
		
		try {
			Class.forName(driver); //将驱动加载到jvm虚拟机中，这里使用到了反射技术
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 私有构造方法，是为了抑制jvm自动帮我们添加公有无参构造方法
	 */
	private DBUtil()
	{
	}
	
	
	/**
	 * 创建数据库的连接对象,并返回对象的引用
	 * @return Connection对象
	 */
	public static Connection getConnection(){
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, dbuser, dbpassword);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	/**
	 * 关闭jdbc系统资源，防止内存泄漏
	 * @param rs ResultSet对象
	 * @param stmt Statement对象
	 * @param con Connection对象
	 */
	public static void myClose(ResultSet rs, Statement stmt,Connection con){
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			finally{
				rs = null;
			}
			
		}
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			finally{
				stmt = null;
			}
		}
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			finally{
				con = null;
			}
		}
	}
}
