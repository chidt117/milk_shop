package milkteashop;

public class SoldOutException extends Exception{

	public SoldOutException() {
		System.out.println("缺货，需要补充配料");
	}

	public String toString() {
		return "配料不足，已卖完";
	}
	
	
}
