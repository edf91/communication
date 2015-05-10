package org.lhx.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间装换工具
 */
public class DateUtil {
	
	public static String dateToStr(Date date){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:MM:SS");
		return sdf.format(date);
	}
}
