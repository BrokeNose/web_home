<%@page import="test.friends.dao.FriendsDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>friedns/delete.jsp</title>
</head>
<body>
	<%
		int num=Integer.parseInt(request.getParameter("num"));
		FriendsDao dao=FriendsDao.getInstance();
		dao.delete(num);
	%>
	<script>
		alert("<%=num %>번 삭제를 완료했습니다.");
		location.href="list.jsp";
	</script>
</body>
</html>