package com.cafe24.jblog.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class Dao<V> {
	protected Connection getConnection() throws SQLException {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost/jblog";
			conn = DriverManager.getConnection(url, "jblog", "jblog");
		} catch(ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패: " + e);
		}
		return conn;
	}
	
	public List<V> getList() {
		List<V> result = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			pstmt = getPrepareStatement(conn);
			rs = pstmt.executeQuery();
			getListTask(rs, result);
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null && !rs.isClosed()) {
					rs.close();
				}
				
				if(pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
				}
				
				if(conn != null && !conn.isClosed()) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public boolean insert(V vo) {
		boolean result = false;
		Connection conn = null;
		
		try {
			conn = getConnection();	
			int count = insertTask(conn, vo);
			result = (count==1);
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn != null && !conn.isClosed()) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	abstract protected PreparedStatement getPrepareStatement(Connection conn) throws SQLException;
	abstract protected void getListTask(ResultSet rs, List<V> list) throws SQLException;
	abstract protected int insertTask(Connection conn, V vo) throws SQLException;
}
