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
		session.invalidate();
		%>
		<h1>STEP3</h1>
		<form action="RegisterAccountServlet">
			<table>
				<tr><td>メールアドレス:</td><th><%=onetime.getMail() %></th></tr>
				<tr><td>アカウント名:</td><th><input type="text"></th></tr>
				<tr><td>学校名:</td><th><input type="text"></th></tr>
				<tr><th><input type="submit"></th></tr>
			</table>
		</form>
	</body>
</html>