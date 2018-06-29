package test.friends.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.friends.dao.FriendsDao;
import test.friends.dto.FriendsDto;

@WebServlet("/Friends/insert")
public class FriendsInsertServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//post 방식으로 전송되었을때 한글 깨지지 않도록
		request.setCharacterEncoding("utf-8");
		//전송된 파라미터 추출
		String name= request.getParameter("name");
		String phone=request.getParameter("phone");
		
		//저장할 회원정보를 FriendsDto 에 담아서
		FriendsDto dto=new FriendsDto();
		dto.setName(name);
		dto.setPhone(phone);
		//FriendsDao 객체를 이용해서 DB에 저장
		FriendsDao dao = FriendsDao.getInstance();
		dao.insert(dto);
		//클라이언트에게 응답하기
		//응답 인코딩 설정
		response.setCharacterEncoding("utf-8");
		//응답 컨텐츠 설정
		response.setContentType("text/html;charset=utf-8");
		//클라이언트에게 응답할수 있는 객체의 참조값 얻어오기
		PrintWriter pw = response.getWriter();
		//html 형식으로 응답하기 
		pw.println("<!doctype html>");
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<meta charset='utf-8'/>");
		pw.println("<title>친구 정보 추가 결과 페이지</title>");
		pw.println("</head>");
		pw.println("<body>");
		pw.println("<p>친구 정보를 추가 했습니다.</p>");
		pw.println("<a href='list'>목록보기</a>");
		pw.println("</body>");
		pw.println("</html>");
		pw.close();
	}
}
