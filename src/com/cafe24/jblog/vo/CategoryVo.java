package com.cafe24.jblog.vo;

public class CategoryVo implements JBlogVo{
	private Long no;
	private String name;
	private String description;
	
	public CategoryVo() {
	}

	public CategoryVo(Long no, String name, String description) {
		super();
		this.no = no;
		this.name = name;
		this.description = description;
	}

	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String descrption) {
		this.description = descrption;
	}

	@Override
	public String toString() {
		return "CategoryVo [no=" + no + ", name=" + name + ", descrption=" + description + "]";
	}
}
