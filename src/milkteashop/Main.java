package milkteashop;

public class Main {

	public static void main(String[] args) {
//		int count = 0;
//		int size = 0;
		TeaShop shop = new TeaShop();
		
		
		shop.add_random_num(5);//�������
		try {
			shop.makeTea("bubble");
			shop.makeTea("coconut");
		} catch (SoldOutException e) {
			e.printStackTrace();
		}
		
		shop.sellTea("�̲�1", "bubble");
		shop.sellTea("�̲�2", "coconut");
	}

}
