<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/include/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta http-equiv="Access-Control-Allow-Origin" content="*">
		<meta name="viewport" content="width=device-width,height=device-height,initial-scale=1.0,maximum-scale=1.0,user-scalable=no" />
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="renderer" content="webkit|ie-comp|ie-stand">
		<meta name="Description" content="">
		<meta name="Keywords" content="">
		<meta http-equiv="Pragma" content="no-cache">
		<meta http-equiv="Cache-control" content="no-store,must-revalidate">
		<meta http-equiv="Cache" content="no-cache">
		<meta http-equiv="expires" content="0">
		<title>子午流注服药时间表</title>
		<link href="<c:url value="/medication/table.css"/>" rel="stylesheet">
		<script src="<c:url value="/static/1.9.1/jquery.min.js"/>"></script>
		<script type="text/javascript">
			$(function(){
			    $('.hebing1').each(function(index, element) {
			        if(!$(this).hasClass('hide')){    
			        	var next=$(this).parent('tr').next('tr').children('.hebing1');//下一个合并的对象
			            $(this).attr('rowspan',1);
		                while($(this).text()==next.text()){
		                    $(this).attr('rowspan',parseInt($(this).attr('rowspan'))+1);
		                    next.hide();
		                    next.addClass('hide');
		                    next=next.parent('tr').next('tr').children('.hebing1');//下一个合并的对象
		                }
			        }
			    });
			    $('.hebing2').each(function(index, element) {
			        if(!$(this).hasClass('hide')){    
			        	var next=$(this).parent('tr').next('tr').children('.hebing2');//下一个合并的对象
			            $(this).attr('rowspan',1);
		                while($(this).text()==next.text()){
		                    $(this).attr('rowspan',parseInt($(this).attr('rowspan'))+1);
		                    next.hide();
		                    next.addClass('hide');
		                    next=next.parent('tr').next('tr').children('.hebing2');//下一个合并的对象
		                }
			        }
			    });
			    $('.hebing3').each(function(index, element) {
			        if(!$(this).hasClass('hide')){    
			        	var next=$(this).parent('tr').next('tr').children('.hebing3');//下一个合并的对象
			            $(this).attr('rowspan',1);
		                while($(this).text()==next.text()){
		                    $(this).attr('rowspan',parseInt($(this).attr('rowspan'))+1);
		                    next.hide();
		                    next.addClass('hide');
		                    next=next.parent('tr').next('tr').children('.hebing3');//下一个合并的对象
		                }
			        }
			    });
			    $('.hebing4').each(function(index, element) {
			        if(!$(this).hasClass('hide')){    
			        	var next=$(this).parent('tr').next('tr').children('.hebing4');//下一个合并的对象
			            $(this).attr('rowspan',1);
		                while($(this).text()==next.text()){
		                    $(this).attr('rowspan',parseInt($(this).attr('rowspan'))+1);
		                    next.hide();
		                    next.addClass('hide');
		                    next=next.parent('tr').next('tr').children('.hebing4');//下一个合并的对象
		                }
			        }
			    });
			    $('.hebing5').each(function(index, element) {
			        if(!$(this).hasClass('hide')){    
			        	var next=$(this).parent('tr').next('tr').children('.hebing5');//下一个合并的对象
			            $(this).attr('rowspan',1);
		                while($(this).text()==next.text()){
		                    $(this).attr('rowspan',parseInt($(this).attr('rowspan'))+1);
		                    next.hide();
		                    next.addClass('hide');
		                    next=next.parent('tr').next('tr').children('.hebing5');//下一个合并的对象
		                }
			        }
			    });
			});
		</script>
	</head>

	<body>
		<h3>《子午流注针药》岁物药法</br>归经最佳服药时间表</br>Medication Intake Schedule</h3>
		<span class="title">方药归经：</span>
		<span class="name">${AName }</span>
		<span class="title">经络代码：</span>
		<span class="name1">${ACode }</span>
		<p class="title">最佳服药时间表</p>
		<p class="title">（服药地点：<span>中国/广东/广州市</span>国家/省市/地区）</p>
		<table>
			<thead>
				<tr>
					<th>序号</th>
					<th>服药日期</th>
					<th>星期</th>
					<th>服药时间段</th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${fn:length(responseBodyList1) > 0 or not empty responseBodyList1 }">
					<c:forEach items="${responseBodyList1}" var="info" varStatus="s">
			            <tr>
			                <td class="hebing1">${info.id}</td>
			                <td>${info.takingMedicineDate}</td>
			                <td>${info.week}</td>
			                <td>${info.takingMedicineTime}</td>
			            </tr>
		            </c:forEach>
				</c:if>
				<c:if test="${fn:length(responseBodyList2) > 0 or not empty responseBodyList2 }">
					<c:forEach items="${responseBodyList2}" var="info" varStatus="s">
			            <tr>
			                <td class="hebing2">${info.id}</td>
			                <td>${info.takingMedicineDate}</td>
			                <td>${info.week}</td>
			                <td>${info.takingMedicineTime}</td>
			            </tr>
		            </c:forEach>
	            </c:if>
	            <c:if test="${fn:length(responseBodyList3) > 0 or not empty responseBodyList3 }">
					<c:forEach items="${responseBodyList3}" var="info" varStatus="s">
			            <tr>
			                <td class="hebing3">${info.id}</td>
			                <td>${info.takingMedicineDate}</td>
			                <td>${info.week}</td>
			                <td>${info.takingMedicineTime}</td>
			            </tr>
	            	</c:forEach>
	            </c:if>
	            <c:if test="${fn:length(responseBodyList4) > 0 or not empty responseBodyList4 }">
					<c:forEach items="${responseBodyList4}" var="info" varStatus="s">
			            <tr>
			                <td class="hebing4">${info.id}</td>
			                <td>${info.takingMedicineDate}</td>
			                <td>${info.week}</td>
			                <td>${info.takingMedicineTime}</td>
			            </tr>
		            </c:forEach>
	            </c:if>
	            <c:if test="${fn:length(responseBodyList5) > 0 or not empty responseBodyList5 }">
					<c:forEach items="${responseBodyList5}" var="info" varStatus="s">
			            <tr>
			                <td class="hebing5">${info.id}</td>
			                <td>${info.takingMedicineDate}</td>
			                <td>${info.week}</td>
			                <td>${info.takingMedicineTime}</td>
			            </tr>
		            </c:forEach>
	            </c:if>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="4" class="tip">注：15天为一个节气，5天为一个气候。</td>
				</tr>
			</tfoot>
		</table>
		<p class="tip">“因人因地因时”制宜，是中医学的特色。请按时用药。</p>
		<span class="descName">说&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;明</span>
		<ul class="desc">
			<li>注：1、此服药时间表，为方药归经的最佳服药时间；</li>
			<li>2、服药频率和时间按医嘱执行，可参照最佳服药时间表；</li>
			<li>3、未按时间服药不会有任何不良反应，但按时服效果好；</li>
			<li>4、服药时间表，在就诊后由医生提供二维码，扫码获得；</li>
			<li>5、每次扫码，将能够获得5天此经络的最佳服药时间表；</li>
		</ul>
		<p class="signature">
			<span>广东省中医院</span>
			<span>子午流注针药传承工作室</span>
		</p>
	</body>

</html>
