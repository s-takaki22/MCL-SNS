<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="dto.Onetime" %>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
		<link rel="stylesheet" href="https://unpkg.com/ress/dist/ress.min.css">
		<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Philosopher">
		<link rel="stylesheet" href="css/style.css">
		<title>STUDENTS!</title>
</head>
<body>
	<%
	Onetime onetime = (Onetime)session.getAttribute("onetime_data");
	%>
	<h1>STEP2</h1>
	<form action="RegisterOnetimeServlet">
	<label>ワンタイムパスワードを入力してください。</label>
	<input type="text" name="onetime"><br>
	<input type="submit">
	</form>
</body>
</html>