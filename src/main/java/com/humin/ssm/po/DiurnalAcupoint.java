package com.humin.ssm.po;

/**
 * 开穴时间</p>
 * @author humin
 *
 */
public class DiurnalAcupoint {
	// 主键
	private int id;
	// 日干支
	private String dayChineseEra;
	// 时干支
	private String hourChineseEra;
	// 时辰首穴(01-24分钟)
	private String firstAcupoint;
	// (24-48分钟)
	private String secondAcupoint;
	// (48-72分钟)
	private String thirdAcupoint;
	// (72-96分钟)
	private String fourthAcupoint;
	// (96-120分钟)
	private String fifthAcupoint;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDayChineseEra() {
		return dayChineseEra;
	}
	public void setDayChineseEra(String dayChineseEra) {
		this.dayChineseEra = dayChineseEra;
	}
	public String getHourChineseEra() {
		return hourChineseEra;
	}
	public void setHourChineseEra(String hourChineseEra) {
		this.hourChineseEra = hourChineseEra;
	}
	public String getFirstAcupoint() {
		return firstAcupoint;
	}
	public void setFirstAcupoint(String firstAcupoint) {
		this.firstAcupoint = firstAcupoint;
	}
	public String getSecondAcupoint() {
		return secondAcupoint;
	}
	public void setSecondAcupoint(String secondAcupoint) {
		this.secondAcupoint = secondAcupoint;
	}
	public String getThirdAcupoint() {
		return thirdAcupoint;
	}
	public void setThirdAcupoint(String thirdAcupoint) {
		this.thirdAcupoint = thirdAcupoint;
	}
	public String getFourthAcupoint() {
		return fourthAcupoint;
	}
	public void setFourthAcupoint(String fourthAcupoint) {
		this.fourthAcupoint = fourthAcupoint;
	}
	public String getFifthAcupoint() {
		return fifthAcupoint;
	}
	public void setFifthAcupoint(String fifthAcupoint) {
		this.fifthAcupoint = fifthAcupoint;
	}
	@Override
	public String toString() {
		return "DiurnalAcupoint [id=" + id + ", dayChineseEra=" + dayChineseEra + ", hourChineseEra=" + hourChineseEra
				+ ", firstAcupoint=" + firstAcupoint + ", secondAcupoint=" + secondAcupoint + ", thirdAcupoint="
				+ thirdAcupoint + ", fourthAcupoint=" + fourthAcupoint + ", fifthAcupoint=" + fifthAcupoint + "]";
	}
	
	
}
