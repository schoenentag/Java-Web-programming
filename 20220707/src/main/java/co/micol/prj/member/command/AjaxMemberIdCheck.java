package co.micol.prj.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.prj.comm.Command;
import co.micol.prj.member.service.MemberService;
import co.micol.prj.member.serviceImpl.MemberServiceImpl;

public class AjaxMemberIdCheck implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		//ajax를 이용한 아이디 중복체크
		MemberService memberDao = new MemberServiceImpl();
		//boolean b = false;
		String id = request.getParameter("id"); //ajax에서 넘어온 id값을 String값으로 받ㄷ는다.
	
		boolean b = memberDao.ismemberIdCheck(id); // true가 사용가능...
		String result = "Used";
		if(!b) {//false면...
			result = "Un Used";
		} 
		return "ajax:"+result; //결과가 ajax호출이라는 걸 view resolve에게 알려주기위해
	}

}
