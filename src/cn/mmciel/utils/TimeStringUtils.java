package cn.mmciel.utils;

import java.sql.Timestamp;

public class TimeStringUtils {
	public static Timestamp StringToTimestamp(String s) {
		
		return Timestamp.valueOf(s); 
	}
}
