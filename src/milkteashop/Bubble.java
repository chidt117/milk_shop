package milkteashop;

import java.util.Calendar;

public class Bubble extends Ingredient{
	final static String NAME = "bubble";
	final static int DAY = 7;//保质期
	private Calendar productday;//生产日期
	
	public Bubble(Calendar productday) {
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
		return "Bubble{" +
                "ingredientName='" + NAME + '\'' +
                ", production=" + productday +
                ", 保质期=" + DAY +
                '}';
	}
	
}

