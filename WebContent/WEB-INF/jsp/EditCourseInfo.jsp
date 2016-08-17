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
	<title><fmt:message key="courseInfo.label.title" bundle="${bundle}" /></title>
	<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	
	<form method="POST" action="Controller">	
		<fmt:message key="allCourses.label.course" bundle="${bundle}" />: <input type="text" name="course" value="${course.getCourseName()}"><br>
		<fmt:message key="allCourses.label.start" bundle="${bundle}" />: <input type="date" name="start" value="${course.getStartDate()}"><br>
		<fmt:message key="allCourses.label.end" bundle="${bundle}" />: <input type="date" name="end" value="${course.getEndDate()}"><br>
		<INPUT type="hidden" name="command" value="SET_COURSE_INFO"/>
		<INPUT type="hidden" name="courseId" value="${course.getId()}"/>
		<input class="button" type="submit" value="<fmt:message key="estimate.label.save" bundle="${bundle}" />"/>
				    	
	</form>

</body>
</html>