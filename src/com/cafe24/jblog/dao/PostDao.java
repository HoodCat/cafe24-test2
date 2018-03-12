package com.cafe24.jblog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.cafe24.jblog.vo.PostVo;

public class PostDao extends Dao<PostVo>{

	@Override
	protected PreparedStatement getPrepareStatement(Connection conn) throws SQLException {
		String sql = "select no, title, contents, write_date, category_no, blog_no from post";
		return conn.prepareStatement(sql);
	}

	@Override
	protected void getListTask(ResultSet rs, List<PostVo> list) throws SQLException {
		while(rs.next()) {
			Long no = rs.getLong(1);
			String title = rs.getString(2);
			String contents = rs.getString(3);
			String writeDate = rs.getString(4);
			Long categoryNo = rs.getLong(5);
			Long blogNo = rs.getLong(6);
			
			list.add(new PostVo(no, title, contents, writeDate, categoryNo, blogNo));
		}
	}

	@Override
	protected int insertTask(Connection conn, PostVo vo) throws SQLException {
		String sql = "insert into post values(null, ?, ?, ?, ?, ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getTitle());
		pstmt.setString(2, vo.getContents());
		pstmt.setString(3, vo.getWriteDate());
		pstmt.setLong(4, vo.getCategoryNo());
		pstmt.setLong(5, vo.getBlogNo());
		return pstmt.executeUpdate();
	}
}
