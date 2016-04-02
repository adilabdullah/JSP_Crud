<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<link href="css/datepicker.min.css" rel="stylesheet" type="text/css">
<script src=js/datepicker.en.js type="text/javascript"></script>
<script src=js/datepicker.min.js type="text/javascript"></script>
<title>Insert title here</title>
</head>
<body>
<form method="post" action="datentime">
 <input type="text" class="datepicker-here" data-language="en" id="hdate" name="hdate" placeholder="Enter Hire Date">
<input type="time" name="htime" />
<input type="submit" value="submit"/>
</form>
</body>
</html>