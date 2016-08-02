<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="ex" uri="/WEB-INF/userInfo.tld"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Course info</title>
</head>
<body>
	
	<form method="POST" action="Controller">	
		<ex:userInfo user="${user}"/><br>
		<c:out value="${course}"/><br>
		<c:out value="${course.getCourseTeacher()}"/><br>
		<c:if test="${status eq 'STUDENT'}">
			<INPUT type="hidden" name="command" value="JOIN_COURSE"/>
			<input type="hidden" name="courseId" value="${course.getId()}"/>
			<input type="submit" value="Join course">
		</c:if>	
		<br><c:out value="${message}"/><br>					    	
	</form>

</body>
</html>