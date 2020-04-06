package cn.swu.edu.javaweb.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

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
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    private static DataSource dataSource = null;

    //数据源的初始化要放到静态代码块中，因为数据源只能创建一次
    static {
        dataSource = new ComboPooledDataSource("homeworkApp");
    }
    /**
     * 返回数据源的一个connection对象
     * @return
     */
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
    
  //关闭资源
    public static void closeAll(ResultSet resultSet, PreparedStatement preparedStatement, Connection connection) {
        if(resultSet != null) {
            try {
                resultSet.close();
            } catch(SQLException e) {
                e.printStackTrace();
            }
        }

        if(preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch(SQLException e) {
                e.printStackTrace();
            }
        }

        if(connection != null) {
            try {
                connection.close();
            } catch(SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
