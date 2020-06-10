<!DOCTYPE html>
<html lang="en">
<head>
<title>CSS Website Layout</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
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
</head>
<body>

<div class="header">
  <h1>ONLINE EXAMINATION MANAGEMENT</h1>
</div>

<div class="topnav">
  <a href="index.jsp" target="_self" class="w3-bar-item w3-button w3-green"><i class="fa fa-home" onclick="document.location = 'index.jsp'" ></i>home</a>
  <a href="studentregister" target="_self">Register</a>
  <a href="userlogin" target="_self">login</a>
  <a href="about.jsp" >About</a>
</div>

<div class="content">
  <h2>E-Exam</h2>
  <p>An eExam (e-exam) is a timed, supervised, summative assessment conducted using each candidate's own computer running a standardised operating system. Such examinations have advantages over paper-based exams, and can include new multi-media, simulation and software test items which give higher validity in respect of professional work practice.[1]

Electronic exams offer benefits such as ease of marking, reduced need to read illegible handwriting, saving of time and raw materials and reduced logistical overheads</p>
</div>

</body>
</html>

  
