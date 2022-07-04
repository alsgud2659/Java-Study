package com.jdbc.mysql.task;

import java.util.List;

public class Test {
	public static void main(String[] args) {
		MemberDAO dao = new MemberDAO();
		List<MemberVO> members = dao.getInfo("배상혁");
		members.forEach(System.out::println);
	}
}
