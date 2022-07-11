package co.micol.prj.comm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//싱글톤 클래스 DAO
public class DataSource {
	private static DataSource dataSource = new DataSource(); // 인스턴스 생성 ★★★
	private Connection conn;
	
	private DataSource() { // 남들이 생성하지 못하도록 private 생성자 생성 ★★★
	} // DataSource() 끝
	
	public static DataSource getInstance() {// static getInstance를 통해 인스턴스를 return ★★★
		return dataSource;
	} //getInstance() 끝
	
	public Connection getConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","micol","1234");
			System.out.println("DB 연결 성공");
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			System.out.println("DB 연결 실패");
		}
		return conn;
	}//getConnection() 끝

} //DataSource 끝
