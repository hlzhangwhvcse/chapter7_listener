<%@ page language="java" pageEncoding="utf-8"%>

<html>
	<head>
		<title>用户注销</title>		
	</head>

	<body>
		<%	
			session.invalidate();//注销用户会话
		%>
		<h3>用户会话注销成功！</h3>
	</body>
</html>