package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamTask {
	public static void main(String[] args) {
		//1~10까지 ArrayList에 담고 출력(IntStream)
//		ArrayList<Integer> datas = new ArrayList<>();
//		IntStream.rangeClosed(1, 10).forEach(i -> datas.add(i));
//		System.out.println(datas);
		
		//1~100까지 중 짝수만 ArrayList에 담고 출력(filter)
//		ArrayList<Integer> datas = new ArrayList<>();
//		IntStream.range(1, 51).forEach(i -> datas.add(i * 2));
//		IntStream.range(1, 51).map(i -> i * 2).forEach(i -> datas.add(i));
//		IntStream.range(1, 101).filter(i -> i % 2 == 0).forEach(i -> datas.add(i));
//		System.out.println(datas);
		
		//A~F까지 ArrayList에 담고 출력(IntStream.range() , map)
//		ArrayList<Character> datas = new ArrayList<>();
//		IntStream.range(65, 71).forEach(i -> datas.add((char)i));
//		IntStream.range(0, 6).forEach(i -> datas.add((char)(i + 65)));
//		IntStream.range(0, 6).map(i -> i + 65).forEach(i -> datas.add((char)(i)));
//		System.out.println(datas);
		
		//A~F까지 중 D 제외화고 ArrayList에 담은 후 출력(IntStream, map, 삼항 연산자)
//		ArrayList<Character> datas = new ArrayList<>();
//		IntStream.range(0, 5).map(i -> (i > 2 ? i + 1 : i)).forEach(i -> datas.add((char)(i + 65)));
//		IntStream.range(0, 5).map(i -> (i > 2 ? i + 1 : i)).map(i -> i + 65).forEach(i -> datas.add((char)(i)));
//		System.out.println(datas);
		
		//5개의 정수를 입력받은 후 ArrayList에 담고 최대값과 최소값 출력(구글링)(sorted 또는 mapToInt)
//		ArrayList<Integer> datas = new ArrayList<>(Arrays.asList(10, 20, 50, 30, 40));
//		System.out.println(datas.stream().mapToInt(i -> i).max().getAsInt());
//		System.out.println(datas.stream().mapToInt(i -> i).min().getAsInt());
		
//		List<Integer> maxAndMin = datas.stream().sorted().collect(Collectors.toList());
//		System.out.println(maxAndMin.get(maxAndMin.size() - 1));
//		System.out.println(maxAndMin.get(0));
		
		//문자열을 5개 입력받고 모두 소문자로 변경(입력 : IntStream, map)
//		Scanner sc = new Scanner(System.in);
//		ArrayList<String> datas = new ArrayList<>();
//		IntStream.rangeClosed(0, 4).forEach(i -> datas.add(sc.next()));
//		datas.stream().map(String::toLowerCase).forEach(System.out::println);
		
		
		//Apple, banana, Melon 중 첫번째 문자가 대문자인 문자열 출력(Arrays.asLit(), filter, collect)
//		ArrayList<String> fruits = new ArrayList<>(Arrays.asList("Appple", "banana", "Melon"));
//		String result = fruits.stream().filter(fruit -> fruit.charAt(0) >= 65)
//								.filter(fruit -> fruit.charAt(0) <= 90).collect(Collectors.joining(" "));
//		
//		System.out.println(result);
		
		//한글을 정수로 변경(map)
//		String hangle = "공일이삼사오육칠팔구";
//		Scanner sc = new Scanner(System.in);
//		System.out.println("입력 : ");
//		String data = sc.next();
		
		//1. 사용자가 입력한 문자를 하나씩 c에 담는다.
		//2. 각 문자를 hangle에서 찾는다.
		//3. 기존에 있던 data의 문자열은 전부 각 문자의 인덱스 번호로 변경된다.
		//4. 각 요소를 출력한다.
//		data.chars().map(c -> hangle.indexOf(c)).forEach(System.out::print);
		
		//정수를 한글로 변경(map, forEach)
//		data.chars().map(c -> c - 48).forEach(c -> System.out.print(hangle.charAt(c)));
		
	}
}









