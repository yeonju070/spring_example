<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL fmt 라이브러리</title>
</head>
<body>
	<c:set var="number" value="12345678" />
	<h1>숫자 출력</h1>
	<fmt:formatNumber value="${number}" />
	
	<h1>Type</h1>
	숫자: <fmt:formatNumber value="${number}" type="number" /><br>
	숫자 3자리마다 쉼표 제거: <fmt:formatNumber value="${number}" type="number" groupingUsed="false" /><br>
	
	<%-- percent는 1이 100% --%>
	100%: <fmt:formatNumber value="1" type="percent" /><br> 
	40%: <fmt:formatNumber value="0.4" type="percent" /><br>
	
	통화(원): <fmt:formatNumber value="${number}" type="currency" /><br>
	통화(달러): <fmt:formatNumber value="${number}" type="currency" currencySymbol="$"/>
	
	<h1>var로 변수에 저장</h1>
	<fmt:formatNumber value="${number}" type="currency" currencySymbol="$" var="doller"/>
	달러 EL태그로 출력: ${doller}<br>
	
	<h1>pattern</h1>
	3.14: <fmt:formatNumber value="3.14" /><br>
	3.14(0.0000): <fmt:formatNumber value="3.14" pattern="0.0000" /><br>
	3.14(#.####): <fmt:formatNumber value="3.14" pattern="#.####" /><br>
	3.14(#.####): <fmt:formatNumber value="3.141592" pattern="#.####" /><br>
	
	<hr>
	
	<h1>Date 객체를 String 형태로 출력 => fmt:formatDate</h1>
	
	<fmt:formatDate var="pattern1" value="${today}" pattern="yyyy년 MM월 dd일 HH시 mm분 ss초" />
	pattern1: ${pattern1}<br> 
	<fmt:formatDate var="pattern2" value="${today}" pattern="yyyy/MM/dd HH:mm:ss" />
	pattern2: ${pattern2}<br> 
	
	
	<h1>String을 Date 객체로 변환 => fmt:parseDate</h1>
	
	<fmt:parseDate value="${pattern2}" pattern="yyyy/MM/dd HH:mm:ss" var="date2"/>
	Date 객체: ${date2}
</body>
</html>