package milkteashop;

import java.util.Calendar;

public class Coconut extends Ingredient {
	final static String NAME = "coconut";//������
	final static int DAY = 5;//������
	private Calendar productday;//��������
	
	public Coconut(Calendar productday) {
		super();
		this.productday = productday;
	}



	/**
	 * �Ƿ����
	 * @param productday ��������
	 * @param current ��ǰʱ��
	 * @return
	 */
	public boolean isOutDate() {
		long day = DateUtils.calculateDay(Calendar.getInstance(), productday);
		if (day > DAY) {
			return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		return "Coconut{" +
                "ingredientName='" + NAME + '\'' +
                ", production=" + productday +
                ", ������=" + DAY +
                '}';
	}
}
