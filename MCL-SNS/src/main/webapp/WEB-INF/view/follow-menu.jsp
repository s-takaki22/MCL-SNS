<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="dto.Register" %>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://unpkg.com/ress/dist/ress.min.css">
		<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Philosopher">
		<!-- CSS only -->
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
		<link rel="stylesheet" href="css/style.css">
<%
	Register ac = (Register) session.getAttribute("user");
%>
<title><%= ac.getNickName() + "NewFollow"%></title>
</head>
<body>
	<h3>アカウント検索</h3>
	<form action="FollowSearchServlet" class="mb-5 m-5">
		<label>アカウント名を検索
			<input type="text" name="accountname" class="form-control">
		</label>
		<input type="submit" value="検索" class="btn btn-primary">
	</form>
	<a href="#" onclick="history.back();return false;">戻る</a>
</body>
</html>