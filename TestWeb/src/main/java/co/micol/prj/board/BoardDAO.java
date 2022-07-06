package co.micol.prj.board;

import java.util.ArrayList;

import co.micol.prj.comm.DAO;

public class BoardDAO extends DAO{
	
	//조회
	public ArrayList<BoradVO> selectAll(){
		ArrayList<BoradVO> list = new ArrayList <>();
		try {
			getConnect();
			String sql = "select * from board order by rdt desc";
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				BoradVO vo = new BoradVO();
				vo.setId(rs.getString("id"));
				vo.setTilte(rs.getString("title"));
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
	
	//수정
	
	//삭제
	

}
