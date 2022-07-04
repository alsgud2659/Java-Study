package anonymous;

public class Road {
	public static void main(String[] args) {
		
		Knotted jamsil = new Knotted();
		jamsil.branchName = "잠실점";
		
		jamsil.register(new Form() {
			
			@Override
			public void sell(String order) {
				String[] menus = getMenu();
				for (int i = 0; i < menus.length; i++) {
					if(menus[i].equals(order)) {
						System.out.println(order + " 주문 완료");
					}
				}
			}
			
			@Override
			public String[] getMenu() {
				String[] menus = {"우유 생크림", "민트초코", "앙버터", "쿠키앤크림"};
				return menus;
			}
		});
	}
}
