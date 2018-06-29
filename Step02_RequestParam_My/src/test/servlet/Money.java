package test.servlet;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/money")
public class Money extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//요청파라미터 추출하기
		String money=request.getParameter("won");
		System.out.println("exchange Rate:"+money);
		double exchange; //환율 저장
		int inWon; //입력받은 원화 저장
		double outWon;//계산된 달러값 저장
		
		exchange=1392.83;
		inWon=Integer.parseInt(money);
		
		outWon = inWon/exchange;
		//응답
		PrintWriter pw = response.getWriter();
		pw.println("입력하신 원화를 달러로 환산하면 "+outWon+"입니다." );
		pw.close();
	}
	
}
