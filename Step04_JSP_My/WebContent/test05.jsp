<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>test05.jsp</title>
</head>
<body>
<%-- 
	여기는 주석영역 입니다. jsp 페이지가 해석하지 않아요
 --%>

 <%!
//여기는 클래스 안쪽 영역입니다.
 	//오류안나지?
 	//멤버필드
 	public String myName="김구라";
 	
 	
 	public void test(){
	 
 	}
 %>
  <%
 	//여기는 service() 메소드 안쪽 영역입니다.
 	//service() 메소드 안에서 myName 이라는 필드참조
 	System.out.println(myName);
 	//service() 메소드 안에서 test() 멤버 메소드 호출
 	test(); 	
 %>
 <%@
 	//임폴트(선언부)
 %>
 <%=
 	//출력할때 쓰는 것
 %>
</body>
</html>