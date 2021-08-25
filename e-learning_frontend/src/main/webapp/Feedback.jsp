<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="style.css" rel="stylesheet" type="text/css">
<title>Give Feedback</title>
</head>
<body>
	<form action="feedback" method="post">
	<pre>
		User Id     :<input type="number" name="id" /><br>
		Name        :<input type="text" name="name" /> <br>
		Mail        :<input type="mail" name="mail" /><br>
		Feedback Id :<input type="number" name="feedbackId" /><br>
		Feedback    :<input type="text" name="feedback" /> <br>
		
		        <input type="submit" value="Enter" /><br>
	</pre>
	</form>
	
</body>
</html>