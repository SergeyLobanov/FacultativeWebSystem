<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="ex" uri="/WEB-INF/userInfo.tld"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <fmt:setLocale value="${lang}" />
    <fmt:setBundle basename="ua.kpi.localization.messeges" var="bundle" />
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title><fmt:message key="main.label.title" bundle="${bundle}" /></title>
	<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>

	<fmt:message key="main.label.greeting" bundle="${bundle}"/> <ex:userInfo user="${user}"/> <br>

	<form method="POST" action="Controller">
		<INPUT type="hidden" name="command" value="MY_PROFILE_${user.getStatus()}"/>
		<input class="button" type="submit" value="<fmt:message key="main.button.myProfile" bundle="${bundle}"/>">
	</form>
	<form method="POST" action="Controller">
		<INPUT type="hidden" name="command" value="COURSE_LIST"/>
		<input class="button" type="submit" value="<fmt:message key="main.button.allCourses" bundle="${bundle}"/>">
	</form>
	<c:if test="${user.getStatus() eq 'TEACHER'}">
		<form method="POST" action="Controller">
			<INPUT type="hidden" name="command" value="NEW_COURSE"/>
			<input class="button" type="submit" value="<fmt:message key="main.button.addCourse" bundle="${bundle}"/>"/>
		</form>
	</c:if>					    	
	
</body>
</html>