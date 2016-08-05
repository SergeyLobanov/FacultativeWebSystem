<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <fmt:setLocale value="${lang}" />
    <fmt:setBundle basename="ua.kpi.localization.messeges" var="bundle" />
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><fmt:message key="allCourses.label.title" bundle="${bundle}" /></title>
</head>
<body>
	
		<table border="1" align="center">
		<caption><fmt:message key="allCourses.label.title" bundle="${bundle}" /></caption>
		  <tr>
		    <td><fmt:message key="allCourses.label.course" bundle="${bundle}" /></td>
		    <td><fmt:message key="allCourses.label.teacher" bundle="${bundle}" /></td>
		    <td><fmt:message key="allCourses.label.start" bundle="${bundle}" /></td>
		    <td><fmt:message key="allCourses.label.end" bundle="${bundle}" /></td>
		  </tr>		
			<c:forEach var="course" items="${courseList}">
				  <tr>
				    <td><c:out value="${course.getCourseName()}"/> 
				    <td><c:out value="${course.getCourseTeacher().getName()}"/></td>
				    <td><c:out value="${course.getStartDate()}"/></td>
				    <td><c:out value="${course.getEndDate()}"/></td>	
				    <td>
					<form method="POST" action="Controller">
						<INPUT type="hidden" name="command" value="COURSE_INFO"/>
						<input type="hidden" name="courseId" value="${course.getId()}">
						<input type="submit" value="<fmt:message key="allCourses.button.courseInfo" bundle="${bundle}"/>">
					</form>		
					</td>					
				  </tr>					
				</c:forEach>
		</table>

</body>
</html>