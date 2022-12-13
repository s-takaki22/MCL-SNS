<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
		<h1>STEP1</h1>
		<form action="RegisterMailServlet" class="mb-3 m-5">
			<label class="form-label">メールアドレス</label>
				<input type="text" name="mail" class="form-control"><br>
			<input type="submit" class="btn btn-primary">
		</form>
	</body>
</html>