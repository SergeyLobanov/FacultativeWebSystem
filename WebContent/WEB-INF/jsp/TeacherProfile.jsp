<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MyProfile</title>
</head>
<body>

		<table border="1" align="center">
		<caption>
		Your course: ${studentList.get(0).getCourse().getCourseName()}<br>
		start ${studentList.get(0).getCourse().getStartDate()}
		, end ${studentList.get(0).getCourse().getEndDate()}		
		</caption>
		<c:set var="course" value="${studentList.get(1).getCourse()}" scope="session"/>
		  <tr>
		    <td>Student</td>
		    <td>Mark</td>
		    <td>Comment</td>
		  </tr>			
				<c:forEach var="student" items="${studentList}" varStatus="status">
				  <tr>
				    	<td><c:out value="${student.getStudent().getName()}"/></td>
					    <td><c:out value="${student.getMark()}"/></td>
					    <td><c:out value="${student.getComment()}"/></td>
						<td>
							<form method="POST" action="Controller">
								<INPUT type="hidden" name="command" value="ESTIMATE_STUDENT"/>
								<INPUT type="hidden" name="index" value="${status.index}"/>
								<input type="submit" value="Estimate student">		
							</form>	
						</td>	
					<!--
					    <td><c:out value="${a.getMark()}"/></td>
					    <td><c:out value="${a.getComment()}"/></td>
					    
				    <td>
					<INPUT type="hidden" name="command" value="COURSE_INFO"/>

					<c:set var="course" value="${a}" scope="session"/>
					<INPUT type="hidden" name="course" value="${a}"/>
					
					<input type="submit" name = "this" value="Course info">
					</td>
					-->
				  </tr>		
				</c:forEach>
		</table>					
</body>
</html>