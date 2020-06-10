<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

<style>
.error{color:red}
</style>
<body style="background-color:99CCFF">
<html>
<title>CSS Website Layout</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>

body {font-family: Arial, Helvetica, sans-serif;}
form {border: 3px solid #f1f1f1;}

input[type=text], input[type=password] {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  box-sizing: border-box;
}

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

.cancelbtn {
  width: auto;
  padding: 10px 18px;
  background-color: #f44336;
}

.imgcontainer {
  text-align: center;
  margin: 24px 0 12px 0;
}

img.avatar {
  width: 40%;
  border-radius: 50%;
}

.container {
  padding: 16px;
}

span.psw {
  float: right;
  padding-top: 16px;
}

/* Change styles for span and cancel button on extra small screens */
@media screen and (max-width: 300px) {
  span.psw {
     display: block;
     float: none;
  }
  .cancelbtn {
     width: 100%;
  }
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
	  <a href="viewstudents" target="_self">view Reports</a>
	  <a href="about.jsp" >About</a>
	</div>
	
	<h2 style="color:00994C">Welcome Admin Set Questions</h2>
	   <form:form method="post" action="adminaction" modelAttribute="question">  
	       <div class="container">
		       <label for="question"><b>Question</b></label>
		      	<form:input path="question" /><form:errors path="question" cssClass="error"/>
	      		<label for="answer1"><b>Answer1</b></label>
		        <form:input path="answer1" /><form:errors path="answer1" cssClass="error"/>
		        <label for="answer2"><b>Answer2</b></label>
		        <form:input path="answer2" /><form:errors path="answer2" cssClass="error"/>
		        <label for="answer3"><b>Answer3</b></label>
         		<form:input path="answer3" /><form:errors path="answer3" cssClass="error"/>
	         	<label for="answer4"><b>Answer4</b></label>
		       	<form:input path="answer4" /><form:errors path="answer4" cssClass="error"/>
	          	<input type="submit" value="Add Answer to it" /> 
	         	
          	</div>
	    </form:form> 
	       <button onclick="logout()">Logout</button>

</body>
