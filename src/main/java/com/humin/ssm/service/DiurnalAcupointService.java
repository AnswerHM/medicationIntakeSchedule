package com.humin.ssm.service;

import java.util.Calendar;
import java.util.List;
import java.util.Map;

import com.humin.ssm.po.DiurnalAcupoint;
import com.humin.ssm.po.ResponseBody;

public interface DiurnalAcupointService {
	
	public List<DiurnalAcupoint> queryAllDiurnalAcupointByMap(Map map) throws Exception;
	
	
	public List<ResponseBody> getOpenAcupointTimeByDate(Calendar c2,List<String> channes,Integer times) throws Exception;
}
