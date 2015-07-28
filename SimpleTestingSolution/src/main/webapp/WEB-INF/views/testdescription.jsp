<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html >
<head>
<style type="text/css">
	.back
	{
	background-image: url("<c:url value="/resources/background.jpg" />");
	width: 100%;
	height: 100%;
	background-size: cover;
	}
   .answer
   {
   visibility: hidden;
   }

</style>

<script type="text/javascript">

var description="<c:out value="${testdesc}"/>";

   window.onload= function setRules()
 {    
	var array= description.split(";");
	var para=document.getElementById("testdesc");
	var newitem= "<ol>\n";
	for (var i=0;i<array.length;i++)
		{
		newitem=newitem + "<li>" + array[i] + "</li>\n";
		}
	newitem = newitem + "</ol>";
	para.innerHTML=newitem;
   };

   function goBack()
   {
	   window.history.back();
   };
   
   
  
</script>
<title>Crossover Testing</title>
</head>



<body class="back" >
<h1><center> Test Instructions !!</center></h1>
<br> <br> <br>
<div id="testdesc"></div>
<div id="submitsection">
<table >
<tr>
<td>
<c:url var="addAction" value="/beginTest/Java" ></c:url>
<form:form id="abc" action="${addAction}" method="post" >
<input type="submit" value="Begin Test"  onclick="abc() "/>

</form:form>
</td>
</tr>
<tr>
<td>
<input type="button"  value="Quit Test"  onclick="goBack()"/>
</td>
</tr>






</table>


</div>


</body>
</html>
