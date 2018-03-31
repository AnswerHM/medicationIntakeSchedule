package com.humin.ssm.service.impl;

import java.util.Calendar;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.humin.ssm.mapper.DiurnalAcupointMapper;
import com.humin.ssm.po.DiurnalAcupoint;
import com.humin.ssm.po.ResponseBody;
import com.humin.ssm.service.DiurnalAcupointService;
import com.humin.ssm.util.EarthlyTimeEnum;
import com.humin.ssm.util.LunarCalendar;
import com.humin.ssm.util.WeekDays;
@Service("diurnalAcupointService")
public class DiurnalAcupointServiceImp implements DiurnalAcupointService {
	
	@Resource
	DiurnalAcupointMapper diurnalAcupointMapper;

	public List<DiurnalAcupoint> queryAllDiurnalAcupointByMap(Map map) throws Exception {
		return diurnalAcupointMapper.queryAllDiurnalAcupointByMap(map);
	}

	@Override
	public List<ResponseBody> getOpenAcupointTimeByDate(Calendar c2,List<String> channes,Integer times) throws Exception { 
		String dateStr = WeekDays.calendarToString(c2);
		String dayName = LunarCalendar.getSixCharacter(dateStr);
//		System.out.println(dayName);
		// 根据日期通过计算，获取日干支
		String dayChineseEra = dayName.substring(6,7);
//		System.out.println(dayChineseEra);
		Map<String,String> queryMap = new HashMap<String,String>();
		queryMap.put("dayChineseEra", dayChineseEra);
		List<DiurnalAcupoint> openAcupointList = this.queryAllDiurnalAcupointByMap(queryMap);
		List<ResponseBody> firstList = new LinkedList<ResponseBody>();
		if(openAcupointList != null && openAcupointList.size() > 0){
			for(DiurnalAcupoint da : openAcupointList){
//				System.out.println(da.toString());
				// 获取到日干，
				String hourEar =  da.getHourChineseEra().substring(1);
				String yearAndMonthAndDay = c2.get(c2.YEAR)+"年"+(c2.get(c2.MONTH)+1)+"月"+c2.get(c2.DATE)+"日";
				// 如果是首穴时间 则：【子、丑、寅、卯、辰、都不符合条件（23:00:00 ～ 07:24:00）】
				if(channes.contains(da.getFirstAcupoint())){
					if(hourEar.equals(EarthlyTimeEnum.ZI.getName()) || hourEar.equals(EarthlyTimeEnum.CHOU.getName()) ||
						hourEar.equals(EarthlyTimeEnum.YIN.getName()) || hourEar.equals(EarthlyTimeEnum.MAO.getName()) ||
						hourEar.equals(EarthlyTimeEnum.CHEN.getName())){
						continue;
					}else{
						ResponseBody rb = new ResponseBody();
						rb.setId(times);
						rb.setTakingMedicineDate(yearAndMonthAndDay);
						rb.setWeek(WeekDays.getWeek(c2));
						if(hourEar.equals(EarthlyTimeEnum.SI.getName())){
//							rb.setTakingMedicineTime("09:00:00 -- 09:24:00");
							rb.setTakingMedicineTime(WeekDays.SubtractTime("09:00",-27.2)+" -- "+WeekDays.SubtractTime("09:24",-27.2));
						}
						if(hourEar.equals(EarthlyTimeEnum.WU.getName())){
//							rb.setTakingMedicineTime("11:00:00 -- 11:24:00");
							rb.setTakingMedicineTime(WeekDays.SubtractTime("11:00",-27.2)+" -- "+WeekDays.SubtractTime("11:24",-27.2));
						}
						if(hourEar.equals(EarthlyTimeEnum.WEI.getName())){
//							rb.setTakingMedicineTime("13:00:00 -- 13:24:00");
							rb.setTakingMedicineTime(WeekDays.SubtractTime("13:00",-27.2)+" -- "+WeekDays.SubtractTime("13:24",-27.2));
						}
						if(hourEar.equals(EarthlyTimeEnum.SHEN.getName())){
//							rb.setTakingMedicineTime("15:00:00 -- 15:24:00");
							rb.setTakingMedicineTime(WeekDays.SubtractTime("15:00",-27.2)+" -- "+WeekDays.SubtractTime("15:24",-27.2));
						}
						if(hourEar.equals(EarthlyTimeEnum.YOU.getName())){
//							rb.setTakingMedicineTime("17:00:00 -- 17:24:00");
							rb.setTakingMedicineTime(WeekDays.SubtractTime("17:00",-27.2)+" -- "+WeekDays.SubtractTime("17:24",-27.2));
						}
						if(hourEar.equals(EarthlyTimeEnum.XU.getName())){
//							rb.setTakingMedicineTime("19:00:00 -- 19:24:00");
							rb.setTakingMedicineTime(WeekDays.SubtractTime("19:00",-27.2)+" -- "+WeekDays.SubtractTime("19:24",-27.2));
						}
						if(hourEar.equals(EarthlyTimeEnum.HAI.getName())){
//							rb.setTakingMedicineTime("21:00:00 -- 21:24:00");
							rb.setTakingMedicineTime(WeekDays.SubtractTime("21:00",-27.2)+" -- "+WeekDays.SubtractTime("21:24",-27.2));
						}
						firstList.add(rb);
					}
				}
				// 如果是第二穴时间 则：【子、丑、寅、卯、辰、都不符合条件（23:24:00 ～ 07:48:00） 午（11:24:00 ～ 11:48:00）】
				if(channes.contains(da.getSecondAcupoint())){
					if(hourEar.equals(EarthlyTimeEnum.ZI.getName()) || hourEar.equals(EarthlyTimeEnum.CHOU.getName()) ||
						hourEar.equals(EarthlyTimeEnum.YIN.getName()) || hourEar.equals(EarthlyTimeEnum.MAO.getName()) ||
						hourEar.equals(EarthlyTimeEnum.CHEN.getName()) || hourEar.equals(EarthlyTimeEnum.WU.getName())){
						continue;
					}else{
						ResponseBody rb = new ResponseBody();
						rb.setId(times);
						rb.setTakingMedicineDate(yearAndMonthAndDay);
						rb.setWeek(WeekDays.getWeek(c2));
						if(hourEar.equals(EarthlyTimeEnum.SI.getName())){
//							rb.setTakingMedicineTime("09:24:00 -- 09:48:00");
							rb.setTakingMedicineTime(WeekDays.SubtractTime("09:24",-27.2)+" -- "+WeekDays.SubtractTime("09:48",-27.2));
						}
						if(hourEar.equals(EarthlyTimeEnum.WEI.getName())){
//							rb.setTakingMedicineTime("13:24:00 -- 13:48:00");
							rb.setTakingMedicineTime(WeekDays.SubtractTime("13:24",-27.2)+" -- "+WeekDays.SubtractTime("13:48",-27.2));
						}
						if(hourEar.equals(EarthlyTimeEnum.SHEN.getName())){
//							rb.setTakingMedicineTime("15:24:00 -- 15:48:00");
							rb.setTakingMedicineTime(WeekDays.SubtractTime("15:24",-27.2)+" -- "+WeekDays.SubtractTime("15:48",-27.2));
						}
						if(hourEar.equals(EarthlyTimeEnum.YOU.getName())){
//							rb.setTakingMedicineTime("17:24:00 -- 17:48:00");
							rb.setTakingMedicineTime(WeekDays.SubtractTime("17:24",-27.2)+" -- "+WeekDays.SubtractTime("17:48",-27.2));
						}
						if(hourEar.equals(EarthlyTimeEnum.XU.getName())){
//							rb.setTakingMedicineTime("19:24:00 -- 19:48:00");
							rb.setTakingMedicineTime(WeekDays.SubtractTime("19:24",-27.2)+" -- "+WeekDays.SubtractTime("19:48",-27.2));
						}
						if(hourEar.equals(EarthlyTimeEnum.HAI.getName())){
//							rb.setTakingMedicineTime("21:24:00 -- 21:48:00");
							rb.setTakingMedicineTime(WeekDays.SubtractTime("21:24",-27.2)+" -- "+WeekDays.SubtractTime("21:48",-27.2));
						}
						firstList.add(rb);
					}
				}
				// 如果是第三穴时间 则：【子、丑、寅、卯、辰、都不符合条件（23:48:00 ～ 08:12:00） 午（11:48:00 ～ 12:12:00）】
				if(channes.contains(da.getThirdAcupoint())){
					if(hourEar.equals(EarthlyTimeEnum.ZI.getName()) || hourEar.equals(EarthlyTimeEnum.CHOU.getName()) ||
							hourEar.equals(EarthlyTimeEnum.YIN.getName()) || hourEar.equals(EarthlyTimeEnum.MAO.getName()) ||
							hourEar.equals(EarthlyTimeEnum.CHEN.getName()) || hourEar.equals(EarthlyTimeEnum.WU.getName())){
						continue;
					}else{
						ResponseBody rb = new ResponseBody();
						rb.setId(times);
						rb.setTakingMedicineDate(yearAndMonthAndDay);
						rb.setWeek(WeekDays.getWeek(c2));
						if(hourEar.equals(EarthlyTimeEnum.SI.getName())){
//							rb.setTakingMedicineTime("09:48:00 -- 10:12:00");
							rb.setTakingMedicineTime(WeekDays.SubtractTime("09:48",-27.2)+" -- "+WeekDays.SubtractTime("10:12",-27.2));
						}
						if(hourEar.equals(EarthlyTimeEnum.WEI.getName())){
//							rb.setTakingMedicineTime("13:48:00 -- 14:12:00");
							rb.setTakingMedicineTime(WeekDays.SubtractTime("13:48",-27.2)+" -- "+WeekDays.SubtractTime("14:12",-27.2));
						}
						if(hourEar.equals(EarthlyTimeEnum.SHEN.getName())){
//							rb.setTakingMedicineTime("15:48:00 -- 16:12:00");
							rb.setTakingMedicineTime(WeekDays.SubtractTime("15:48",-27.2)+" -- "+WeekDays.SubtractTime("16:12",-27.2));
						}
						if(hourEar.equals(EarthlyTimeEnum.YOU.getName())){
//							rb.setTakingMedicineTime("17:48:00 -- 18:12:00");
							rb.setTakingMedicineTime(WeekDays.SubtractTime("17:48",-27.2)+" -- "+WeekDays.SubtractTime("18:12",-27.2));
						}
						if(hourEar.equals(EarthlyTimeEnum.XU.getName())){
//							rb.setTakingMedicineTime("19:48:00 -- 20:12:00");
							rb.setTakingMedicineTime(WeekDays.SubtractTime("19:48",-27.2)+" -- "+WeekDays.SubtractTime("20:12",-27.2));
						}
						if(hourEar.equals(EarthlyTimeEnum.HAI.getName())){
//							rb.setTakingMedicineTime("21:48:00 -- 22:12:00");
							rb.setTakingMedicineTime(WeekDays.SubtractTime("21:48",-27.2)+" -- "+WeekDays.SubtractTime("22:12",-27.2));
						}
						firstList.add(rb);
					}
				}
				// 如果是第四穴时间 则：【子、丑、寅、卯、辰、都不符合条件（00:12:00 ～ 08:36:00） 午（12:12:00 ～ 12:36:00）】
				if(channes.contains(da.getFourthAcupoint())){
					if(hourEar.equals(EarthlyTimeEnum.ZI.getName()) || hourEar.equals(EarthlyTimeEnum.CHOU.getName()) ||
							hourEar.equals(EarthlyTimeEnum.YIN.getName()) || hourEar.equals(EarthlyTimeEnum.MAO.getName()) ||
							hourEar.equals(EarthlyTimeEnum.CHEN.getName()) || hourEar.equals(EarthlyTimeEnum.WU.getName())){
						continue;
					}else{
						ResponseBody rb = new ResponseBody();
						rb.setId(times);
						rb.setTakingMedicineDate(yearAndMonthAndDay);
						rb.setWeek(WeekDays.getWeek(c2));
						if(hourEar.equals(EarthlyTimeEnum.SI.getName())){
//							rb.setTakingMedicineTime("10:12:00 -- 10:36:00");
							rb.setTakingMedicineTime(WeekDays.SubtractTime("10:12",-27.2)+" -- "+WeekDays.SubtractTime("10:36",-27.2));
						}
						if(hourEar.equals(EarthlyTimeEnum.WEI.getName())){
//							rb.setTakingMedicineTime("14:12:00 -- 14:36:00");
							rb.setTakingMedicineTime(WeekDays.SubtractTime("14:12",-27.2)+" -- "+WeekDays.SubtractTime("14:36",-27.2));
						}
						if(hourEar.equals(EarthlyTimeEnum.SHEN.getName())){
//							rb.setTakingMedicineTime("16:12:00 -- 16:36:00");
							rb.setTakingMedicineTime(WeekDays.SubtractTime("16:12",-27.2)+" -- "+WeekDays.SubtractTime("16:36",-27.2));
						}
						if(hourEar.equals(EarthlyTimeEnum.YOU.getName())){
//							rb.setTakingMedicineTime("18:12:00 -- 18:36:00");
							rb.setTakingMedicineTime(WeekDays.SubtractTime("18:12",-27.2)+" -- "+WeekDays.SubtractTime("18:36",-27.2));
						}
						if(hourEar.equals(EarthlyTimeEnum.XU.getName())){
//							rb.setTakingMedicineTime("20:12:00 -- 20:36:00");
							rb.setTakingMedicineTime(WeekDays.SubtractTime("20:12",-27.2)+" -- "+WeekDays.SubtractTime("20:36",-27.2));
						}
						if(hourEar.equals(EarthlyTimeEnum.HAI.getName())){
//							rb.setTakingMedicineTime("22:12:00 -- 22:36:00");
							rb.setTakingMedicineTime(WeekDays.SubtractTime("22:12",-27.2)+" -- "+WeekDays.SubtractTime("22:36",-27.2));
						}
						firstList.add(rb);
					}
				}
				// 如果是第五穴时间 则：【子、丑、寅、卯、都不符合条件（00:24:00 ～ 07:00:00） 午（12:36:00 ～ 13:00:00）亥（22:36:00 ~ 23:00:00）】
				if(channes.contains(da.getFifthAcupoint())){
					if(hourEar.equals(EarthlyTimeEnum.ZI.getName()) || hourEar.equals(EarthlyTimeEnum.CHOU.getName()) ||
							hourEar.equals(EarthlyTimeEnum.YIN.getName()) || hourEar.equals(EarthlyTimeEnum.MAO.getName()) ||
						    hourEar.equals(EarthlyTimeEnum.WU.getName()) || hourEar.equals(EarthlyTimeEnum.HAI.getName())){
						continue;
					}else{
						ResponseBody rb = new ResponseBody();
						rb.setId(times);
						rb.setTakingMedicineDate(yearAndMonthAndDay);
						rb.setWeek(WeekDays.getWeek(c2));
						if(hourEar.equals(EarthlyTimeEnum.CHEN.getName())){
//							rb.setTakingMedicineTime("08:36:00 -- 09:00:00");
							rb.setTakingMedicineTime(WeekDays.SubtractTime("08:36",-27.2)+" -- "+WeekDays.SubtractTime("09:00",-27.2));
						}
						if(hourEar.equals(EarthlyTimeEnum.SI.getName())){
//							rb.setTakingMedicineTime("10:36:00 -- 11:00:00");
							rb.setTakingMedicineTime(WeekDays.SubtractTime("10:36",-27.2)+" -- "+WeekDays.SubtractTime("11:00",-27.2));
						}
						if(hourEar.equals(EarthlyTimeEnum.WEI.getName())){
//							rb.setTakingMedicineTime("14:36:00 -- 15:00:00");
							rb.setTakingMedicineTime(WeekDays.SubtractTime("14:36",-27.2)+" -- "+WeekDays.SubtractTime("15:00",-27.2));
						}
						if(hourEar.equals(EarthlyTimeEnum.SHEN.getName())){
//							rb.setTakingMedicineTime("16:36:00 -- 17:00:00");
							rb.setTakingMedicineTime(WeekDays.SubtractTime("16:36",-27.2)+" -- "+WeekDays.SubtractTime("17:00",-27.2));
						}
						if(hourEar.equals(EarthlyTimeEnum.YOU.getName())){
//							rb.setTakingMedicineTime("18:36:00 -- 19:00:00");
							rb.setTakingMedicineTime(WeekDays.SubtractTime("18:36",-27.2)+" -- "+WeekDays.SubtractTime("19:00",-27.2));
						}
						if(hourEar.equals(EarthlyTimeEnum.XU.getName())){
//							rb.setTakingMedicineTime("20:36:00 -- 21:00:00");
							rb.setTakingMedicineTime(WeekDays.SubtractTime("20:36",-27.2)+" -- "+WeekDays.SubtractTime("21:00",-27.2));
						}
						firstList.add(rb);
					}
				}
			}
		}
		
//		List<ResponseBody> checkResponseBodyList = this.checkResponseBodyList(firstList);
		
		return firstList;
	}
	
	
	
	/**
	 * 1.对生成的list进行两小时的时间验证，如果不满足则从集合中删除。
	 * 2.对符合时间条件的集合，最多只取三条数据。其余的则舍去。
	 * @param list
	 * @return
	 */
	public List<ResponseBody> checkResponseBodyList(List<ResponseBody> list){
		List<ResponseBody> checkList = list;
		List<ResponseBody> addList = new LinkedList<ResponseBody>();
		if(checkList == null || checkList.size() <= 1){
			return checkList;
		}else{
			for(int i = 0 ; i < checkList.size()-1 ;i++){
				if(i==0){
					addList.add(list.get(i));
				}
				ResponseBody preTime = list.get(i);
				ResponseBody nextTime = list.get(i+1);
				String pre = preTime.getTakingMedicineTime();
				String next = nextTime.getTakingMedicineTime();
				Calendar calendar = Calendar.getInstance();
				if(WeekDays.hasTwoHours(calendar, pre, next)){
					addList.add(list.get(i+1));
				}
			}
		}
		return addList;
	}

}
