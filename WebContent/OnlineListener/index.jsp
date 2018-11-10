<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<html>
	<head>
		<title>在线用户</title>
	</head>
	<body>
		<form action="index.jsp" method="post">
			用户名：
			<input type="text" name="username" />
			<input type="submit" value="登  陆" />
			<a href="logout.jsp">注销</a>
		</form>
		<%
			String username = request.getParameter("username");

			if (username != null && username.trim().length()!=0 ) 
			{
				session.setAttribute("username", username);
			}
			ArrayList online = (ArrayList)application.getAttribute("online");
		%>
		<p>
		<h3>
			当前用户--
			<%= username %>			
			，在线用户
			<%=online.size()%>
			人：
		</h3>
		<hr>
		<%
			Object[] objects = (Object[])online.toArray();
			for (int i = 0; i < objects.length; i++) 
			{		
				Object object = objects[i];
				String user = (String)object;
		%>
				<%=user%>
		<br>
		<%
			}
		%>
	</body>
</html>
