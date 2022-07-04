package anonymous;

public class Nike {
	
	public String branchName;
	
	public void register(Form form) {
		String[] menus = form.getMenu();
		System.out.println("========" + branchName + " 상품 목록========");
		for (int i = 0; i < menus.length; i++) {
			System.out.println(i + 1 + ". " + menus[i]);
		}
		
		//무료나눔인지 정상판매인지를 검사
		if(form instanceof FormAdapter) {
			System.out.println("무료 나눔 직영점");
			return;
		}
		form.sell("티셔츠");
	}
}
