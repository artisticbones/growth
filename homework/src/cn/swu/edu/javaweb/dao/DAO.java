package cn.swu.edu.javaweb.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import cn.swu.edu.javaweb.db.JdbcUtils;

/**
 * 封装了基本的CRUD的方法，以供子类使用
 * 当前DAO 直接在方法中获取数据库的链接
 * @param <T>:当前DAO 处理的实体类的类型是什么
 * @author artisticbones
 * @param <K>
 */
public class DAO<T> {

    private QueryRunner queryRunner = new QueryRunner();

    private Class<T> clazz;
    
    //private Class<K> clazz2;

    public DAO() {
        Type superClass = getClass().getGenericSuperclass();

        if (superClass instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType)superClass;

            Type[] typeArgs = parameterizedType.getActualTypeArguments();
            if(typeArgs != null && typeArgs.length > 0) {
                if(typeArgs[0] instanceof Class) {
                    clazz = (Class<T>) typeArgs[0];
                   // clazz2 = (Class<K>) typeArgs[0];
                }
            }
        }
    }
    /**
     * 返回某一个字段的值：例如返回某一条记录的customerName,或返回数据表中有多少条记录等。
     * @param sql
     * @param args
     * @return
     */
    public <E> E getForValue(String sql,Object ...args) {
        Connection connection = null;

        try {
            connection = JdbcUtils.getConnection();
            return (E) queryRunner.query(connection, sql, new ScalarHandler<>() ,args);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            JdbcUtils.releaseConnection(connection);
        }

        return null;
    }

//    public Map<T, K> getForMap(String sql,Object ...args) {
//		Connection connection = null;
//		
//		try {
//			connection = JdbcUtils.getConnection();
//			return (Map<T, K>) queryRunner.query(connection, sql, new MapListHandler(),args);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//    	
//    	return null;
//    }
    /**
     * 返回T所对应的list
     * @param sql
     * @param args
     * @return
     */
    public List<T> getForList(String sql, Object ... args) {
        Connection connection = null;

        try {
            connection = JdbcUtils.getConnection();
            return queryRunner.query(connection, sql, new BeanListHandler<T>(clazz) ,args);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            JdbcUtils.releaseConnection(connection);
        }

        return null;
    }

    /**
     * 返回对应的T的一个实例类对象
     * @param sql
     * @param args
     * @return
     */
    public T get(String sql,Object ...args ) {

        Connection connection = null;

        try {
            connection = JdbcUtils.getConnection();
            return queryRunner.query(connection, sql, new BeanHandler<T>(clazz), args);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            JdbcUtils.releaseConnection(connection);
        }
        return null;
    }
    /**
     * 该方法封装了INSERT、DELETE、UPDATE 操作
     * @param sql:SQL语句
     * @param args: 填充SQL的占位符
     */
    public void update(String sql,Object ... args) {
        Connection connection = null;

        try {
            connection = JdbcUtils.getConnection();
            queryRunner.update(connection,sql,args);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            JdbcUtils.releaseConnection(connection);
        }
    }
}
