package co.micol.prj.comm;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
// frontcontroller패턴 command 패턴

public interface Command {
    // controller(Servlet+ interface command)
	// ※ 요청(request)이 들어오면 컨테이너에서 자동으로 request,response,session 객체 생성 <-> 통신
	// 매개변수로 request, response 전달받아서 수행
	// Command 인터페이스를 통해 서버가 각각의 요청을 처리할 수 있는 command Servlet 생성(mapping)
	public String exec(HttpServletRequest request, HttpServletResponse response);
	

}
