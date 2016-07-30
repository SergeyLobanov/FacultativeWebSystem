<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Log in</title>
</head>
<body>
	<form method="POST" action="Controller">
		Login <input type="text" name="login"><br>
		Password<input type="password" name="password"><br>
		<INPUT type="hidden" name="command" value="LOG_IN"/>
		<input type="submit" name="command" value="login">
	</form>
	<br><c:out value="${message}"/><br>	

</body>
</html>