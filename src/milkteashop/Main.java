package milkteashop;

public class Main {

	public static void main(String[] args) {
//		int count = 0;
//		int size = 0;
		TeaShop shop = new TeaShop();
		
		
		shop.add_random_num(5);//Ëæ»ú½ø»õ
		try {
			shop.makeTea("bubble");
			shop.makeTea("coconut");
		} catch (SoldOutException e) {
			e.printStackTrace();
		}
		
		shop.sellTea("ÄÌ²è1", "bubble");
		shop.sellTea("ÄÌ²è2", "coconut");
	}

}
