package dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DBConnecter {
	private final static String PATH = "boxOffice.txt";
	
	public static String getPath() {
		return PATH;
	}
	
	//내용 덮어쓰기
	public static BufferedWriter getWriter() throws IOException{
		return new BufferedWriter(new FileWriter(PATH));
	}
	
	//내용 추가하기
	public static BufferedWriter getAppend() throws IOException {
		return new BufferedWriter(new FileWriter(PATH, true));
	}
	
	//내용 가져오기
	public static BufferedReader getReader() throws IOException {
		return new BufferedReader(new FileReader(PATH));
	}
}






