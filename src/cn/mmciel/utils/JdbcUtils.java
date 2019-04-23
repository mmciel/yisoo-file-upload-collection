package cn.mmciel.utils;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * jdbc连接池及其相关操作
 * @author mmciel
 *	
 */
public class JdbcUtils {
	private static ComboPooledDataSource  dataSource = new ComboPooledDataSource("yisoo");
	/**
	 * 	 获取数据库连接对象
	 * @return 连接对象
	 */
	public static Connection getConnection() {
		try {
			return dataSource.getConnection();
		} catch (SQLException e) {
			throw new NullPointerException("Connection not get");
		}
	}
	/**
	 * 
	 * @return
	 */
	public static DataSource getDataSource() {
		    return dataSource;
    }
	/**
	 * 归还线程池
	 * @param conn
	 * @param ps
	 * @param rs
	 */
	public static void release(Connection conn, PreparedStatement ps, ResultSet rs){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(ps!=null){
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}


}
