package chapter18;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns={"/chapter18/remove"})
public class Remove extends HttpServlet {
	@Override
	public void doGet (
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {
		Cookie[] cookies=request.getCookies();
		if (cookies!=null) {
			for (Cookie cookie : cookies) {
				cookie.setMaxAge(0);
				response.addCookie(cookie);
			}
		}
	}
}
