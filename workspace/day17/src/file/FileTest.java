package file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileTest {
	//throws : 예외 던지기(일괄 처리)
	//메소드 내에서 자주 발생하는 예외를 메소드를 사용하는 쪽에서 한 번에 예외처리를 하고자 사용한다.
	public static void main(String[] args) throws IOException{
		//절대경로 : 어디서든지 찾아갈 수 있는 경로
		//상대경로 : 현재 위치를 기준으로 찾아가는 경로
//		BufferedWriter bw = new BufferedWriter(new FileWriter(new File("test.txt"), true));
////		bw.write("\n한동석\n");
//		bw.newLine();
//		bw.write("한동석");
//		bw.close();
		
		String line = null;
		
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("test.txt"));
			
			while((line = br.readLine()) != null) {
				System.out.print(line);
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("없는 파일입니다.");
		} finally {
			if(br != null) {
				br.close();
			}
		}
		
	}
}




