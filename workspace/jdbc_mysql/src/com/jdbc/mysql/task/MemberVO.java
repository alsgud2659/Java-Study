package com.jdbc.mysql.task;

public class MemberVO {
	private int memberNumber;
	private String memberName;
	private String memberBirth;
	
	public MemberVO() {;}

	public int getMemberNumber() {
		return memberNumber;
	}

	public void setMemberNumber(int memberNumber) {
		this.memberNumber = memberNumber;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberBirth() {
		return memberBirth;
	}

	public void setMemberBirth(String memberBirth) {
		this.memberBirth = memberBirth;
	}
	
	@Override
	public String toString() {
		return memberName + ", " + memberBirth;
	}
}










