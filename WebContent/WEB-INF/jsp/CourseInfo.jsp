<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="ex" uri="/WEB-INF/userInfo.tld"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <fmt:setLocale value="${lang}" />
    <fmt:setBundle basename="ua.kpi.localization.messeges" var="bundle" />
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title><fmt:message key="courseInfo.label.title" bundle="${bundle}" /></title>
	<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	
	<form method="POST" action="Controller">	
		<ex:userInfo user="${user}"/><br>
		<fmt:message key="allCourses.button.courseInfo" bundle="${bundle}"/><br>
		<fmt:message key="allCourses.label.course" bundle="${bundle}"/> : 
		<c:out value="${course.getCourseName()}"/><br>
		<fmt:message key="allCourses.label.teacher" bundle="${bundle}"/> : 
		<c:out value="${course.getCourseTeacher().getName()}"/><br>
		<fmt:message key="allCourses.label.start" bundle="${bundle}"/> : 
		<c:out value="${course.getStartDate()}"/><br>
		<fmt:message key="allCourses.label.end" bundle="${bundle}"/> : 
		<c:out value="${course.getEndDate()}"/><br>
		<c:if test="${user.getStatus() eq 'STUDENT'}">
			<INPUT type="hidden" name="command" value="JOIN_COURSE"/>
			<input type="hidden" name="courseId" value="${course.getId()}"/>
			<input class="button" type="submit" value="<fmt:message key="courseInfo.button.join" bundle="${bundle}"/>">
		</c:if>	
		<br><br><c:out value="${message}"/><br>					    	
	</form>

</body>
</html>