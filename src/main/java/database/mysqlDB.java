package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class mysqlDB {
	private static String URL;
	private static String USER;
	private static String PASSWORD;
	//获取配置文件信息
	private static ResourceBundle resourcebundle = ResourceBundle.getBundle("mysql-connect");
	//静态方法只加载一次
	static {
		URL = resourcebundle.getString("jdbc.url");
		USER = resourcebundle.getString("jdbc.user");
		PASSWORD = resourcebundle.getString("jdbc.password");
		try {
			Class.forName(resourcebundle.getString("jdbc.driverClassName"));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static Connection getMysqlConnection() {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(URL,USER,PASSWORD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
		
	}
	public static void closeConnection(ResultSet set,Connection conn,Statement sta) {
		if(set!=null) {
			try {
				set.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(sta!=null) {
			try {
				sta.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(conn!=null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
