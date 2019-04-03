package cn.swu.edu.test;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import cn.swu.edu.db.JdbcUtils;

public class JdbcUtilsTest {

	@Test
	void testGetConnection() throws SQLException {
		Connection connection = JdbcUtils.getConnection();
		System.out.println(connection);
	}

}
