package co.micol.prj;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/hello", loadOnStartup = 1)
public class HelloWorld extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    @Override
	public void destroy() {
    	System.out.println("제거됨");
	}

	@Override
	public void init(ServletConfig config) throws ServletException { // 서버가 실행될때 최초로 생성됨
		System.out.println("생성됨");
	}

	//doGet+doPost =service
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("서비스 실행");
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}