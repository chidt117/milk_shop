package milkteashop;

public class SoldOutException extends Exception{

	public SoldOutException() {
		System.out.println("ȱ������Ҫ��������");
	}

	public String toString() {
		return "���ϲ��㣬������";
	}
	
	
}
