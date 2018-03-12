package com.cafe24.jblog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.cafe24.jblog.vo.UserVo;

public class UserDao extends Dao<UserVo>{
	@Override
	protected PreparedStatement getPrepareStatement(Connection conn) throws SQLException {
		String sql = "select no, id, password from user";
		return conn.prepareStatement(sql);
	}

	@Override
	protected void getListTask(ResultSet rs, List<UserVo> list) throws SQLException {
		while(rs.next()) {
			Long no = rs.getLong(1);
			String id = rs.getString(2);
			String password = rs.getString(3);
			UserVo vo = new UserVo(no, id, password);
			list.add(vo);
		}
	}

	@Override
	protected int insertTask(Connection conn, UserVo vo) throws SQLException {
		String sql = "insert into user values(null, ?, password(?))";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getId());
		pstmt.setString(2, vo.getPassword());
		return pstmt.executeUpdate();
	}
}
