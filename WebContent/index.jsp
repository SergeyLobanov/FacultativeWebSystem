<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="lang" value="${not empty lang ? lang : 'en_US'}" scope="session" />
<fmt:setLocale value="${lang}" />
<fmt:setBundle basename="ua.kpi.localization.messeges" var="bundle"/>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title><fmt:message key="index.label.title" bundle="${bundle}" /></title>
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<link rel="stylesheet" type="text/css" href="css/index_style.css">
</head>
<body>
	<div class="languages">
		<ul class="lang-switch">
			<li>
			<a href="http://localhost:8087/FacultativeWebSystem/Controller
			?command=LOCALE&locale=en_US">English</a>			
			</li>
			<li>
			<a href="http://localhost:8087/FacultativeWebSystem/Controller
			?command=LOCALE&locale=ru_RU">Русский</a>
			</li>
		</ul>
	</div>
	
		<form  method="POST" action="Controller">
			<fieldset class="form_info">
				<label for="login"><fmt:message key="index.label.login" bundle="${bundle}"/>:</label>
				<input type="text" name="login"><br><br>
				<label for="password"><fmt:message key="index.label.password" bundle="${bundle}"/>:</label>
				<input type="password" name="password"><br>
			</fieldset>
			<fieldset class="form_action">
				<INPUT type="hidden" name="command" value="LOG_IN"/>
				<input class="btn" type="submit" value="<fmt:message key="index.button.submit" bundle="${bundle}"/>">
				<fmt:message key="index.label.or" bundle="${bundle}"/> 
				<a href="http://localhost:8087/FacultativeWebSystem/Controller
						?command=REGISTRATION"><fmt:message key="index.button.reg" bundle="${bundle}"/></a>
			</fieldset>			
		</form>
		<div id="message">
			<br><c:out value="${message}"/><br>	
		</div>
 
</body>
</html>
