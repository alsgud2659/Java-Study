package view;

import java.io.IOException;

import dao.NamesDAO;

public class Test {
	public static void main(String[] args) throws IOException{
		NamesDAO dao = new NamesDAO();
		dao.merge("manNames.txt", "womanNames.txt", "names.txt");
		dao.update("names.txt");
	}
}
