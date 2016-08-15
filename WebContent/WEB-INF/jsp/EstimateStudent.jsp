<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="ex" uri="/WEB-INF/userInfo.tld"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html">
<html>
    <fmt:setLocale value="${lang}" />
    <fmt:setBundle basename="ua.kpi.localization.messeges" var="bundle" />
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title><fmt:message key="estimate.label.title" bundle="${bundle}" /></title>
	<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	
	<form method="POST" action="Controller">	
		<ex:userInfo user="${user}"/><br>
		<fmt:message key="estimate.label.student" bundle="${bundle}"/> : <c:out value="${courseMember.getStudent().getName()}"/><br>
		
		<fmt:message key="estimate.label.mark" bundle="${bundle}"/> <input type="number" min="0" max="5" name="mark" value="${courseMember.getMark()}"><br>
		<fmt:message key="estimate.label.comment" bundle="${bundle}"/><input type="text" name="comment" value="${courseMember.getComment()}"><br>
		<INPUT type="hidden" name="command" value="SET_MARK"/>
		<INPUT type="hidden" name="index" value="${courseMember.getCourseMemberID()}"/>
		<input class="button" type="submit" value="<fmt:message key="estimate.label.save" bundle="${bundle}"/>">
		
		<br><br><c:out value="${message}"/><br>					    	
	</form>

</body>
</html>