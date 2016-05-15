package Comm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class JDBCUtils {
	static int sum = 1;
	
	private Connection conn;
	private String url;
	private String user;
	private String password;
	
	/**
	 * 添加数据
	 * */
	public void addData(Data data) throws Exception{
		DriverManager.registerDriver(new Driver());
		url = "jdbc:mysql://localhost:3306/data";
		user = "root";
		password = "";

		conn = DriverManager.getConnection(url, user, password);
		
		String sql = "insert into data(id, soilTemperature, soilHumidity, airTemperature, airHumidity, currentTime) values ('" + 
				sum + "','" + 
				data.soilTemperature + "','" +
				data.soilHumidity + "','" +
				data.airTemperature + "','" +
				data.airHumidity + "','" +
				data.currentTime +"');";
		Statement stmt = conn.createStatement();
		stmt.executeUpdate(sql);
		if(sum > 15){
			deleteData(sum - 15);
		}
		sum++;
		System.out.println("已存入数据库!");
	}
	/**
	 * 删除数据
	 * */
	public void deleteData(int id) throws Exception{
		String sql = "delete from data where id="+id; 
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.executeUpdate(sql);
		System.out.println("第"+id+"行删除成功");
	}
}
