<%@ page language="java" pageEncoding="utf-8"%>

<html>
	<head>
		<title>用户留言</title>		
	</head>

	<body>	
		<form action="show.jsp" method="post">
			用户名：
			<input type="text" name="uname">
			<br>
			留&nbsp;&nbsp;&nbsp;&nbsp;言：
			<input type="text" name="msg">
			<br>
			<input type="submit" value="提交">
		</form>
	</body>
</html>