package member.model;

import java.util.Date;

public class Member {
	private String id;
	private String name;
	private String password;
	private Date regDate;
	private String Birth;
	private String Gender;
	private String Job;
	
	public String getBirth() {
		return Birth;
	}
	public void setBirth(String birth) {
		this.Birth = birth;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean matchPassword(String pwd) {
		return password.equals(pwd);
	}

	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public String getJob() {
		return Job;
	}
	public void setJob(String job) {
		Job = job;
	}
	public void changePassword(String newPwd) {
		this.password = newPwd;
	}
	

}
