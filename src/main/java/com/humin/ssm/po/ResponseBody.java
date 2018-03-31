package com.humin.ssm.po;

import java.util.Date;

public class ResponseBody {
	
	private int id;// 序号
	
	private String takingMedicineDate;// 服药日期
	
	private String week;// 星期
	
	private String takingMedicineTime;// 服药时间段

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTakingMedicineDate() {
		return takingMedicineDate;
	}

	public void setTakingMedicineDate(String takingMedicineDate) {
		this.takingMedicineDate = takingMedicineDate;
	}

	public String getWeek() {
		return week;
	}

	public void setWeek(String week) {
		this.week = week;
	}

	public String getTakingMedicineTime() {
		return takingMedicineTime;
	}

	public void setTakingMedicineTime(String takingMedicineTime) {
		this.takingMedicineTime = takingMedicineTime;
	}
	
	
	

}
