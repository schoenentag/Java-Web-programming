package co.micol.prj.member.service;

import java.util.List;

import co.micol.prj.member.vo.MemberVO;

public interface MemberService {
	//CRUD 구조
	
	//전체 Member를 가지고 오는 MemberVO타입
	List<MemberVO> memberSelectList(); // 멤버 전체 조회 (READ)
	MemberVO memberSelectOne(MemberVO vo); // 멤버 조회 (READ)
	
	int memberInsert(MemberVO vo); // 멤버 등록(CREATE)
	int memberUpdate(MemberVO vo); // 멤버 수정(UPDATE)
	int memberDelete(MemberVO vo); // 멤버 삭제(DELETE)
	
	boolean ismemberIdCheck(String id); // 아이디 중복체크 (변수명에 is를 주로 사용... default value = false, 아이디가 존재하면 false -> 그래서 있는 아이디는 사용하지 못함)
	MemberVO memberLogin(MemberVO vo); // 로그인 처리 (READ)

}
