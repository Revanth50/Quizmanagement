<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html>
<title>CSS Website Layout</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>

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
* {
  box-sizing: border-box;
}

body {
  margin: 0;
}

/* Style the header */
.header {
  background-color: #f1f1f1;
  padding: 20px;
  text-align: center;
}

/* Style the top navigation bar */
.topnav {
  overflow: hidden;
  background-color: #333;
}

/* Style the topnav links */
.topnav a {
  float: left;
  display: block;
  color: #f2f2f2;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
}

/* Change color on hover */
.topnav a:hover {
  background-color: #ddd;
  color: black;
}
</style>
<script type="text/javascript">
function logout(){
	window.location.href="http://localhost:4040/SpringQuizManagement/";
}

</script>
</head>
<body>

<div class="header">
  <h1>ONLINE EXAMINATION MANAGEMENT</h1>
</div>
<div class="topnav">
  <a href="" target="_self" class="w3-bar-item w3-button w3-green"><i class="fa fa-home" onclick="document.location = 'index.jsp'" ></i>home</a>
  <a href="studentregister" target="_self">Register</a>
  <a href="userlogin" target="_self">login</a>
  <a href="viewstudents" target="_self">view Reports</a>
  <a href="about.jsp" >About</a>
</div>

<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>your exam is done</h2>
<form:form  method="post"  modelAttribute="score">

<c:forEach var="quest" items="${exam.question}" varStatus="tagStatus">

 ${tagStatus.index+1}. ${quest.question }
 <br/>
 &emsp;	Your answer : ${quest.answer}<br/>
 
 </c:forEach>

<br/><br/><br/><h4>Your score is ${exam.score }</h4>

<br/>


</form:form>

<button onclick="logout()">Logout</button>


</body>
</html>