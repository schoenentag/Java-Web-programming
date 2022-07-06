package co.micol.prj.emp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.prj.dept.DeptDAO;

@WebServlet("/EmpUpdateServ")
public class EmpUpdateServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// 수정 페이지 이동 요청
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//DB조회
		//jobs, 부서,사원
		EmpDAO empDAO = new EmpDAO();
		DeptDAO deptDAO = new DeptDAO();
		request.setAttribute("jobs", empDAO.selectJobs());
		request.setAttribute("depts", deptDAO.selectAll());

		
		//사번 단건 조회
		String employeeID = request.getParameter("employeeID");
		request.setAttribute("emp", empDAO.selectOne(employeeID));
		
		request.getRequestDispatcher("/WEB-INF/jsp/emp/empUpdate2.jsp").forward(request, response);
	}

	// 수정페이지처리
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");

		// 파라미터를 vo에 담기(주소값의 파라미터(getParameter) 값을 담기
		String id = request.getParameter("employeeID");
		String fName = request.getParameter("firstName");
		String lName = request.getParameter("lastName");
		String eml = request.getParameter("email");
		String ph = request.getParameter("phone");
		String hDate = request.getParameter("hireDate");
		String jId = request.getParameter("jobId");
		String saly = request.getParameter("salary");

		EmpVO vo = new EmpVO(); // 넘겨받은 값을 EMPVO 타입으로 담기
		vo.setEmployeeID(id);
		vo.setFirstName(fName);
		vo.setLastName(lName);
		vo.setEmail(eml);
		vo.setPhone(ph);
		vo.setHireDate(hDate);
		vo.setJOB_ID(jId);
		vo.setSalary(saly);

		EmpDAO empDAO = new EmpDAO();
		int cnt = empDAO.update(vo);

		response.getWriter().append(cnt + "건이 등록됨");

	}

}
