package trendtracker.model.dto;

public class MemberKeywordDTO {
	private int memberNum;
	private int keywordNum;
	
	public MemberKeywordDTO() {
	}

	public MemberKeywordDTO(int memberNum, int keywordNum) {
		this.memberNum = memberNum;
		this.keywordNum = keywordNum;
	}

	public int getMemberNum() {
		return memberNum;
	}

	public void setMemberNum(int memberNum) {
		this.memberNum = memberNum;
	}

	public int getKeywordNum() {
		return keywordNum;
	}

	public void setKeywordNum(int keywordNum) {
		this.keywordNum = keywordNum;
	}
}
