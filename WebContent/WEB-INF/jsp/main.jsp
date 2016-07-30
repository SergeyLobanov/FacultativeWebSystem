<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Facultative</title>
</head>
<body>

Hello <c:out value="${user.getName()}"/> <br>

	<form method="POST" action="Controller">
		<INPUT type="hidden" name="command" value="MY_PROFILE_${status}"/>
		<input type="submit" value="My profile">
	</form>
	<form method="POST" action="Controller">
		<INPUT type="hidden" name="command" value="COURSE_LIST"/>
		<input type="submit" value="All courses">
	</form>
<!--  

<br>
		<a href="./Controller?command=MY_PROFILE_${status}">My profile</a>
		<a href="./Controller?command=COURSE_LIST">All courses</a>-->

</body>
</html>