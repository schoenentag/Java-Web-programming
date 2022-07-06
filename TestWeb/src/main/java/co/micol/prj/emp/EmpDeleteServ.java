package co.micol.prj.emp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.prj.dept.DeptDAO;

@WebServlet("/EmpDeleteServ")
public class EmpDeleteServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// 수정 페이지 이동 요청
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		//파라미터
		String employeeID = request.getParameter("employeeID");
		EmpDAO empDAO = new EmpDAO();
		
		int cnt = empDAO.empDelete(employeeID);

	    response.getWriter()
	            .append("<script>")
	            .append("alert('"+cnt+"건 삭제완료');")
	            .append("location.href='EmpListServ';")
	            .append("</script>");
		//request.setAttribute("msg", cnt + "건이 삭제됨");
		//request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
	}

}
