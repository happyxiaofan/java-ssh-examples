package com.rhwayfun.ssh.struts.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatUtil {

	public static String format(Date date){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		return simpleDateFormat.format(date);
	}
}
