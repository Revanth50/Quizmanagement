<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
  <a href="" target="_self" class="w3-bar-item w3-button w3-green"><i class="fa fa-home" onclick="document.location = 'index.jsp'" ></i>home</a>
  <a href="studentregister" target="_self">Register</a>
  <a href="userlogin" target="_self">login</a>
  <a href="about.jsp" >About</a>
</div>
<body>
<h3>What is an Online Examination System?</h3>
<p>In an online examination system examine get their user id and password with his/her admit card.

This id is already saved in the examination server. When examine login to the server he/she get his/her profile already register.

On the certain time examine gets the message to start the examination.

All answers given by examine are saved into the server with his/her profile information.

Online examination system also allows to correct the answer if the examine needed to change any answer in the examination time duration, however, after the time duration any change will not allow.
</p>
</body>
</html>