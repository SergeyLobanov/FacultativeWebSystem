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
	<title><fmt:message key="registration.label.title" bundle="${bundle}" /></title>
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<link rel="stylesheet" type="text/css" href="css/index_style.css">
	<script type="text/javascript" src="js/jquery-1.5.2.min.js"></script>
	<script type="text/javascript" src="js/jquery.validate.min.js"></script>	
	<script type="text/javascript" src="js/validation.js" ></script>
</head>
<body>
	<!--  onsubmit="return(validate());" -->
		<form id="registration" method="POST" action="Controller" name="registration">
			<fieldset class="form_info">
				<label for="name"><fmt:message key="registration.label.name" bundle="${bundle}"/>:</label>
				<input type="text" name="name"><br><br>
				<label for="login"><fmt:message key="registration.label.login" bundle="${bundle}"/>:</label>
				<input type="text" name="login"><br><br>
				<label for="password"><fmt:message key="registration.label.password" bundle="${bundle}"/>:</label>
				<input type="password" name="password" id="password"><br><br>
				<label for="confirmPassword"><fmt:message key="registration.label.confirmPass" bundle="${bundle}"/>:</label>
				<input type="password" name="confirmPassword" id="confirmPassword"><br><br>
				<label><fmt:message key="registration.label.status" bundle="${bundle}"/>:</label>
				<select name="status">
					<option selected value="STUDENT"> <fmt:message key="myProfile.label.student" bundle="${bundle}"/>
					<option value="TEACHER"> <fmt:message key="studProfile.label.teacher" bundle="${bundle}"/>
				</select>
			</fieldset>
			<fieldset class="form_action">
				<INPUT type="hidden" name="command" value="SIGN_UP"/>
				<input class="btn" type="submit" value="<fmt:message key="registration.button.reg" bundle="${bundle}"/>">
			</fieldset>			
		</form>
		<div id="message">
			<br><c:out value="${message}"/><br>	
		</div>
 
</body>
</html>
