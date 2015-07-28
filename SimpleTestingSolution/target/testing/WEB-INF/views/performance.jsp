<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
<style type="text/css">
.back
	{
	background-image: url("<c:url value="/resources/background.jpg" />");
	width: 100%;
	height: 100%;
	background-size: cover;
	
	}



</style>
<title>crossover testing solution</title>
</head>
<body class="back">
<div align="center" style="margin-top: 100px;">
<c:url var="addAction" value="/finish/results" ></c:url>
<form:form action="${addAction}" >
<table>

<tr> 
<td>Score (%) <br><br></td>

<td>${score}</td>
</tr>

<br><br><br>
<tr> 
<td>Grade(on basis of performance) <br><br></td>

<td>${grade}</td>
</tr>

<br><br><br>

<tr> 
<td>Remarks <br></td>

<td>${remarks}</td>
</tr>
<tr>
<td>
<input type="submit" value="Submit Performance"/>
   </td>
</tr>
</table>
</form:form>

</div>
</body>
</html>