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
import co.micol.prj.member.command.AjaxMemberIdCheck;
import co.micol.prj.member.command.MemberJoin;
import co.micol.prj.member.command.MemberJoinForm;
import co.micol.prj.member.command.MemberList;
import co.micol.prj.member.command.MemberLogin;
import co.micol.prj.member.command.MemberLoginForm;
import co.micol.prj.member.command.MemberLogout;


// Controller : 들어오는 모든 요청을 분석하고, 요청에 맞는 command를 찾아 실행, 결과 보여줄 페이지 선택
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
		map.put("/memberLoginForm.do", new MemberLoginForm()); //로그인 폼 호출
		map.put("/memberLogin.do", new MemberLogin()); //로그인 처리
		map.put("/memberLogout.do", new MemberLogout()); // 로그아웃
		map.put("/memberList.do", new MemberList()); // 회원 목록 보기
		map.put("/memberJoinForm.do", new MemberJoinForm() ); //회원가입 화면
		map.put("/ajaxMemberIdCheck.do", new AjaxMemberIdCheck()); // ajax를 이용한 중복체크
		map.put("/memberJoin.do", new MemberJoin()); //회원가입 처리
	
	}
	
	// 실행 메소드(doGet + doPost) 
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    request.setCharacterEncoding("UTF-8"); // 한글 깨짐 방지
	    
	    String uri = request.getRequestURI(); // 요청된 URI 확인 후 변수에 담음
	    String contextPath = request.getContextPath(); // 요청된 URL로부터 contextPath 확인
	    String page = uri.substring(contextPath.length()); // 실제 요청 페이지를 찾는다
	    
	    Command command = map.get(page); // 실제 수행할 Command를 찾음 Command command = new MainCommand()
	    String viewPage = command.exec(request, response); // 요청 Command를 수행하고 결과를 받음
	    
	    // viewResolve (보여줄 페이지 선택)
	    if(!viewPage.endsWith(".do") && !viewPage.equals(null)) {
	    	if(viewPage.startsWith("ajax:")) { // ajax 처리하는 view resolve
	    		response.setContentType("text/html; charset=UTF-8");
	    		response.getWriter().append(viewPage.substring(5));
	    		return;
	    	}
	    	viewPage = "WEB-INF/views/"+viewPage+".jsp"; // 시스템에서 접근 가능한 폴더를 더해주고
	    	RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
	    	dispatcher.forward(request, response); // 원하는 페이지를 호출해서 전달함 (직전의 request,response 객체 같이 전달-값을 전달할떄 사용)
	    }else {
	    	response.sendRedirect(viewPage); // .do로 권한 위임처리(새로운 request,response 객체를 만듦)
	    }
	}

}
