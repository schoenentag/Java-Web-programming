package co.micol.prj.member.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.micol.prj.comm.DataSource;
import co.micol.prj.member.service.MemberService;
import co.micol.prj.member.vo.MemberVO;

public class MemberServiceImpl implements MemberService {

	private DataSource dao = DataSource.getInstance(); // 싱글톤 객체

	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;

	@Override
	public List<MemberVO> memberSelectList() {
		// 전체 멤버 목록
		List<MemberVO> list = new ArrayList<MemberVO>(); // 1. 결과담을 객체
		MemberVO vo; // 2.사용할 매개변수
		String sql = "SELECT *FROM MEMBER"; // 3. ctrl+shift+x 대문자변환

		try {
			conn = dao.getConnection();
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				vo = new MemberVO(); // vo 초기화
				vo.setMemberID(rs.getString("MEMBER_ID"));
//				vo.setMemberPassword(rs.getString("MEMBER_PASSWORD")); //사실상 pw는 보여주지 않는다.
				vo.setMemberName(rs.getString("MEMBER_NAME"));
				vo.setMemberAuthor("MEMBER_AUTHOR");
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}

	@Override
	public MemberVO memberSelectOne(MemberVO vo) {
		// ※ 매개변수로 vo가 넘어오므로 vo를 만들지 않아도 됨
		// 한명 조회
		String sql = "SELECT * FROM MEMBER WHERE MEMBER_ID = ?";
		try {
			conn = dao.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getMemberID());
			rs = psmt.executeQuery();
			if (rs.next()) {
				// 매개변수인 vo에 담음
				vo.setMemberID(rs.getString("MEMBER_ID"));
				// vo.setMemberPassword(rs.getString("MEMBER_PASSWORD"));
				vo.setMemberName(rs.getString("MEMBER_NAME"));
				vo.setMemberAuthor(rs.getString("MEMBER_AUTHOR"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return vo;
	}

	@Override
	public int memberInsert(MemberVO vo) {
		int n = 0;
		String sql = "INSERT INTO MEMBER (MEMBER_ID, MEMBER_PASSWORD,MEMBER_NAME, MEMBER_AUTHOR)"
				+ " VALUES (?, ?, ?, ?)";
		try {
			conn = dao.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getMemberID());
			psmt.setString(2, vo.getMemberPassword());
			psmt.setString(3, vo.getMemberName());
			psmt.setString(4, vo.getMemberAuthor());
			n = psmt.executeUpdate();
		} catch (SQLException e) {

		} finally {
			close();
		}
		return n;
	}

	@Override
	public int memberUpdate(MemberVO vo) {
		// 회원정보 변경
		int n = 0;
		String sql = "UPDATE MEMBER SET MEMBER_PASSWORD = ? ,  MEMBER_AUTHOR = ? WHERE MEMBER_ID = ?";

		try {
			conn = dao.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getMemberPassword());
			psmt.setString(2, vo.getMemberAuthor());
			psmt.setString(3, vo.getMemberID());
			n = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return n;
	}

	@Override
	public int memberDelete(MemberVO vo) {
		int n = 0;
		String sql = "DELETE FROM MEMBER WHERE MEMBER_ID = ?";
		try {
			conn = dao.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getMemberID());
			n = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return n;
	}

	@Override
	public boolean ismemberIdCheck(String id) {
		// 회원 아이디 중복체크
		boolean b = false;
		String sql = "SELECT MEMBER_ID FROM MEMBER WHERE MEMBER_ID = ? ";
		try {
			conn = dao.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			
			if(!rs.next()) { //존재하지 않으면 true, 존재하면 false
				b = true;
			}
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return b;
	}

	@Override
	public MemberVO memberLogin(MemberVO vo) {
		//회원 로그인
		String sql = "SELECT * FROM MEMBER WHERE MEMBER_ID = ? AND MEMBER_PASSWORD = ?";
		try {
			conn = dao.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getMemberID());
			psmt.setString(2, vo.getMemberPassword());
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				vo.setMemberID(rs.getString("MEMBER_ID"));
				vo.setMemberPassword(rs.getString("MEMBER_PASSWORD"));
				vo.setMemberName(rs.getString("MEMBER_NAME"));
				vo.setMemberAuthor(rs.getString("MEMBER_AUTHOR"));
				
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return vo;
	}

	private void close() {
		try {
			if (rs != null)
				rs.close();
			if (psmt != null)
				psmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} // close()끝
}
