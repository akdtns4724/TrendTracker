package trendtracker.model.dto;

public class MajorDTO {
	private int majorNum;
	private String major;
	
	public MajorDTO() {
	}

	public MajorDTO(int majorNum, String major) {
		this.majorNum = majorNum;
		this.major = major;
	}

	public int getMajorNum() {
		return majorNum;
	}

	public void setMajorNum(int majorNum) {
		this.majorNum = majorNum;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}
}
