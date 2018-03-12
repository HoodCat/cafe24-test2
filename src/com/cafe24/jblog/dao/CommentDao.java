package com.cafe24.jblog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.cafe24.jblog.vo.CommentVo;

public class CommentDao extends Dao<CommentVo>{

	@Override
	protected PreparedStatement getPrepareStatement(Connection conn) throws SQLException {
		String sql = "select no, contents, write_date, post_no, user_no from comment";
		return conn.prepareStatement(sql);
	}

	@Override
	protected void getListTask(ResultSet rs, List<CommentVo> list) throws SQLException {
		while(rs.next()) {
			Long no = rs.getLong(1);
			String contents = rs.getString(2);
			String writeDate = rs.getString(3);
			Long postNo = rs.getLong(4);
			Long userNo = rs.getLong(5);
			list.add(new CommentVo(no, contents, writeDate, postNo, userNo));
		}
		
	}

	@Override
	protected int insertTask(Connection conn, CommentVo vo) throws SQLException {
		String sql = "insert into comment values(null, ?, ?, ?, ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getContents());
		pstmt.setString(2, vo.getWriteDate());
		pstmt.setLong(3, vo.getPostNo());
		pstmt.setLong(4, vo.getUserNo());
		return pstmt.executeUpdate();
	}
	
}
