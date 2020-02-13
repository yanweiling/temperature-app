package com.windsound.project.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间工具类
 * 
 * @author rainy
 */
public class DateUtils {
  public static String YYYY = "yyyy";

  public static String YYYY_MM = "yyyy-MM";

  public static String YYYYMMDD = "yyyyMMdd";

  public static String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";

  public static String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

  /**
   * 获取当前Date型日期
   * 
   * @return Date() 当前日期
   */
  public static Date getNowDate() {
    return new Date();
  }

  /**
   * 获取当前日期, 默认格式为yyyy-MM-dd
   * 
   * @return String
   */
  public static String getDate() {
    return dateTimeNow(YYYYMMDD);
  }

  public static final String getTime() {
    return dateTimeNow(YYYY_MM_DD_HH_MM_SS);
  }

  public static final String dateTimeNow() {
    return dateTimeNow(YYYYMMDDHHMMSS);
  }

  public static final String dateTimeNow(final String format) {
    return parseDateToStr(format, new Date());
  }


  public static final String parseDateToStr(final String format, final Date date) {
    return new SimpleDateFormat(format).format(date);
  }

  public static final Date dateTime(final String format, final String ts) {
    try {
      return new SimpleDateFormat(format).parse(ts);
    } catch (ParseException e) {
      throw new RuntimeException(e);
    }
  }

  public static void main(String[] args) {
    System.out.println(getDate());
  }
}
