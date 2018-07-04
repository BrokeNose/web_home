package test.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/sessionScope/showinfo")
public class ShowInfoServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//세션 영역 ( session scope ) 에 정보 담기
		HttpSession session = request.getSession();
		// .setAttribute("키", value)
		// "myName" 이라는 키값으로 String type 담기
		session.setAttribute("myName", "미스터 손");
		
		String cPath=request.getContextPath();
		// 리다일렉트 이동하라고 응답하기
		response.sendRedirect(cPath+"/path2/result.jsp");
	}
}

//세션에다가 담는 것은 표식내용이고  세션에 담아놓으면 응답할때  웹브라우저에 심어놓는다.
