<%@page import="test.friends.dao.FriendsDao"%>
<%@page import="test.member.dao.MemberDao"%>
<%@page import="test.friends.dto.FriendsDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>friends/insert.jsp</title>
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");
	//폼전송되는 파라미터 추출
	String name= request.getParameter("name");
	String phone= request.getParameter("phone");
	//FriendsDao 에 담아서
	FriendsDto dto=new FriendsDto();
	dto.setName(name);
	dto.setPhone(phone);
	//FriendsDao 객체를 이요해서 DB에 저장
	FriendsDao dao=FriendsDao.getInstance();
	dao.insert(dto);	
%>
	<p>친구 정보가 추가 되었습니다.</p>
	<a href="list.jsp">목록 보기</a>
</body>
</html>