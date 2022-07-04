package file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileTask2 {
	public static void main(String[] args) throws IOException{
		// 생선
		// fish.txt
		// 도미, 고등어, 갈치, 광어
		
//		BufferedWriter bw = new BufferedWriter(new FileWriter("fish.txt"));
//		bw.write("도미\n");
//		bw.write("고등어\n");
//		bw.write("갈치\n");
//		bw.write("광어\n");
//		bw.close();
		
		//수정(고등어 -> 방어)
//		BufferedReader br = null;
//		String line = null;
//		String result = "";
//		try {
//			br = new BufferedReader(new FileReader("fish.txt"));
//			
//			while((line = br.readLine()) != null) {
//				if(line.equals("고등어")) {
//					result += "방어\n";
//					continue;
//				}
//				result += line + "\n";
//			}
//			
//		} catch (FileNotFoundException e) {
//			System.out.println("파일이 없습니다.");
//		} finally {
//			if(br != null) {
//				br.close();
//			}
//		}
//		
//		BufferedWriter bw = new BufferedWriter(new FileWriter("fish.txt"));
//		bw.write(result);
//		bw.close();
		
		
		//갈치 삭제
		BufferedReader br = null;
		String line = null;
		String result = "";
		try {
			br = new BufferedReader(new FileReader("fish.txt"));
			
			while((line = br.readLine()) != null) {
				if(line.equals("갈치")) {
					continue;
				}
				result += line + "\n";
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("파일이 없습니다.");
		} finally {
			if(br != null) {
				br.close();
			}
		}
		
		BufferedWriter bw = new BufferedWriter(new FileWriter("fish.txt"));
		bw.write(result);
		bw.close();		
		
	}
}









