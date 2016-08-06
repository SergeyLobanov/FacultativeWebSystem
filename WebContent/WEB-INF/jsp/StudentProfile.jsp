<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="ex" uri="/WEB-INF/userInfo.tld"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <fmt:setLocale value="${lang}" />
    <fmt:setBundle basename="ua.kpi.localization.messeges" var="bundle" />
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title><fmt:message key="myProfile.label.title" bundle="${bundle}" /></title>
	<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
		<ex:userInfo user="${user}"/><br>

		<table border="1" align="center">
		  <tr>
		    <th><fmt:message key="studProfile.label.course" bundle="${bundle}" /></th>
		    <th><fmt:message key="studProfile.label.teacher" bundle="${bundle}" /></th>
		    <th><fmt:message key="studProfile.label.start" bundle="${bundle}" /></th>
		    <th><fmt:message key="studProfile.label.end" bundle="${bundle}" /></th>
		    <th><fmt:message key="myProfile.label.mark" bundle="${bundle}" /></th>
		    <th><fmt:message key="myProfile.label.comment" bundle="${bundle}" /></th>
		  </tr>			
				<c:forEach var="course" items="${courseList}">
				  <tr>
				    	<td><c:out value="${course.getCourse().getCourseName()}"/></td>
				    	<td><c:out value="${course.getCourse().getCourseTeacher().getName()}"/></td>
				    	<td><c:out value="${course.getCourse().getStartDate()}"/></td>
				    	<td><c:out value="${course.getCourse().getEndDate()}"/></td>
					    <td><c:out value="${course.getMark()}"/></td>
					    <td><c:out value="${course.getComment()}"/></td>
				  </tr>		
				</c:forEach>
		</table>					
</body>
</html>