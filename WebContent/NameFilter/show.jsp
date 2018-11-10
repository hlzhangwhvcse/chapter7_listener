<%@ page language="java" pageEncoding="utf-8"%>

<html>
	<head>
		<title>显示结果</title>
	</head>
	<body>
		<%	
			//String name = (String) request.getAttribute("uname");
			String name = request.getParameter("uname") != null && request.getParameter("uname") != ""? request.getParameter("uname"): "匿名用户";
			String content = request.getParameter("msg") != null && request.getParameter("msg") != ""? request.getParameter("msg"): "留言为空";
		%>
		<font color="blue"> <%=name%>的留言内容为：<%=content%> </font>
		<br><a href="index.jsp">返回</a>
	</body>
</html>