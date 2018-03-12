package com.cafe24.jblog.dao.test;

import com.cafe24.jblog.dao.BlogDao;
import com.cafe24.jblog.dao.Dao;
import com.cafe24.jblog.dao.UserDao;
import com.cafe24.jblog.vo.BlogVo;
import com.cafe24.jblog.vo.JBlogVo;
import com.cafe24.jblog.vo.UserVo;

public class DaoTest {
	public static void main(String[] args) {
		insertTest();
		getListTest();
	}
	
	private static void getListTest() {
		Dao<BlogVo> dao = new BlogDao();
		for(JBlogVo vo: dao.getList()) {
			System.out.println(vo);
		}
	}
	
	private static void insertTest() {
		Dao<BlogVo> dao = new BlogDao();
		BlogVo vo = new BlogVo(null, "tmxkaos123", null);
		dao.insert(vo);
	}
}
