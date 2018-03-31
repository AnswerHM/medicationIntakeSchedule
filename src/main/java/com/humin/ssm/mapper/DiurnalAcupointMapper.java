package com.humin.ssm.mapper;

import java.util.List;
import java.util.Map;

import com.humin.ssm.po.DiurnalAcupoint;

/**
 * 
 * @author humin
 *
 */
public interface DiurnalAcupointMapper {
	
	public List<DiurnalAcupoint> queryAllDiurnalAcupointByMap(Map map) throws Exception;

}
