package dao;

import java.io.FileReader;
import java.sql.*;
import java.util.Properties;

public class DBHelper {
	public static Connection getConnection() throws Exception {
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		String dbUrl = "jdbc:oracle:thin:@oktobroesperi_high?TNS_ADMIN=d:/oracle_wallet/Wallet_oktobroesperi\r\n";
		String dbUser = "admin";
		FileReader fr = new FileReader("D:\\auth\\oracle.properties");
		Properties prop = new Properties();
		prop.load(fr);
		String dbPw = prop.getProperty("dbPw");
		
		Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPw);
		
		return conn;
	}
	
	public static void main(String[] args) throws Exception {
		Connection conn = DBHelper.getConnection();
		System.out.println(conn);
	}
}
