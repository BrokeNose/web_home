package test.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Mile extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//요청 파라미터 추출하기
		String kilo=request.getParameter("kilo");
		System.out.println("Distance calculation : "+kilo);
		
		
		double mile;
		double km = Integer.parseInt(kilo);
		double outKm;
		mile = 1.609;
		
	}
}
