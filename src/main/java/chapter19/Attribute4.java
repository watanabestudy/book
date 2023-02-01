package chapter19;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tool.Page;

@WebServlet(urlPatterns={"/chapter19/attribute4"})
public class Attribute4 extends HttpServlet {

	@Override
	public void init() throws ServletException {
		try {
			ServletContext context=getServletContext();
			String path=context.getRealPath("WEB-INF/setting.txt");
			FileInputStream in=new FileInputStream(path);
			Properties p=new Properties();
			p.load(in);
			in.close();
			for (String name : p.stringPropertyNames()) {
				context.setAttribute(name, p.getProperty(name));
			}
		} catch (IOException e) {
			throw new ServletException(
				"ファイルの読み込みに失敗しました。");
		}
	}

	@Override
	public void doGet (
	HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		Page.header(out);
		out.println("アプリケーション属性を設定しました。");
		Page.footer(out);
	}
}
