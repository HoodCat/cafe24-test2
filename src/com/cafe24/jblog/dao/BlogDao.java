package com.cafe24.jblog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.cafe24.jblog.vo.BlogVo;

public class BlogDao extends Dao<BlogVo> {

	@Override
	protected PreparedStatement getPrepareStatement(Connection conn) throws SQLException {
		String sql = "select no, title, image_path from blog";
		return conn.prepareStatement(sql);
	}

	@Override
	protected void getListTask(ResultSet rs, List<BlogVo> list) throws SQLException {
		while(rs.next()) {
			Long no = rs.getLong(1);
			String title = rs.getString(2);
			String imagePath = rs.getString(3);
			list.add(new BlogVo(no, title, imagePath));
		}
	}

	@Override
	protected int insertTask(Connection conn, BlogVo vo) throws SQLException {
		String sql = "insert into blog values(null, ?, ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getTitle());
		pstmt.setString(2, vo.getImagePath());
		return pstmt.executeUpdate();
	}
}
