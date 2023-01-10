<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><%@ page import="java.util.*" %><%@ page import="dto.Register"%><%@ page import="dto.RegisterNewPost" %><!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>メニュー</title>
</head>
<body>
	<%
	Register ac = (Register) session.getAttribute("user");
	%><h3>就活管理システム</h3>
	<p>
		ようこそ<%=ac.getNickName()%>さん
	</p>
	<a href="NewPostServlet">新規投稿</a>
	<br>
	<a href="LogoutServlet">ログアウト</a>
	
	<%
	request.setCharacterEncoding("UTF-8");
	List<RegisterNewPost> list = (List<RegisterNewPost>)request.getAttribute("list");
	
	for(int i=0; i<list.size(); i++){
	%>
	<p><%=(list.get(i)).getNote()%></p>
	<%} %>
</body>
</html>