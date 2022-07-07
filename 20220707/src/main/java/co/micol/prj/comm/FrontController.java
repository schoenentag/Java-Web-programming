package co.micol.prj.comm;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.prj.MainCommand;

@WebServlet("*.do") // 모든 .do 요청을 처리
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HashMap<String,Command> map = new HashMap<>(); // HashMap<요청값, Command> 생성(요청과 실행문 매핑)
       
    public FrontController() {
        super();
    }
    // 초기화 메소드 (최초실행한번) - Mapping 하는 부분 (request 1:1 command)
	public void init(ServletConfig config) throws ServletException {
		map.put("/main.do", new MainCommand()); // 처음 접속하는 페이지
	}
	
	// 실행 메소드(doGet + doPost) 
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    request.setCharacterEncoding("UTF-8"); // 한글 깨짐 방지
	    
	    String uri = request.getRequestURI(); // 요청된 URI 확인 후 변수에 담음
	    String contextPath = request.getContextPath(); // 요청된 URL로부터 contextPath 확인
	    String page = uri.substring(contextPath.length()); // 실제 요청 페이지를 찾는다
	    
	    Command command = map.get(page); // 실제 수행할 Command를 찾음 new MainCommand()
	    String viewPage = command.exec(request, response); // 요청 Command를 수행하고 결과를 받음
	    
	    // viewResolve
	    if(!viewPage.endsWith(".do") && !viewPage.equals(null)) {
	    	viewPage = "WEB-INF/views/"+viewPage+".jsp"; // 시스템에서 접근 가능한 폴더를 더해주고
	    	RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
	    	dispatcher.forward(request, response); // 원하는 페이지를 호출해서 전달함 (직전의 request,response 객체 같이 전달-값을 전달할떄 사용)
	    }else {
	    	response.sendRedirect(viewPage); // .do로 권한 위임처리(새로운 request,response 객체를 만듦)
	    }
	}

}
