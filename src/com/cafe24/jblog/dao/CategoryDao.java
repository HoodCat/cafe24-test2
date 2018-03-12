package com.cafe24.jblog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.cafe24.jblog.vo.CategoryVo;

public class CategoryDao extends Dao<CategoryVo>{

	@Override
	protected PreparedStatement getPrepareStatement(Connection conn) throws SQLException {
		String sql = "select no, name, description from category";
		return conn.prepareStatement(sql);
	}

	@Override
	protected void getListTask(ResultSet rs, List<CategoryVo> list) throws SQLException {
		while(rs.next()) {
			Long no = rs.getLong(1);
			String name = rs.getString(2);
			String description = rs.getString(3);
			list.add(new CategoryVo(no, name, description));
		}
		
	}

	@Override
	protected int insertTask(Connection conn, CategoryVo vo) throws SQLException {
		String sql = "insert into category values(null, ?, ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getName());
		pstmt.setString(2, vo.getDescription());
		return pstmt.executeUpdate();
	}
	
}
