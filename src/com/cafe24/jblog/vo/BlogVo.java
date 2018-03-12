package com.cafe24.jblog.vo;

/**
 * @author BIT
 *
 */
public class BlogVo implements JBlogVo{
	private Long no;
	private String title;
	private String imagePath;
	public BlogVo() {
	}
	public BlogVo(Long no, String title, String imagePath) {
		this.no = no;
		this.title = title;
		this.imagePath = imagePath;
	}
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	@Override
	public String toString() {
		return "BlogVo [no=" + no + ", title=" + title + ", imagePath=" + imagePath + "]";
	}
}
