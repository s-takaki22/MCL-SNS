<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="dto.Register" %>
<!DOCTYPE html>
<html lang="ja">
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="https://unpkg.com/ress/dist/ress.min.css">
		<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Philosopher">
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
		<link rel="stylesheet" href="css/style.css">
		<title>STUDENTS!</title>
	</head>
	<body>
	<h1>STEP4</h1>
		<p>お客様の学生証は認証されました。<br>以下の内容で良ければ送信を押してください。</p>
		<%Register register = (Register)session.getAttribute("register"); %>
			<div style="margin:5%">
				<ul class="list-group">
					<label class="form-label">メールアドレス</label>
						<li class="list-group-item"><%=register.getMail()%></li>
					<label class="form-label">パスワード</label>
						<li class="list-group-item">********(セキュリティ上の理由により伏せております。)</li>
					<label class="form-label">アカウント名</label>
						<li class="list-group-item"><%=register.getNickName()%></li>
					<label class="form-label">性</label>
						<li class="list-group-item"><%=register.getLastName()%></li>
					<label class="form-label">名</label>
						<li class="list-group-item"><%=register.getFirstName()%></li>
					<label class="form-label">生年月日</label>
						<li class="list-group-item"><%=register.getBirthday()%></li>
					<label class="form-label">学校名</label>
						<li class="list-group-item"><%=register.getSchoolNamel()%></li>
				</ul>
			</div>
				<a href="RegisterComplete" class="btn btn-primary">送信</a>
	</body>
</html>