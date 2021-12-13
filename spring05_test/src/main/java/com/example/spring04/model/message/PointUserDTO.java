package com.example.spring04.model.message;
//AOP 적용  트랜젝션
public class PointUserDTO {

	private String userid;
	private String name;
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "PointUserDTO [userid=" + userid + ", name=" + name + "]";
	}
}
