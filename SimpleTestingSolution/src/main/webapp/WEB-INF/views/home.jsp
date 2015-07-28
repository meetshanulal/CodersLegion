<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
	<title>CrossOver Testing Solution</title>
	<style type="text/css">
	.middle
	{
	font-family: sans-serif;
	height: 20%;
	width: 100%;
	text-align: center;
	}
	.back
	{
	background-image: url("<c:url value="/resources/background.jpg" />");
	width: 100%;
	height: 100%;
	background-size: cover;
	}
	.text
	{
	text-align: center;
	
	}
	.err
	{
	color:red;
	}
	</style>
	<script type="text/javascript">
	window.onload= function checkCrededntial()
	{
		
		var description="<c:out value="${error}"/>";
		if(description!="")
		alert(description);
		var para=document.getElementById("errTxt");
		para.innerHTML(description);
	};
	
	</script>
	<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.26/angular.min.js"></script>
	
	
</head>
<body class="back">
<div class="middle">
<h1 >
	<center>  Welcome to online MCQ Test !! </center>
</h1>
</div>
<div class="text">


<h1>  Please Provide the following credentials !! </h1>
<c:url var="addAction" value="/login/user" ></c:url>
<form:form action="${addAction}" commandName="userDetails" method="post" >

<table>
<tr>
<td>Full Name <br></td>
            <td>
            <input type="text" name="fullName"   maxlength="40" />
        </td> 
</tr>
<tr>
 <td>Password <br></td>
        <td>
            <input type="password" name="userPwd" maxlength="40" />
        </td>
</tr>
<tr>
<td> <center><input type="submit" value="Login" > </center></td>
</tr>
<tr>
<td> <p  id="errTxt" class="err"> </p>  </td>
</tr>
</table>



</form:form>


</div>
<div  ng-app  ng-controller="cartController">
<table>
<tr> 
<td>
<p style="border: thick;">Angular Js Examples follows </p>
</td>
</tr>
<tr>
<td>
<p>Enter Some text : <input type="text" ng-model="someText"></p>
   <p>Hello {{ someText }}!</p>
</td>
</tr>
</table>

 <table>
 <tr ng-repeat='item in items'>
 
 <td> {{item.price}}</td>
 <td>{{item.quantity}} </td>
 <td>{{item.title}} </td>
 <td><button ng-click="remove($index)">Remove </button></td>
 </tr>
 <form ng-controller="cartController"  ng-submit="requestFunding()">
Starting: <input ng-change="computeNeeded()"
ng-model="startingEstimate">
Recommendation: {{funding}}
<button>Fund my startup!</button>
</form>	
 
 </table>
  
 
 <script >
 
 function cartController($scope)
 {
	 $scope.items=[ {price:220, quantity:3,title:'pakodas'},{price:330,quantity:4,title:'jalebi'},{price:430,quantity:10,title:'samosas'}  ];
	 $scope.remove= function(index)
	 {
		 $scope.items.splice(index, 1);
	 };
	 
	 $scope.computeNeeded=function()
	 {
		 $scope.funding = $scope.startingEstimate * 10;
	 };
	//$scope.$watch('startingEstimate',computeNeeded);
	 $scope.requestFunding = function() {
		 window.alert("Sorry, please get more customers first.");
		 };
 };
 
 </script>


</div>
</body>
</html>
