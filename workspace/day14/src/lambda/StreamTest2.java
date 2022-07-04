package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamTest2 {
	public static void main(String[] args) {
		//stream() : Stream타입으로 변경(stream에 정의된 기능들을 사용할 수 있는 상태로 변경)
		//map() : 기존의 데이터를 다른 데이터로 변경
		//filter() : 조건식을 전달하여 true인 값만 추출
		//collect() : 결과를 원하는 타입으로 변경
		//forEach() : 향상된 for문과 같이 앞의 iterator 요소를 각각 가져온 후 로직 작성
		//sorted() : 오름차순 정렬
		//IntStream.range(start, end) : 특정 범위의 여러 개의 값을 생성할 때 사용한다. end는 포함시키지 않는다.
		
		//1~100까지 ArrayList에 담기
//		ArrayList<Integer> datas = new ArrayList<>();
//		IntStream.range(0, 100).forEach(i -> datas.add(i + 1));
//		System.out.println(datas);
		
		//ABCDEF를 각 문자별로 출력하기
		String data = "ABCDEF";
//		data.chars().forEach(c -> System.out.println((char)c));
//		data.chars().map(c -> c + 1).forEach(c -> System.out.println((char)c));
//		data.chars().filter(c -> c != 67).forEach(c -> System.out.println((char)c));
		
		//정렬
//		ArrayList<Integer> datas = new ArrayList<>(Arrays.asList(10, 40, 20, 30));
//		//:: -> void, 매개변수가 없는 경우 참조형 사용이 가능하다.
//		//오름 차순
//		datas.stream().sorted().collect(Collectors.toList()).forEach(System.out::println);
//		//내림 차순
//		datas.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList()).forEach(System.out::println);
		
		//결과를 원하는 형식으로 변경
		ArrayList<String> datas = new ArrayList<>(Arrays.asList("black", "white", "red", "yellow"));
		//joining : 각 요소를 원하는 구분점으로 분리하여 문자열로 리턴한다.
//		System.out.println(datas.stream().collect(Collectors.joining(" ")));
		
		//전체 대문자로 변경 후 출력
//		datas.stream().map(String::toUpperCase).collect(Collectors.toList()).forEach(System.out::println);
		//전체 대문자 말고 앞에 글자만 대문자로 변경 후 출력
//		datas.stream()
//		.map(c -> c.charAt(0) >= 97 && c.charAt(0) <= 122 ? c.replace(c.charAt(0), (char)(c.charAt(0) - 32)) : c)
//		.forEach(System.out::println);
	}
}







