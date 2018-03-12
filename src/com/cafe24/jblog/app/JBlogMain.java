package com.cafe24.jblog.app;

import com.cafe24.jblog.dao.BlogDao;
import com.cafe24.jblog.dao.CategoryDao;
import com.cafe24.jblog.dao.CommentDao;
import com.cafe24.jblog.dao.PostDao;
import com.cafe24.jblog.dao.UserDao;
import com.cafe24.jblog.vo.BlogVo;
import com.cafe24.jblog.vo.CategoryVo;
import com.cafe24.jblog.vo.CommentVo;
import com.cafe24.jblog.vo.PostVo;
import com.cafe24.jblog.vo.UserVo;

public class JBlogMain {
	public static void main(String[] args) {
		UserDao userDao = new UserDao(); 
		BlogDao blogDao = new BlogDao();
		CategoryDao categoryDao = new CategoryDao();
		PostDao postDao = new PostDao();
		CommentDao commentDao = new CommentDao();
		
		// 유저 생성
		UserVo userVo = new UserVo(null, "thanatos0128", "mypassword");
		UserVo userVo1 = new UserVo(null, "guest123", "mypassword");
		UserVo userVo2 = new UserVo(null, "guest1004", "mypassword");
		
		// 유저 생성시 블로그 생성
		if(userDao.insert(userVo)) {
			BlogVo blogVo = new BlogVo(null, userVo.getId()+"님의 블로그", null);
			blogDao.insert(blogVo);
		}
		if(userDao.insert(userVo1)) {
			BlogVo blogVo = new BlogVo(null, userVo1.getId()+"님의 블로그", null);
			blogDao.insert(blogVo);
		}
		if(userDao.insert(userVo2)) {
			BlogVo blogVo = new BlogVo(null, userVo2.getId()+"님의 블로그", null);
			blogDao.insert(blogVo);
		}
		
		// 카테고리 생성
		categoryDao.insert(new CategoryVo(null, "C", "C언어와 관련된 글입니다."));
		categoryDao.insert(new CategoryVo(null, "Java", "Java와 관련된 글입니다."));
		categoryDao.insert(new CategoryVo(null, "Python", "Python과 관련된 글입니다."));
		
		// 포스트 생성
		postDao.insert(new PostVo(null, "C언어로 Hello, World를 띄워보자", "printf(\"Hello, World\");", "2018-03-12 16:44:23", 1L, 1L));
		postDao.insert(new PostVo(null, "C언어의 변수에 대해 알아보자", "int a;", "2018-03-12 16:53:43", 1L, 1L));

		// 댓글 생성
		commentDao.insert(new CommentVo(null, "설명 좀 제대로 해주세요", "2018-03-12 18:23:45",1L, 2L));
		commentDao.insert(new CommentVo(null, "ㅋㅋㅋㅋㅋㅋstdio.h 안불러오냨", "2018-03-12 18:43:52",1L, 3L));
		commentDao.insert(new CommentVo(null, "그냥 블로그를 하지마라", "2018-03-12 19:03:31",2L, 2L));
		commentDao.insert(new CommentVo(null, "내 블로그에서 차라리 배워가라ㅋ", "2018-03-12 20:01:12",2L, 3L));
		
		// 회원 리스트 출력 1명
		System.out.println(String.format("========================================%s========================================", "회원 리스트"));
		System.out.println(userDao.getList().get(0));
		System.out.println();
		
		// 블로그 정보 출력 1개
		System.out.println(String.format("========================================%s========================================", "블로그 정보"));
		System.out.println(blogDao.getList().get(0));
		System.out.println();
		
		// 카테고리 정보 출력 3개
		System.out.println(String.format("========================================%s========================================", "카테고리 정보"));
		for(CategoryVo vo: categoryDao.getList().subList(0, 3)) {
			System.out.println(vo);
		}
		System.out.println();
		
		// 포스트 정보 출력 2개
		System.out.println(String.format("========================================%s========================================", "포스트 정보"));
		for(PostVo vo: postDao.getList().subList(0, 2)) {
			System.out.println(vo);
		}
		System.out.println();
		
		// 댓글 정보 출력 2개
		System.out.println(String.format("========================================%s========================================", "댓글 정보"));
		for(CommentVo vo: commentDao.getList().subList(0, 2)) {
			System.out.println(vo);
		}
	}
}
