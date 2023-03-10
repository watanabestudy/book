package chapter04;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tool.Page;

@WebServlet(urlPatterns={"/chapter04/hello5"})
public class Hello5 extends HttpServlet {

	@Override
	public void doGet (
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out=response.getWriter();
		Page.header(out);

		out.println("<p>Congraturations!</p>");
		out.println("<p>おめでとう！</p>");
		out.println("<p>"+new java.util.Date()+"</p>");

		Page.footer(out);
	}
}
