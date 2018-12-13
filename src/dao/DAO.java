package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class DAO {
	private final String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	private final String username = "c##brian";
	private final String password = "ccpgO#323";
	
	protected Connection conn = null;
	protected PreparedStatement ps = null;
	protected ResultSet rs = null;
	
	public void connect() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			System.out.println("/nCouldn't connect to the database.../n");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void dispose() {
		try {
			rs.close();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			System.out.println("\nCouldn't close out try force stopping the program.\n");
		} catch(NullPointerException e) {			
		}
	}

	public Connection getConn() {
		return conn;
	}

	public String getUrl() {
		return url;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}
	
}
