<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/style.css">
<title>Library Viewer</title>
</head>
<body>   
<div class="form-style-5"> 
    <form action="BookServlet" method="post">
    <fieldset>
	<legend><span class="number">📖</span>Library Viewer</legend>
        <input placeHolder="ISBN" type="text" name="isbn">
        <input  placeHolder="Title" type="text" name="title">
        <input  placeHolder="Description" type="text" name="description">

		<select name="option">
		  <option  value="search">Search</option>
		  <option  value="add">Add</option>
		  <option  value="update">Update</option>
		  <option  value="delete">Delete</option>
		</select> 
        </fieldset>

        <input class="submit-button" type="submit" value="Confirm">

    </form>
</div>
</body>
</html>