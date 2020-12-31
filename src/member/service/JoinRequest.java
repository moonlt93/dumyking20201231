package member.service;

import java.util.Map;

public class JoinRequest {
	private String id;
	private String name;
	private String password;
	private String confirmPassword;
	private String Birth;
	private String Gender;
	private String Job;

	

	public String getBirth() {
		return Birth;
	}

	public void setBirth(String birth) {
		Birth = birth;
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

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public void validate(Map<String, Boolean> errors) {
		// id값이 잘 들어왔는지?
		checkEmpty(errors, id, "id");
		// name 잘 들어왔는지?
		checkEmpty(errors, name, "name");
		// password 잘 들어왔는지?
		checkEmpty(errors, password, "password");
		// confirmPw 잘 들어왔는지?
		checkEmpty(errors, confirmPassword, "confirmPassword");
		
		//brith 들어왔는지 
		checkEmpty(errors, Birth , "birth");
		
		checkEmpty(errors,Gender,"gender");
		checkEmpty(errors,Job,"job");
		
		
		if (!errors.containsKey("confirmPassword")) {
			if (!isPasswordEqualToConfirm()) {
				errors.put("notMatch", true);
			}
		}
	}

	public boolean isPasswordEqualToConfirm() {
		return password != null && password.equals(confirmPassword);
		// 불린타입 confirmpassword은 password가 null이 아니거나, password가 confirmpassword랑 같을때 실행
	}

	private void checkEmpty(Map<String, Boolean> errors, String value, String fieldName) {
		if (value == null || value.isEmpty())
		// value가 null이거나 empty일때

		{
			errors.put(fieldName, true);
			// errors객체에 fieldName이라는 이름으로 저장.
		}
	}



}
