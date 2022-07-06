package co.micol.prj.emp;

import java.sql.SQLException;
import java.util.ArrayList;

import co.micol.prj.comm.DAO;

public class EmpDAO extends DAO {
	//JOBs 전체 조회(FK키) -> empInsert에서 select option에 넣어줄것
	public ArrayList<JobsVO> selectJobs(){
		ArrayList<JobsVO> jlist = new ArrayList<JobsVO>();
		
		try {
			getConnect(); //DB연결
			String sql = "select * from jobs order by job_id";
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				JobsVO vo = new JobsVO();
				vo.setJobId(rs.getString("job_id")); //테이블의 컬럼명
				vo.setJobTitle(rs.getString("job_title"));
				jlist.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		
		return jlist;
	}
	
	
	// 전체 조회
	public ArrayList<EmpVO> selectAll(String departmentId) {
		ArrayList<EmpVO> list = new ArrayList<EmpVO>();
		try {
			// 1.연결
			getConnect();
			// 2.sql 구문 준비
			String sql = "select * from employees";
			
			if(departmentId != null && ! departmentId.isEmpty()) {
				sql += " where department_id = ?";
			}
			sql += " order by employee_id ";
			psmt = conn.prepareStatement(sql);
			if (departmentId != null && ! departmentId.isEmpty()) {
				psmt.setString(1, departmentId);
				
			}
			// 실행
			rs = psmt.executeQuery();
			// 조회결과 list에 담기
			while(rs.next()) {
				EmpVO vo = new EmpVO();
				vo.setEmployeeID(rs.getString("EMPLOYEE_ID"));
				vo.setFirstName(rs.getString("FIRST_NAME"));
				vo.setLastName(rs.getString("LAST_NAME"));
				vo.setEmail(rs.getString("EMAIL"));
				vo.setPhone(rs.getString("PHONE_NUMBER"));
				vo.setHireDate(rs.getString("HIRE_DATE"));
				vo.setJOB_ID(rs.getString("JOB_ID"));
				vo.setSalary(rs.getString("SALARY"));
				vo.setDepartmentsId(rs.getString("DEPARTMENT_ID"));
				list.add(vo);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			// 4.연결해제
			disconnect();
		}
		return list;
	}
	
	// 단건 조회
	public EmpVO selectOne(String employeeId) {
		EmpVO vo = new EmpVO();
		try {
			getConnect();
			String sql = "select * from employees where employee_id = ?";
			
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, employeeId);
			rs = psmt.executeQuery();
			if(rs.next()) {
				vo.setEmployeeID(rs.getString("EMPLOYEE_ID"));
				vo.setFirstName(rs.getString("FIRST_NAME"));
				vo.setLastName(rs.getString("LAST_NAME"));
				vo.setEmail(rs.getString("EMAIL"));
				vo.setPhone(rs.getString("PHONE_NUMBER"));
				vo.setHireDate(rs.getString("HIRE_DATE"));
				vo.setJOB_ID(rs.getString("JOB_ID"));
				vo.setSalary(rs.getString("SALARY"));
				vo.setDepartmentsId(rs.getString("DEPARTMENT_ID"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return vo;
	}
	
	// 등록
	public int insert(EmpVO vo) {
		int cnt = 0;
		try {
			//1.DB연결
			getConnect();
			//2.sql 구문 준비
			String sql = "insert into employees(EMPLOYEE_ID,FIRST_NAME,LAST_NAME,EMAIL,PHONE_NUMBER,HIRE_DATE,JOB_ID,salary)"
					+ " values((select max(EMPLOYEE_ID)+1 from employees),"
					+ " ?,?,?,?,?,?,?)";
			psmt = conn.prepareStatement(sql); 
			psmt.setString(1, vo.getFirstName());
			psmt.setString(2, vo.getLastName());
			psmt.setString(3, vo.getEmail());
			psmt.setString(4, vo.getPhone());
			psmt.setString(5, vo.getHireDate());
			psmt.setString(6, vo.getJOB_ID());
			psmt.setString(7, vo.getSalary());
			
			cnt = psmt.executeUpdate(); // cnt에 등록
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();//연결끊기
		}
		return cnt;
	}
	// 수정
	public int update(EmpVO vo) {
		int r = 0;
		try {
			getConnect();
			String sql = "update employees set FIRST_NAME = ? where EMPLOYEE_ID =?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getFirstName());
			psmt.setString(2, vo.getEmployeeID());
			r = psmt.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			disconnect();
		}
		
		return r;
	}
	
	// 삭제
	
	public int empDelete(String employeeID) {
		int cnt = 0;
		try {
			getConnect();
			String sql = "delete employees  where EMPLOYEE_ID =? ";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, employeeID);
			cnt = psmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return cnt;
	}

}
