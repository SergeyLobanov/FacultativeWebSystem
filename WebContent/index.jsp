<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="lang" value="${not empty lang ? lang : 'en_US'}" scope="session" />
<fmt:setLocale value="${lang}" />
<fmt:setBundle basename="ua.kpi.localization.messeges" var="bundle"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title><fmt:message key="index.label.title" bundle="${bundle}" /></title>
</head>
<body>
		<form method="POST" action="Controller">
			<input type="hidden" name="command" value="LOCALE">
			<input type="hidden" name="locale" value="en_US">
			<input type="submit" value="en">
        </form>
		<form method="POST" action="Controller">
			<input type="hidden" name="command" value="LOCALE">
			<input type="hidden" name="locale" value="ru_RU">
			<input type="submit" value="ru">
        </form>

	<form method="POST" action="Controller">
		<label><fmt:message key="index.label.login" bundle="${bundle}"/>:</label>
		<input type="text" name="login"><br>
		<label><fmt:message key="index.label.password" bundle="${bundle}"/>:</label>
		<input type="password" name="password"><br>
		<INPUT type="hidden" name="command" value="LOG_IN"/>
		<input type="submit" value="<fmt:message key="index.button.submit" bundle="${bundle}"/>">
	</form>
	<br><c:out value="${message}"/><br>	

</body>
</html>