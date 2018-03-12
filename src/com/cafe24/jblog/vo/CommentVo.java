package com.cafe24.jblog.vo;

public class CommentVo {
	private Long no;
	private String contents;
	private String writeDate;
	private Long postNo;
	private Long userNo;
	
	public CommentVo() {
	}

	public CommentVo(Long no, String contents, String writeDate, Long postNo, Long userNo) {
		super();
		this.no = no;
		this.contents = contents;
		this.writeDate = writeDate;
		this.postNo = postNo;
		this.userNo = userNo;
	}
	
	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
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

	public void setWriteDate(String wirteDate) {
		this.writeDate = wirteDate;
	}

	public Long getPostNo() {
		return postNo;
	}

	public void setPostNo(Long postNo) {
		this.postNo = postNo;
	}

	public Long getUserNo() {
		return userNo;
	}

	public void setUserNo(Long userNo) {
		this.userNo = userNo;
	}

	@Override
	public String toString() {
		return "CommentVo [no=" + no + ", contents=" + contents + ", wirteDate=" + writeDate + ", postNo=" + postNo
		        + ", userNo=" + userNo + "]";
	}
}
