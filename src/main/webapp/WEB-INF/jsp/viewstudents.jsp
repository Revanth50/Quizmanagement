    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  


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

table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

td, th {
  border: 1px solid #dddddd;
  text-align: left;
  padding: 8px;
}

tr:nth-child(even) {
  background-color: #dddddd;
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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<script type="text/javascript">
function showGraph() {

	var rowCount = $('table#table tr:last').index() + 1;
	var dataPoints = [];
	for(var i=2;i<=rowCount;i++){ 
			dataPoints.push( { y: parseInt($("table").find("tr:nth-child("+i+")").find("td:nth-child(4)").text()) ,label: $("table").find("tr:nth-child("+i+")").find("td:nth-child(2)").text()});
	}
var chart = new CanvasJS.Chart("chartContainer", {
	animationEnabled: true,
	
	title:{
		text:"Student Reports"
	},
	axisX:{
		interval: 1
	},
	axisY2:{
		interlacedColor: "rgba(1,77,101,.2)",
		gridColor: "rgba(1,77,101,.1)",
		title: "Mark"
	},
	data: [{
		type: "bar",
		name: "marks",
		axisYType: "secondary",
		color: "#014D65",
		dataPoints: dataPoints
	}]
});
chart.render();



}
</script>


</head>
<body>

<div class="header">
  <h1>ONLINE EXAMINATION MANAGEMENT</h1>
</div>
<div class="topnav">
  <a href="" target="_self" class="w3-bar-item w3-button w3-green"><i class="fa fa-home" onclick="document.location = 'index.jsp'" ></i>home</a>

  <a href="about.jsp" >About</a>
</div>
<body>
<button onclick="logout()">Logout</button>


     
    <br/>
<div id="chartContainer" style="height: 300px; width: 100%;">


<h2 style="color:FF6666">Students List</h2>
	<table id="table">
	<tr><th style="color:99004C">Id</th><th style="color:99004C">User Name</th><th style="color:99004C">Mail Id</th><th style="color:99004C">Marks</th></tr>
    <c:forEach var="student" items="${list}"> 
    
    
    <tr>
    <td align="center" style="color:330033">${student.id}</td> 
    <td align="center" style="color:330033">${student.userName}</td>
    <td align="center" style="color:330033">${student.mail}</td>
    <td align="center" style="color:330033">${student.marks}</td>
    
    </tr>
    </c:forEach>
 
    </table>
    
      <button onclick="showGraph()">Show Graph</button>


</div>
<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>

</body>
	