package milkteashop;

import java.util.Calendar;
import java.util.Date;

public class DateUtils {

	public static long calculateDay(Calendar current, Calendar product) {
		Date productDate = product.getTime();
        Date currentDate = current.getTime();
        long day = (currentDate.getTime()-productDate.getTime())
                / (24 * 60 * 60 * 1000);
        return day;
	}
	

}
