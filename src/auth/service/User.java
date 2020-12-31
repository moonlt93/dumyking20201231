package auth.service;

public class User {
	//로그인 유저
	private String id;
	private String name;
	private String birth;
	private String gender;
	private String job;
    
	public User() {
		
	}
	
	public User(String id, String name, String birth,String gender, String job) {
		super();
		this.id = id;
		this.name = name;
		this.birth = birth;
		this.gender =gender;
		this.job = job;
	
	}
	
	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
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

	


	
	
}
