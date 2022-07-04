package com.jdbc.mysql;

public class Test {
	public static void main(String[] args) {
		GuestDAO dao = new GuestDAO();
		GuestVO guest = dao.getInfo("hds1234");
		System.out.println(guest.getUserId());
		System.out.println(guest.getUserAge());
		System.out.println(guest.getBirth());
	}
}
