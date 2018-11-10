<%@ page language="java"  pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>接收中文</title>		
	</head>

	<body>
		<%		
			String str = request.getParameter("txt");
			if (str != null && !str.equals("")) 
			{
		%>
		接收的内容：	
		<%=str%>
		<%
			}
			else
			{
		
		%>
		<a href="index.jsp">请先输入内容</a>
		<%
			}
		%>
	</body>
</html>
