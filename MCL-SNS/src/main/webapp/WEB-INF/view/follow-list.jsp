<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="dto.Register" %>
<%@ page import="dto.MemberSearch" %>
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
	<h3>フォロー一覧</h3>
	<ul class="list-group" style="margin:5%">
		<%
		request.setCharacterEncoding("UTF-8");
		List<MemberSearch> list = (List<MemberSearch>)request.getAttribute("accountlist");
		for(int i=0; i<list.size(); i++){
		%>
		<li class="list-group-item"><%=(list.get(i).getAccountName()) %></li>
		<%} %>
	</ul>
	<a href="#" onclick="history.back(-1);return false;">戻る</a>
</body>
</html>