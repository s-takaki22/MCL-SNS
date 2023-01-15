<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="dto.Register"%>
<%@ page import="dto.RegisterNewPost"%><!DOCTYPE html>
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
<title><%= ac.getNickName()%></title>
</head>
<body>
	<h3>STUDENT!</h3>
	<p>
		ようこそ<%=ac.getNickName()%>さん
	</p>
	<div style="margin: 3%;">
		<a href="NewPostServlet" class="btn btn-primary">新規投稿</a>
	</div>
	<div style="margin: 3%;">
		<a href="FollowRegisterServlet" class="btn btn-primary">アカウント検索</a>
	</div>
	<div style="margin: 3%;">
		<form action="FollowListServlet">
			<input type="hidden" name="accountname" value="<%= ac.getNickName() %>">
			<input type="submit" value="フォロー一覧" class="btn btn-primary">
		</form>
	</div>
	<div style="margin: 3%;">
		<a href="LogoutServlet" class="btn btn-primary">ログアウト</a>
	</div>

	<%
	request.setCharacterEncoding("UTF-8");
	List<RegisterNewPost> list = (List<RegisterNewPost>)request.getAttribute("list");
	
	for(int i=0; i<list.size(); i++){
	%>
	<p><%=(list.get(i)).getNote()%></p>
	<%} %>
</body>
</html>