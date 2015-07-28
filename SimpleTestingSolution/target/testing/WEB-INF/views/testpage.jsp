<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<html>
<head>
<style type="text/css">
.back {
	background-image: url("<c:url value="/ resources/ background.jpg " />");
	width: 100%;
	height: 100%;
	background-size: cover;
}

.upper {
	width: 100%;
	height: 20%;
	text-align: center;
}

.leftone {
	width: 30%;
	height: 100%;
	float: left;
	border: ex;
	text-align: center;
}

.rightone {
	align: center;
	border: ex;
}

.timer {
	float: right;
	text-align: center;
}
<
link
 
rel
="stylesheet"
 
href
="http
:
//code
.jquery
.com
/ui/1
.11
.1
/themes/black-tie/jquery-ui
.css
"/
>
</style>
<title>Crossover Testing</title>

<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.7.js">
	
</script>
<script type="text/javascript">
	var indexofitemclicked;
	var questionis;
	var optionis;
	var answeris;
	var array;
	var choiceselected;
	var userresponse;
	function updaterequest(question, questionoptions, questionanswer, index) {
		//alert("Hi" +question+ "options" + questionoptions+ "answer" + questionanswer + "index is"+index );
		//alert(questionans + "options" );
		questionis = question;
		optionis = questionoptions;
		answeris = questionanswer;
		indexofitemclicked = index;
		//alert(questionoptions);
		array = questionoptions.split(";");
		var newitem;
		var label;

		for (var i = 0; i < array.length; i++) {
			if (i == 0) {
				var option = document.getElementById("radio1");
				//label=option.nextSibling;
			}
			if (i == 1) {
				var option = document.getElementById("radio2");
				//label=option.nextSibling;
			}

			if (i == 2) {
				var option = document.getElementById("radio3");
				// label=option.nextSibling;
			}
			if (i == 3) {
				var option = document.getElementById("radio4");
				//label=option.nextSibling;
			}

			newitem = array[i];
			//alert("new item is "+newitem);

			option.innerHTML = newitem; //.value
		}
		option = document.getElementById("questionstat");
		option.innerHTML = questionis;

	};
	function nextPressed() {
		indexofitemclicked = indexofitemclicked + 1;
		if (indexofitemclicked < 9) {
			//alert("next clicked"+ indexofitemclicked);
			document.getElementById(indexofitemclicked).click();
		}

	};
	function prevPressed() {
		indexofitemclicked = indexofitemclicked - 1;
		if (indexofitemclicked > 0) {
			//alert("prev clicked" + indexofitemclicked);
			document.getElementById(indexofitemclicked).click();
		}
	};
	function storeresponse(index) {
		userresponse = array[index];
		//alert("user response is"+userresponse);

	};
	function processresponse() {
		// 	var formattrb= document.forms['testSubmission'];
		//  var sendtext=document.getElementById("checkedans");    // to be changed
		// sendtext.innerHTML=userresponse;
        alert(userresponse+indexofitemclicked);
      
		document.forms["testSubmission"]["checkedans"+ indexofitemclicked].value = userresponse;
	//document.forms["testSubmission"]["questionstat"].setAttribute('name','${questionlist[indexofitemclicked].questions}');
	};

	window.onload = function() {

		var beginques = document.getElementById("questionstat");
		beginques.innerHTML = "The Class java.lang.Exception is ";

		beginques = document.getElementById("radio1");
		beginques.innerHTML = "protected";

		beginques = document.getElementById("radio2");
		beginques.innerHTML = "extends Throwable";

		beginques = document.getElementById("radio3");
		beginques.innerHTML = "implements Throwable";

		beginques = document.getElementById("radio4");
		beginques.innerHTML = "Serializable";
	}

	$(function() {
		$("#dialog1").dialog({
			autoOpen : false,
		});
		$("#dialog5").dialog({
			autoOpen : false,
		});
	});

	setInterval(
			function() {
				var timer = $('span').html();
				timer = timer.split(':');
				var minutes = timer[0];
				var seconds = timer[1];
				seconds -= 1;
				if (minutes < 0)
					return;

				if (minutes == 5 && seconds == 0) {
					alert("Only 5 minute is left. Just to make you sure of Time passing by !!");
				}

				if (minutes == 0 && seconds == 0) {
					alert("Test over !!");
					document.getElementById("testSubmission").submit();

				}
				if (minutes == 1 && seconds == 0) {
					//$( "#dialog1" ).dialog( "open" );
					alert("Only 1 minute is left.Test will auto submit, when time is over, So Please hurry !!");
				}

				if (seconds < 0 && minutes != 0) {
					minutes -= 1;
					seconds = 59;
				} else if (seconds < 10 && seconds.length != 2)
					seconds = '0' + seconds;
				if (minutes < 10 && minutes.length != 2)
					minutes = '0' + minutes;
				$('span').html(minutes + ':' + seconds);
			}, 1000);

	function optionSelected(value) {
		choiceselected = value;
	}
</script>









</head>
<body class="back">
	<div style="font-size: 12px; visibility: hidden;" id="dialog1"
		title="Attention !!">
		<p>Only 1 minute is left.Test will auto submit, when time is over,
			So Please hurry !!</p>
	</div>
	<div style="font-size: 12px; visibility: hidden;" id="dialog5"
		title="Attention !!">
		<p>Only 5 minute is left. Just to make you sure of Time passing by
			!!</p>
	</div>

	<div class="upper">
		<table>
			<tr>
				<h2>Answer the following questions</h2>
			</tr>

			<tr class="timer">
				<td>
					<p>Time Remaining --</p>
				</td>
				<td><span style="float: right; font-size: medium;">20:00</span>
				</td>

			</tr>

		</table>
	</div>
	<c:url var="addAction" value="/submittest"></c:url>
	<form:form id="testSubmission" action="${addAction}"
		modelattribute="questionlist"  method="post">

		<div class="leftone">

			<table>
				<tr>
					<td>
						<p>Question list follows:</p>
					</td>
				</tr>

				<c:forEach items="${questionlist.questions}" var="questions"
					varStatus="status">
					<script type="text/javascript">
						
					</script>
					<tr>
						<td><a href="#" id='${status.index}'
							onclick="updaterequest('${questions.question}','${questions.options}','${questions.answer}','${status.index}')">(${status.index}).${questions.questionTag}</a>
							<input type="hidden" id="checkedans${status.index}"
							name="questions[${status.index}].userResponse" >
							<input type="hidden" name="questions[${status.index}].question" value="${questions.question}">
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<div class="rightone" align="center">
			<table>
				<tr>
					<td>
						<p id="questionstat" />
					</td>
				</tr>
				<tr>

					<td><input type="radio" onclick="storeresponse(0)"
						name="common" /><label id="radio1"></label><br> <input
						type="radio" onclick="storeresponse(1)" name="common" /><label
						id="radio2"></label><br> <input type="radio"
						onclick="storeresponse(2)" name="common" /><label id="radio3"></label><br>
						<input type="radio" onclick="storeresponse(3)" name="common" /><label
						id="radio4"></label></td>

				</tr>
				<tr>

					<td><input type="button" value="previous"
						onclick="prevPressed()"></td>

					<td><input type="button" value="submit answer"
						onclick="processresponse()"></td>

					<td><input type="button" value="next" onclick="nextPressed()">
					</td>
				<tr>
					<td><input type="submit" value="Submit Test" /></td>
				</tr>


			</table>
		</div>
	</form:form>



</body>
</html>