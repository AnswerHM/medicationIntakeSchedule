package com.humin.ssm.util;

public enum CollateralChannelEnum {
	DANJING("足少阳 胆经","子"),
	GANJING("足厥阴 肝经","丑"),
	FEIJING("手太阴 肺经","寅"),
	DACHANGJING("手阳明 大肠经","卯"),
	WEIJING("足阳明 胃经","辰"),
	PIJING("足太阴 脾经","巳"),
	XINJING("手少阴 心经","午"),
	XIAOCHANGJING("手太阳 小肠经","未"),
	PANGGUANGJING("足太阳 膀胱经","申"),
	SHENJING("足少阴 肾经","酉"),
	XINBAOJING("手厥阴 心包经","戌"),
	SANJIAOJING("手少阳 三焦经","亥");
	
	private String name;
	
	private String code;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}


	private CollateralChannelEnum(String name,String code){
		this.name = name;
		this.code = code;
	}
	
	static public String getStatusName(String statusName) {
		for (CollateralChannelEnum statusEnum : CollateralChannelEnum.values()) {
			if (statusEnum.name().equals(statusName)) {
				return statusEnum.getName();
			}
		}
		return null;
	}
	
	static public String getStatusCode(String statusName) {
		for (CollateralChannelEnum statusEnum : CollateralChannelEnum.values()) {
			if (statusEnum.name().equals(statusName)) {
				return statusEnum.getCode();
			}
		}
		return null;
	}
	
}
