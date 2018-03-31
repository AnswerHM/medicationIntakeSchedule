/**
 * Mar 16, 2018
 */
package com.humin.ssm.controller.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;


/** 
 * @ClassName: CustomDateConverter 
 * @Description: 日期转换器</p>
 * @author humin 
 * @date Mar 16, 2018 11:57:44 AM 
 *  
 */
public class CustomDateConverter implements Converter<String,Date>{

	public Date convert(String source) {
		// 实现将日期串转换成日期类型
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		try {
			// 转换直接返回
			return simpleDateFormat.parse(source);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 如果参数绑定失败返回null
		return null;
	}

}
