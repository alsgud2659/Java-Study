package dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DBConnecter {
	
	//외부에서 경로를 전달받은 후 알맞는 객체를 리턴해준다.
	
	public static BufferedReader getReader(String path) throws IOException {
		return new BufferedReader(new FileReader(path));
	}
	
	public static BufferedWriter getWriter(String path) throws IOException {
		return new BufferedWriter(new FileWriter(path));
	}
	
	public static BufferedWriter getAppend(String path) throws IOException {
		return new BufferedWriter(new FileWriter(path, true));
	}
}
