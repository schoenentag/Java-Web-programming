package co.micol.prj.emp;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EmpUpdateServ")
public class EmpUpdateServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//수정 페이지 이동 요청
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String employeeID = request.getParameter("employeeID");
		
		EmpDAO empDAO = new EmpDAO();
		request.setAttribute("emp", empDAO.selectOne(employeeID));
		
		request.getRequestDispatcher("/WEB-INF/jsp/emp/empUpdate.jsp").forward(request, response);
	}
	//수정페이지처리
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("employeeID");
		String fName = request.getParameter("firstName");
		
		EmpVO vo = new EmpVO();
		vo.setEmployeeID(id);
		vo.setFirstName(fName);
		
		EmpDAO empDAO = new EmpDAO();
		int cnt = empDAO.update(vo);
		
		response.getWriter().append(cnt +"건이 등록됨");
	
	}

}
