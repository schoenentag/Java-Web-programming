package co.micol.prj.board;

import java.util.ArrayList;

import co.micol.prj.comm.DAO;

public class BoardDAO extends DAO{
	
	//조회
	public ArrayList<BoardVO> selectAll(){
		ArrayList<BoardVO> list = new ArrayList <>();
		try {
			getConnect();
			String sql = "select * from board order by id desc";
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				BoardVO vo = new BoardVO();
				vo.setId(rs.getString("id"));
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				vo.setWriter(rs.getString("writer"));
				vo.setRdt(rs.getString("rdt"));
				vo.setHit(rs.getString("hit"));
				list.add(vo);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return list;
	}
	
	//단건 조회
	
	//등록
	
	public int boardInsert(BoardVO vo) {
		int cnt = 0;
		try {
			getConnect();
			String sql = "insert into board(id, title, content, writer, rdt, hit)"
					+ " values((select max(id)+1 from board), ?, ?, ?, ?, ?)";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1,vo.getTitle() );
			psmt.setString(2, vo.getContent());
			psmt.setString(3, vo.getWriter());
			psmt.setString(4, vo.getRdt());
			psmt.setString(5, vo.getHit());
			cnt = psmt.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			disconnect();
		}
		
		return cnt;
	}

	
	//수정
	
	//삭제
	

}
