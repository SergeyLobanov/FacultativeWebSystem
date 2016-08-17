<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="ex" uri="/WEB-INF/userInfo.tld"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
    <fmt:setLocale value="${lang}" />
    <fmt:setBundle basename="ua.kpi.localization.messeges" var="bundle" />
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title><fmt:message key="main.button.addCourse" bundle="${bundle}" /></title>
	<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	
	<form method="POST" action="Controller">	
			<fmt:message key="allCourses.label.course" bundle="${bundle}" />: <input type="text" name="course"><br>
			<fmt:message key="allCourses.label.start" bundle="${bundle}" />: <input type="date" name="start">yyyy-mm-dd<br>
			<fmt:message key="allCourses.label.end" bundle="${bundle}" />: <input type="date" name="end"><br>
			<INPUT type="hidden" name="command" value="ADD_COURSE"/>
			<input class="button" type="submit" value="<fmt:message key="main.button.add" bundle="${bundle}" />"/>
	</form>

</body>
</html>