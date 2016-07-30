<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Estimate student</title>
</head>
<body>
	
	<form method="POST" action="Controller">	
	
		<c:out value="${user.getName()}"/> user <br>
		<c:out value="${status}"/> status<br> 	
		<c:out value="${courseMember}"/> course<br>
		
		Mark <input type="number" min="0" max="5" name="mark" value="${courseMember.getMark()}"><br>
		Comment<input type="text" name="comment" value="${courseMember.getComment()}"><br>
		<INPUT type="hidden" name="command" value="SET_MARK"/>
		<input type="submit" name="command" value="Save">
		
		<br><c:out value="${message}"/><br>	
				    	
	</form>
	<!-- 
		<c:out value="${index}"/> index<br>	
		<c:out value="${courseId}"/> courseId<br>	

	 -->

</body>
</html>