package milkteashop;

import java.util.Calendar;

public class Coconut extends Ingredient {
	final static String NAME = "coconut";//配料名
	final static int DAY = 5;//保质期
	private Calendar productday;//生产日期
	
	public Coconut(Calendar productday) {
		super();
		this.productday = productday;
	}



	/**
	 * 是否过期
	 * @param productday 生产日期
	 * @param current 当前时间
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
                ", 保质期=" + DAY +
                '}';
	}
}
