package trendtracker.model.dto;

public class MemberDTO {
	private int memberNum;
	private int age;
	private String name;
	private String id;
	private String pw;
	private String email;
	private String phone;
	private String gender;

	public MemberDTO() {
	}

	public MemberDTO(int memberNum, int age, String name, String id, String pw, String email, String phone,
			String gender) {
		this.memberNum = memberNum;
		this.age = age;
		this.name = name;
		this.id = id;
		this.pw = pw;
		this.email = email;
		this.phone = phone;
		this.gender = gender;
	}

	public int getMemberNum() {
		return memberNum;
	}

	public void setMemberNum(int memberNum) {
		this.memberNum = memberNum;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
}