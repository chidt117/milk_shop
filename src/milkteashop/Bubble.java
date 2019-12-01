package milkteashop;

import java.util.Calendar;

public class Bubble extends Ingredient{
	final static String NAME = "bubble";
	final static int DAY = 7;//������
	private Calendar productday;//��������
	
	public Bubble(Calendar productday) {
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
		return "Bubble{" +
                "ingredientName='" + NAME + '\'' +
                ", production=" + productday +
                ", ������=" + DAY +
                '}';
	}
	
}

