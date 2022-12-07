<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="https://unpkg.com/ress/dist/ress.min.css">
		<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Philosopher">
		<link rel="stylesheet" href="css/style.css">
		<title>STUDENTS!</title>
	</head>
	<body>
		<h1>STEP1</h1>
		<form action="RegisterMailServlet">
			<table>
				<tr><td>メールアドレス</td><th><input type="text" name="mail"></th></tr>
				<tr><th><input type="submit"></th></tr>
			</table>
		</form>
	</body>
</html>