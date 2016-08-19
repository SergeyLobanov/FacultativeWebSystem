<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="ex" uri="/WEB-INF/userInfo.tld"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <fmt:setLocale value="${lang}" />
    <fmt:setBundle basename="ua.kpi.localization.messeges" var="bundle" />
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title><fmt:message key="myProfile.label.title" bundle="${bundle}" /></title>
	<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>

		<table border="1" align="center">
		<caption>
			<ex:userInfo user="${user}"/> 
		</caption>
		  <tr>
		    <th><fmt:message key="allCourses.label.course" bundle="${bundle}"/></th>
		    <th><fmt:message key="myProfile.label.student" bundle="${bundle}"/></th>
		    <th><fmt:message key="myProfile.label.student" bundle="${bundle}"/></th>
		    <th><fmt:message key="myProfile.label.mark" bundle="${bundle}"/></th>
		    <th><fmt:message key="myProfile.label.comment" bundle="${bundle}"/></th>
		  </tr>			
				<c:forEach var="student" items="${studentList}">
				  <tr>
				    	<td><c:out value="${student.getCourse().getCourseName()}"/></td>
				    	<td><c:out value="${student.getStudent().getName()}"/></td>
					    <td><c:out value="${student.getMark()}"/></td>
					    <td><c:out value="${student.getComment()}"/></td>
						<td>
							<form method="POST" action="Controller">
								<INPUT type="hidden" name="command" value="ESTIMATE_STUDENT"/>
								<INPUT type="hidden" name="index" value="${student.getCourseMemberID()}"/>
								<input class="button" type="submit" value="<fmt:message key="myProfile.button.estimate" bundle="${bundle}"/>">		
							</form>	
						</td>	
				  </tr>		
				</c:forEach>
		</table>		
		<!-- 
		<caption>
		<fmt:message key="myProfile.label.course" bundle="${bundle}"/>: ${studentList.get(0).getCourse().getCourseName()}<br>
		<fmt:message key="myProfile.label.start" bundle="${bundle}"/> ${studentList.get(0).getCourse().getStartDate()}
		, <fmt:message key="myProfile.label.end" bundle="${bundle}"/> ${studentList.get(0).getCourse().getEndDate()}		
		</caption>
		
		 -->			
</body>
</html>