package com.cafe24.jblog.vo;

public class PostVo {
	private Long no;
	private String title;
	private String contents;
	private String writeDate;
	private Long categoryNo;
	private Long blogNo;
	
	public PostVo() {
	}

	public PostVo(Long no, String title, String contents, String writeDate, Long categoryNo, Long blogNo) {
		this.no = no;
		this.title = title;
		this.contents = contents;
		this.writeDate = writeDate;
		this.categoryNo = categoryNo;
		this.blogNo = blogNo;
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

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(String writeDate) {
		this.writeDate = writeDate;
	}

	public Long getCategoryNo() {
		return categoryNo;
	}

	public void setCategoryNo(Long categoryNo) {
		this.categoryNo = categoryNo;
	}

	public Long getBlogNo() {
		return blogNo;
	}

	public void setBlogNo(Long blogNo) {
		this.blogNo = blogNo;
	}

	@Override
	public String toString() {
		return "PostVo [no=" + no + ", title=" + title + ", contents=" + contents + ", writeDate=" + writeDate
		        + ", categoryNo=" + categoryNo + ", blogNo=" + blogNo + "]";
	}
}
