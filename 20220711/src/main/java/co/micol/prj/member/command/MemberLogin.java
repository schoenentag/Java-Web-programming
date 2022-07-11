package co.micol.prj.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.micol.prj.comm.Command;
import co.micol.prj.member.service.MemberService;
import co.micol.prj.member.serviceImpl.MemberServiceImpl;
import co.micol.prj.member.vo.MemberVO;

public class MemberLogin implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 로그인 처리
		HttpSession session = request.getSession(); //서버가 만들어 놓은 세션을 가져옴(최초 한번)
		
		MemberService memberDao = new MemberServiceImpl();
		MemberVO vo = new MemberVO(); //사용할 인스턴스 생성
		vo.setMemberID(request.getParameter("memberId")); //MemberLoginForm.jsp <input name>의 값
		vo.setMemberPassword(request.getParameter("memberPassWord"));
		
		vo = memberDao.memberLogin(vo); 
		if(vo.getMemberName() != null) { // getMemberName이 있으면
			//session에 아이디, 이름, 권한, 메세지 담기(전역적)
			session.setAttribute("id", vo.getMemberID()); 
			session.setAttribute("name", vo.getMemberName());
			session.setAttribute("author", vo.getMemberAuthor()); //세션에 권한담기 //담을 때는 session
			request.setAttribute("message", vo.getMemberName()+"님 환영합니다!"); //결과를 보낼 때는 request
		}else {
			request.setAttribute("message", "아이디 또는 패스워드가 일치하지 않습니다.");
		}
		return "member/memberLogin";
		
	}

}
