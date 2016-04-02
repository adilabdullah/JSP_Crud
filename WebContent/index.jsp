<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!--script type="text/javascript" src="Bootstrap/js/bootstrap.js"></script>
<script type="text/javascript" src="Bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="Bootstrap/js/npm.js"></script>
<link rel="stylesheet" href="Bootstrap/css/bootstrap-theme.css">
<link rel="stylesheet" href="Bootstrap/css/bootstrap.css">
<link rel="stylesheet" href="Bootstrap/css/bootstrap.min.css"-->

<script type="text/javascript">
function showData() {
    var search=document.getElementById('search');
  if (window.XMLHttpRequest) {
    // code for IE7+, Firefox, Chrome, Opera, Safari
    xmlhttp=new XMLHttpRequest();
  } else { // code for IE6, IE5
    xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
  }
  xmlhttp.onreadystatechange=function() {
    if (xmlhttp.readyState==4 && xmlhttp.status==200) {
      document.getElementById("showdata").innerHTML=xmlhttp.responseText;
    }
  }
  xmlhttp.open("GET","Retrieve",true);
  xmlhttp.send();
}


function showUpdate() {
  if (window.XMLHttpRequest) {
    // code for IE7+, Firefox, Chrome, Opera, Safari
    xmlhttp=new XMLHttpRequest();
  } else { // code for IE6, IE5
    xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
  }
  xmlhttp.onreadystatechange=function() {
    if (xmlhttp.readyState==4 && xmlhttp.status==200) {
      document.getElementById("showupdate").innerHTML=xmlhttp.responseText;
    }
  }
  xmlhttp.open("GET","Controller",true);
  xmlhttp.send();
}


$(document).ready(function(){
    $("#btn").click(function(){
        $("#result").load("Controller.java");
    });
});

$('#my-element').datepicker([options])
//Access instance of plugin
$('#my-element').data('datepicker')
</script>
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<link href="css/datepicker.min.css" rel="stylesheet" type="text/css">
		<script src="js/datepicker.min.js"></script>
		<!-- Include English language -->
		<script src="js/datepicker.en.js"></script>
</head>
<body>
<div class="container">
<div class="row">
<%
String name=(String)session.getAttribute("name"); 
String father=(String)session.getAttribute("father"); 
out.println("<h1>Welcome to: "+name+" "+father+"</h1>");
%>
</div>
<div class="row">
  <form role="form" action="Controller" method="post">
    <div class="form-group">
      <input type="text" class="form-control" id="name" name="name" placeholder="Enter Name" required>
    </div>
    <div class="form-group">
      <input type="text" class="form-control" id="father" name="father" placeholder="Enter Father" required>
    </div>
    <div class="form-group">
      <input type="number" class="form-control" id="age" name="age" placeholder="Enter Age" required>
    </div>
    <div class="radio">
      Male:<input type="radio" class="form-control" id="sex" name="sex" value="male" required>
     Female:<input type="radio" class="form-control" id="sex" name="sex" value="female" required>
    </div>
      <div class="form-group">
      <input type="text" class="form-control" id="address" name="address" placeholder="Enter Aaddress" required>
    </div>
     <div class="form-group">
      <input type="number" class="form-control" id="cnic" name="cnic" placeholder="Enter CNIC" required>
    </div>
     <div class="form-group">
      <input type="number" class="form-control" id="cell" name="cell" placeholder="Enter Cell" required>
    </div>
    <div class="form-group">
      <input type="text" class="datepicker-here" data-language="en" id="dob" name="dob" placeholder="Enter Date of Birth" required>
    </div>

    <button type="submit" id="btn" name="frmsubmit" class="btn btn-default">Submit</button>
  </form>
</div>

<div class="row" id="result"></div>

<div class="row">
<div class="col-sm-2"></div>
<div class="col-sm-8">
<form name="myForm" method="post" action="Controller">
<input type="text" class="form-control" id="search" name="search" placeholder="Search Record"/>
<input type="submit" class="btn btn-default" name="retrieve" value="Retrieve" />
</form>
</div>
<div class="col-sm-2"></div>
</div>

<div class="row" id="showdata">

</div>



<div class="row" id="showupdate">

</div>


</div>
</body>
</html>