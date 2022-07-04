package lambda;

@FunctionalInterface //함수형 인터페이스
public interface PrintName {
	//외부에서 이름과 성을 전달받는 추상 메소드 선언
	public String getName(String firstName, String lastName);
}
