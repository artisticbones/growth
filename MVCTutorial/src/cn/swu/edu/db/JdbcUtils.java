package cn.swu.edu.db;

import java.sql.Connection;

/**
 * JDBC 操作的工具类
 * @author artisticbones
 *
 */
public class JdbcUtils {
	
	
	/**
	 * 释放Connection连接
	 * @param connection
	 */
	public static void releaseConnection(Connection connection) {
		
	}
	/**
	 * 返回数据源的一个connection对象
	 * @return
	 */
	public static Connection getConnection() {
		return null;
	}
}
