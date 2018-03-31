package com.humin.ssm.controller;

import java.util.Calendar;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.humin.ssm.po.ResponseBody;
import com.humin.ssm.service.DiurnalAcupointService;
import com.humin.ssm.util.CollateralChannelEnum;
import com.humin.ssm.util.TwelveCollateralChannels;
import com.humin.ssm.util.WeekDays;

/***
 * 24分钟开穴请求
 * @author humin
 *
 */
@Controller
@RequestMapping("/ask")
public class DiurnalAcupointController {
	@Resource
	DiurnalAcupointService diurnalAcupointService;
	
	@RequestMapping("/diurnalAcupoint")
	public String getDiurnalAcupoint(String requiredType,HttpServletRequest request,HttpServletResponse response,Model model) throws Exception{
		// 服药时间在早：08:00:00～11:30:00   下午：13:00:00～22:30:00
		String requiredMethod = requiredType;
		// 1.获取方药归经  以及经络代码信息：
		String AName = CollateralChannelEnum.getStatusName(requiredMethod);
		if(AName == null){
			return "error";
		}
		String ACode = CollateralChannelEnum.getStatusCode(requiredMethod);
		model.addAttribute("AName",AName);
		model.addAttribute("ACode",ACode);
		// 2.根据经络 获取对应经络的五输穴
		if(TwelveCollateralChannels.SANJIAOJING.equals(requiredMethod)){
			requiredMethod = "SHENJING";
		}
		if(TwelveCollateralChannels.XINBAOJING.equals(requiredMethod)){
			requiredMethod = "XINJING";
		}
		List<String> channes = TwelveCollateralChannels.getMatchCollateralChannel(requiredMethod);
		// 3.根据日干 获取到子午流注24分钟《日干～开穴》表中的对应日干的开穴数据。
		
//		Calendar c1 = WeekDays.stringToCalendar(WeekDays.getFetureDate(0));
//		Calendar c2 = WeekDays.stringToCalendar(WeekDays.getFetureDate(1));
//		Calendar c3 = WeekDays.stringToCalendar(WeekDays.getFetureDate(2));
//		Calendar c4 = WeekDays.stringToCalendar(WeekDays.getFetureDate(3));
//		Calendar c5 = WeekDays.stringToCalendar(WeekDays.getFetureDate(4));
		
		for(int i = 1 ,j= 1;i<=5;i++){
			Calendar c1 = WeekDays.stringToCalendar(WeekDays.getFetureDate(i-1));
			List<ResponseBody> responseBodyList = diurnalAcupointService.getOpenAcupointTimeByDate(c1, channes,j);
			model.addAttribute("responseBodyList"+i,responseBodyList);
			if(responseBodyList.isEmpty() || responseBodyList == null){
				j = j + 0;
			}else{
				j = j + 1;
			}
		}
		
//		List<ResponseBody> secondList = diurnalAcupointService.getOpenAcupointTimeByDate(c2, channes,2);
//		List<ResponseBody> thirdList = diurnalAcupointService.getOpenAcupointTimeByDate(c3, channes,3);
//		List<ResponseBody> fourthList = diurnalAcupointService.getOpenAcupointTimeByDate(c4, channes,4);
//		List<ResponseBody> fifthList = diurnalAcupointService.getOpenAcupointTimeByDate(c5, channes,5);
//		
//		model.addAttribute("secondList",secondList);
//		model.addAttribute("thirdList",thirdList);
//		model.addAttribute("fourthList",fourthList);
//		model.addAttribute("fifthList",fifthList);
		
		return "table";
	}
}
