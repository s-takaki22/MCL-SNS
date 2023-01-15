<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="dto.Register"%><!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="https://unpkg.com/ress/dist/ress.min.css">
		<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Philosopher">
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
		<link rel="stylesheet" href="css/style.css">
		<title>STUDENTS!</title>
	</head>
	<body>
	<%
	Register ac = (Register) session.getAttribute("user");
	%>
		<h1>新規投稿</h1>
		<form action="RegisterNewPostServlet" class="mb-3 m-5">
			<input type="hidden" value=<%=ac.getNickName()%> name="nickName">
			<label class="form-label">投稿内容を入力してください。</label>
				<textarea name="note" class="form-control"></textarea><br>
			<input type="submit" class="btn btn-primary">
		</form>
		<a href="#" onclick="history.back(-2);return false;">戻る</a>
	</body>
</html>