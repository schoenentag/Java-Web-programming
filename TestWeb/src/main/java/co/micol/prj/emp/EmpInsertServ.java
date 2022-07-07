package co.micol.prj.emp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.prj.dept.DeptDAO;

@WebServlet("/empInsert")
public class EmpInsertServ extends HttpServlet {
	
	//등록페이지로 이동
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//DB조회
		//jobs, 부서, 사원
		//EmpDAO empDAO = new DmpDAO()를 한줄로 쓸 수 있음 ▼
		request.setAttribute("jobs", new EmpDAO().selectJobs());
		DeptDAO deptDAO = new DeptDAO();
		request.setAttribute("depts", deptDAO.selectAll());
		request.getRequestDispatcher("/WEB-INF/jsp/emp/empInsert.jsp").forward(request, response);
		
	}
	//DB등록처리
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//한글처리
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		//파라미터를 vo에 담기(주소값의 파라미터(getParameter) 값을 담기
		//String id = request.getParameter("employeeID");
		//String fName = request.getParameter("firstName");
		String lName = request.getParameter("lastName");
		String eml = request.getParameter("email");
		String ph =  request.getParameter("phone");
		String hDate = request.getParameter("hireDate");
		String jId = request.getParameter("jobId");
		String saly = request.getParameter("salary");
		
		EmpVO vo = new EmpVO(); // 넘겨받은 값을 EMPVO 타입으로 담기
		vo.setEmployeeID(request.getParameter("employeeID"));// 변수만들지 앟ㄴ고 바로 담을 수 있음
		vo.setFirstName(request.getParameter("firstName"));
		vo.setLastName(lName);
		vo.setEmail(eml);
		vo.setPhone(ph);
		vo.setHireDate(hDate);
		vo.setJOB_ID(jId);
		vo.setSalary(saly);
		
		//DB처리
		EmpDAO empDAO = new EmpDAO();
		int cnt = empDAO.insert(vo);
		
		//response.getWriter().append(cnt+"건이 등록됨");
		//request.getRequestDispatcher("EmpListServ").forward(request, response);
		//처리끝나고 다시 list로 넘어가야할때는 sendRedirect 사용
		response.sendRedirect("EmpListServ");
	}
	
}
