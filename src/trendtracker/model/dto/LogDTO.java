package trendtracker.model.dto;

public class LogDTO {
	private int logNum;
	private int memberNum;
	private String keyword;
	private String logDate;
	
	public LogDTO() {
	}
	
	public LogDTO(int logNum, int memberNum, String keyword, String logDate) {
		this.logNum = logNum;
		this.memberNum = memberNum;
		this.keyword = keyword;
		this.logDate = logDate;
	}

	public int getLogNum() {
		return logNum;
	}

	public void setLogNum(int logNum) {
		this.logNum = logNum;
	}

	public int getMemberNum() {
		return memberNum;
	}

	public void setMemberNum(int memberNum) {
		this.memberNum = memberNum;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getLogDate() {
		return logDate;
	}

	public void setLogDate(String logDate) {
		this.logDate = logDate;
	}
}
