<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>All courses</title>
</head>
<body>
	
		<table border="1" align="center">
		<caption>All courses</caption>
		  <tr>
		    <td>Course</td>
		    <td>Teacher</td>
		    <td>Start</td>
		    <td>End</td>
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
						<input type="submit" value="Course info">
					</form>		
					</td>					
				  </tr>					
				</c:forEach>
		</table>

</body>
</html>