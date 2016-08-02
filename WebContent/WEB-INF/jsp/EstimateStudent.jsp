<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="ex" uri="/WEB-INF/userInfo.tld"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Estimate student</title>
</head>
<body>
	
	<form method="POST" action="Controller">	
		<ex:userInfo user="${user}"/><br>
		<c:out value="${courseMember}"/> course<br>
		
		Mark <input type="number" min="0" max="5" name="mark" value="${courseMember.getMark()}"><br>
		Comment<input type="text" name="comment" value="${courseMember.getComment()}"><br>
		<INPUT type="hidden" name="command" value="SET_MARK"/>
		<INPUT type="hidden" name="index" value="${courseMember.getCourseMemberID()}"/>
		<input type="submit" value="Save">
		
		<br><c:out value="${message}"/><br>					    	
	</form>

</body>
</html>