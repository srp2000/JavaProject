<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="style.css" rel="stylesheet" type="text/css">

<title>Update Course Fee</title>
</head>
<body>
<h2>Used Course ID to Update Course Details</h2>
<form action="updateCourse" method="post">
<pre>
	Course Id   	    :<input type="number" name="id" /><br>
	Course_name 	    :<input type="text" name="name" /><br>
	Course Fee to Update:<input type="number" name="fee" /><br>
	Course Description  :<input type="text" name="desp" /><br>
	Course Resource     :<input type="text" name="resource" /><br><br>
			 <input type="submit" value="Update" /><br>
 </pre>
</body>
</html>