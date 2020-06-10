<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 

<html>


<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
button {
  background-color: #4CAF50;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 100%;
}

button:hover {
  opacity: 0.8;
}
</style>

</head>

<%
String mins = request.getParameter( "mins" );
if( mins == null ) mins = "20";
  
String secs = request.getParameter( "secs" );
if( secs == null ) secs = "00";
%>
<script>
<!--
function show_alert() {
	  alert("do you want to submit the exam");
	}

var mins = <%=mins%>; // write mins to javascript
var secs = <%=secs%>; // write secs to javascript
function timer()
{
// tic tac
if( --secs == -1 )
{
secs = 59;
--mins;
}
 
// leading zero? formatting
if( secs < 10 ) secs = "0" + secs;             
if( mins < 10 ) mins = "0" + parseInt( mins, 10 );
 
// display
document.forma.mins.value = mins; 
document.forma.secs.value = secs;
 
// continue?
if( secs == 0 && mins == 0 ) // time over
{

document.getElementById("submit").click();
}
else // call timer() recursively every 1000 ms == 1 sec
{
window.setTimeout( "timer()", 1000 );

}
}
//-->
</script>

<SCRIPT type="text/javascript">
 window.history.forward();
 function noBack() { window.history.forward(); }
</SCRIPT>
<body onload="noBack();" onpageshow="if (event.persisted) noBack();" onunload="">

<form action="<%=request.getRequestURL()%>" name="forma">
Time remaining: <input type="text" name="mins" size="1" style="border:0px solid black;text-align:right">:<input type="text" name="secs" size="1" style="border:0px solid black">
<hr></form>
	
	<form:form method="post" action="examdone/"  modelAttribute="exam" id="myquiz" name="quiz">
	   		<form:hidden path="student.id"/>
	   		<h2>WELCOME ${exam.student.userName }</h2>
		 <h3> Your Exam has Started</h3>
		 
		<c:forEach var="quest" items="${exam.question}" varStatus="tagStatus">
		${tagStatus.index+1}. <form:hidden  path="question[${tagStatus.index}].question" readonly="true" />
		<label for="question[${tagStatus.index}].question">${quest.question}</label>
		<br/>
			&emsp;<form:radiobutton path="question[${tagStatus.index}].answer" value=" ${quest.answer1 }"/>&nbsp;A.&nbsp;${quest.answer1 }<br/>
			&emsp;<form:radiobutton path="question[${tagStatus.index}].answer" value=" ${quest.answer2 }"/>&nbsp;B.&nbsp;${quest.answer2 }<br/>
			&emsp;<form:radiobutton path="question[${tagStatus.index}].answer" value=" ${quest.answer3 }"/>&nbsp;C.&nbsp;${quest.answer3 }<br/>
			&emsp;<form:radiobutton path="question[${tagStatus.index}].answer" value=" ${quest.answer4 }"/>&nbsp;D.&nbsp;${quest.answer4 }<br/>
			<br/>
		</c:forEach>
		
		<input id="submit"  type="submit" value="submit test" name="submit" onclick="show_alert()" >
	</form:form>
	
<script>
<!--
timer();
//-->
</script>
</body>
</html>