package co.micol.prj.dept;

import java.util.ArrayList;

import co.micol.prj.comm.DAO;

public class DeptDAO extends DAO {
	// 조회
	public ArrayList<DeptVO> selectAll() {
		ArrayList<DeptVO> list = new ArrayList<DeptVO>();
		try {
			getConnect();
			String sql = "select * from departments";
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				DeptVO vo = new DeptVO();
				vo.setDepartmentId(rs.getString("department_id"));
				vo.setDepartmentName(rs.getString("department_name"));
				list.add(vo);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			disconnect();
		}
	return list;	
	}

	// 단건조회
		public DeptVO selectOne(String department_id) {
			DeptVO vo = new DeptVO();
			try {
				getConnect();
				String sql = "select * from departments where department_id =? ";
				psmt = conn.prepareStatement(sql);
				psmt.setString(1,department_id);
				rs = psmt.executeQuery();
				if(rs.next()) {
					vo.setDepartmentId(rs.getString("department_id"));
					vo.setDepartmentName(rs.getString("department_name"));
				}
				
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				disconnect();
			}
		return vo;	
		}
	
	

	// 등록
	public int deptInsert(DeptVO vo) {// 등록된 건수만 반환
		int cnt = 0; // return값 반환할 변수
		try {
			getConnect(); //DB연결
			//sql구문 실행할 메소드
			String sql = "insert into departments(department_id, department_name) values (?,?)";
			psmt = conn.prepareStatement(sql); 
			psmt.setString(1, vo.getDepartmentId()); // ?에 값 담기
			psmt.setString(2, vo.getDepartmentName());
			cnt = psmt.executeUpdate(); // 구문 등록 
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconnect(); //DB끊기
		}
		return cnt;
	}

	// 수정
	public int update(DeptVO vo) {
		int r = 0;
		
		try {
			getConnect();//DB연결
			
			String sql = "update departments set department_name = ? where department_id =?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getDepartmentName()); 
			psmt.setString(2, vo.getDepartmentId());
			r = psmt.executeUpdate();
		
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return r;
	}

	// 삭제
//	public int delete(String departmentId) {
//		
//	}

}
