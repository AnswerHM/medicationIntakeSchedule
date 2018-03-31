package com.humin.ssm.util;


/***
 * 地支时间对应起始时间：
 * @author humin
 *
 */
public enum EarthlyTimeEnum {
	
	ZI("子", "23:00:00"), 
	CHOU("丑", "01:00:00"), 
	YIN("寅", "03:00:00"),
	MAO("卯", "05:00:00"),
	CHEN("辰", "07:00:00"),
	SI("巳", "09:00:00"),
	WU("午", "11:00:00"),
	WEI("未", "13:00:00"),
	SHEN("申", "15:00:00"),
	YOU("酉", "17:00:00"),
	XU("戌", "19:00:00"),
	HAI("亥", "21:00:00");
	
	private String name;
	
	private String value;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	private EarthlyTimeEnum(String name, String value) {
		this.name = name;
		this.value = value;
	}
	
	static public String getStatusName(String statusName) {
		for (EarthlyTimeEnum statusEnum : EarthlyTimeEnum.values()) {
			if (statusEnum.name().equals(statusName)) {
				return statusEnum.getName();
			}
		}
		return null;
	}
	
	static public String getStatusValue(String statusName) {
		for (EarthlyTimeEnum statusEnum : EarthlyTimeEnum.values()) {
			if (statusEnum.name().equals(statusName)) {
				return statusEnum.getValue();
			}
		}
		return null;
	}

}
