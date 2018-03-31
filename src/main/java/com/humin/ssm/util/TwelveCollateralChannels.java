package com.humin.ssm.util;

import java.util.ArrayList;
import java.util.List;

public class TwelveCollateralChannels {
	
//	足厥阴肝经：大敦、行间、太冲、中封、曲泉
//	足少阳胆经：窍阴、侠溪、临泣、阳辅、阳陵泉
//	手少阴心经：少冲、少府、神门、灵道、少海
//	手太阳小肠：少泽、前谷、后溪、阳谷、小海
//	足太阴脾经：隐白、大都、太白、商丘、阴陵泉
//	足阳明胃经：厉兑、内庭、陷谷、解溪、足三里
//	手太阴肺经：少商、鱼际、太渊、经渠、尺泽
//	手阳明大肠：商阳、二间、三间、阳溪、曲池
//	足少阴肾经：涌泉、然谷、太溪、复溜、阴谷
//	足太阳膀胱：至阴、通谷、束骨、昆仑、委中
//	手厥阴心包：中冲、劳宫、大陵、间使、曲泽
//	手少阳三焦：关冲、液门、中渚、支沟、天井
	
	
	public final static String GANJING = "GANJING";
	public final static String DANJING = "DANJING";
	public final static String XINJING = "XINJING";
	public final static String XIAOCHANGJING = "XIAOCHANGJING";
	public final static String PIJING = "PIJING";
	public final static String WEIJING = "WEIJING";
	public final static String FEIJING = "FEIJING";
	public final static String DACHANGJING = "DACHANGJING";
	public final static String SHENJING = "SHENJING";
	public final static String PANGGUANGJING = "PANGGUANGJING";
	public final static String XINBAOJING = "XINBAOJING";
	public final static String SANJIAOJING = "SANJIAOJING";
	
	private final static List<String> GAN = new ArrayList<String>();//肝经
	private final static List<String> DAN = new ArrayList<String>();//胆经
	private final static List<String> XIN = new ArrayList<String>();//心经
	private final static List<String> XIAOCHANG = new ArrayList<String>();//小肠经
	private final static List<String> PI = new ArrayList<String>();//脾经
	private final static List<String> WEI = new ArrayList<String>();//胃经
	private final static List<String> FEI = new ArrayList<String>();//肺经
	private final static List<String> DACHANG = new ArrayList<String>();//大肠经
	private final static List<String> SHEN = new ArrayList<String>();//肾经
	private final static List<String> PANGGUANG = new ArrayList<String>();//膀胱经
	private final static List<String> XINBAO = new ArrayList<String>();//心包经
	private final static List<String> SANJIAO = new ArrayList<String>();//三焦经
	
	static{
		GAN.add("大敦");
		GAN.add("行间");
		GAN.add("太冲");
		GAN.add("中封");
		GAN.add("曲泉");
		
		DAN.add("窍阴");
		DAN.add("侠溪");
		DAN.add("临泣");
		DAN.add("阳辅");
		DAN.add("阳陵泉");
		
		XIN.add("少冲");
		XIN.add("少府");
		XIN.add("神门");
		XIN.add("灵道");
		XIN.add("少海");
		
		XIAOCHANG.add("少泽");
		XIAOCHANG.add("前谷");
		XIAOCHANG.add("后溪");
		XIAOCHANG.add("阳谷");
		XIAOCHANG.add("小海");
		
		PI.add("隐白");
		PI.add("大都");
		PI.add("太白");
		PI.add("商丘");
		PI.add("阴陵泉");
		
		WEI.add("厉兑");
		WEI.add("内庭");
		WEI.add("陷谷");
		WEI.add("解溪");
		WEI.add("足三里");
		
		FEI.add("少商");
		FEI.add("鱼际");
		FEI.add("太渊");
		FEI.add("经渠");
		FEI.add("尺泽");
		
		DACHANG.add("商阳");
		DACHANG.add("二间");
		DACHANG.add("三间");
		DACHANG.add("阳溪");
		DACHANG.add("曲池");
		
		SHEN.add("涌泉");
		SHEN.add("然谷");
		SHEN.add("太溪");
		SHEN.add("复溜");
		SHEN.add("阴谷");
		
		PANGGUANG.add("至阴");
		PANGGUANG.add("通谷");
		PANGGUANG.add("束骨");
		PANGGUANG.add("昆仑");
		PANGGUANG.add("委中");
		
		XINBAO.add("中冲");
		XINBAO.add("劳宫");
		XINBAO.add("大陵");
		XINBAO.add("间使");
		XINBAO.add("曲泽");
		
		SANJIAO.add("关冲");
		SANJIAO.add("液门");
		SANJIAO.add("中渚");
		SANJIAO.add("支沟");
		SANJIAO.add("天井");
	}
	
	
	public static List<String> getMatchCollateralChannel(String s){
		if(s.equals(GANJING)){
			return GAN;
		}
		if(s.equals(DANJING)){
			return DAN;
		}
		if(s.equals(XINJING)){
			return XIN;
		}
		if(s.equals(XIAOCHANGJING)){
			return XIAOCHANG;
		}
		if(s.equals(PIJING)){
			return PI;
		}
		if(s.equals(WEIJING)){
			return WEI;
		}
		if(s.equals(FEIJING)){
			return FEI;
		}
		if(s.equals(DACHANGJING)){
			return DACHANG;
		}
		if(s.equals(SHENJING)){
			return SHEN;
		}
		if(s.equals(PANGGUANGJING)){
			return PANGGUANG;
		}
		if(s.equals(XINBAOJING)){
			return XINBAO;
		}
		if(s.equals(SANJIAOJING)){
			return SANJIAO;
		}
		return null;
	}
}
