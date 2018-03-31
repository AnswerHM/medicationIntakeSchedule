package com.humin.ssm.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class WeekDays {
	static String[] weekDay = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
	
	
	/**
	 * 获取对应的星期几
	 * @param calendar
	 * @return
	 */
	public static String getWeek(Calendar calendar){
		return weekDay[calendar.get(Calendar.DAY_OF_WEEK)-1];
	}
	
	
   /** 
    * 获取过去第几天的日期 
    * 
    * @param past 
    * @return 
    */  
   public static String getPastDate(int past) {  
       Calendar calendar = Calendar.getInstance();  
       calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) - past);  
       Date today = calendar.getTime();  
       SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");  
       String result = format.format(today);  
       return result;  
   }  
  
   /** 
    * 获取未来 第 past 天的日期 
    * @param past 
    * @return 
    */  
   public static String getFetureDate(int past) {  
       Calendar calendar = Calendar.getInstance();  
       calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) + past);  
       Date today = calendar.getTime();  
       SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");  
       String result = format.format(today);  
       return result;  
   }  
   
   /**
    * 将String类型转换为Calendar类型
    * @param str
    * @return
    * @throws ParseException
    */
   public static Calendar stringToCalendar(String str) throws ParseException{
	   SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
	   Date date =sdf.parse(str);
	   Calendar calendar = Calendar.getInstance();
	   calendar.setTime(date);
	   return calendar;
   }
   
   /**
    * 将Calendar转换为String类型。
    * @param calendar
    * @return
    */
   public static String calendarToString(Calendar calendar){
	   SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
	   String dateStr = sdf.format(calendar.getTime());
	   return dateStr;
   }
   
   /**
    * 减去地区对应的时间
    * @param startTime
    * @param minuts
    * @return
    */
   public static String SubtractTime(String startTime,double minuts){
	   SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	   Calendar calendar = Calendar.getInstance();
	   int preHour = Integer.valueOf(startTime.substring(0,2));
	   int preMinte = Integer.valueOf(startTime.substring(3,5));
	   calendar.set(calendar.get(calendar.YEAR), calendar.get(calendar.MONTH)+1, calendar.get(calendar.DATE), preHour, preMinte);
	   long total = (long) (calendar.getTimeInMillis() + minuts*60*1000);
	   Date date2 = new Date();  
       date2.setTime(total);
	   String endAllTime = sdf.format(date2);
	   String endTime = endAllTime.substring(11, 16);
	   return endTime;
   }
   
   
   public static boolean hasTwoHours(Calendar day,String pre ,String next){
	   Boolean flag = false;
	   int preHour = Integer.valueOf(pre.substring(0,2));
	   int preMinte = Integer.valueOf(pre.substring(3,5));
	   Calendar calendar = Calendar.getInstance();
	   calendar.set(day.get(day.YEAR), day.get(day.MONTH)+1, day.get(day.DATE), preHour, preMinte); 
	   long first = calendar.getTimeInMillis();
	   int nextHour = Integer.valueOf(pre.substring(0,2));
	   int nextMinte = Integer.valueOf(pre.substring(3,5));
	   calendar.set(day.get(day.YEAR), day.get(day.MONTH)+1, day.get(day.DATE), nextHour, nextMinte); 
       // 返回当前时间，作为从开始时间的 UTC 毫秒值。
       long second = calendar.getTimeInMillis();
	   if((second - first) / (1000) > 7200){
		   flag = true;
	   }
	   return flag;
   }
   
   
   public static void main(String[] args){
//	   System.out.println(WeekDays.getFetureDate(15));
	   Calendar calendar = Calendar.getInstance();
	   calendar.set(2014, 9, 1, 13, 24); 
	   long first = calendar.getTimeInMillis();
       calendar.set(2014, 9, 1, 15, 24); 
       // 返回当前时间，作为从开始时间的 UTC 毫秒值。
       long second = calendar.getTimeInMillis();
	   long interSeconds = (second - first) / (1000);
	   System.out.println("两个服药时间相隔" + interSeconds + "秒");
	   
	   
	   System.out.println(SubtractTime("09:00",-20));
	   
   }
}
