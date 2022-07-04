package wrapper;

public class WrapperTask {
	public static void main(String[] args) {
		// 1, 3.5, 12.5F, 'A', "ABC", true
		// 위 6개의 값을 6칸 배열에 담기
		Object[] arData = {1, 3.5, 12.5F, 'A', "ABC", true};
		
		for (int i = 0; i < arData.length; i++) {
			System.out.println(arData[i]);
		}
	}
}
