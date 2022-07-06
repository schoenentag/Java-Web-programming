package co.micol.prj.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.SendResult;

@WebServlet("/boardInsert")
public class BoardInsertServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/jsp/board/boardInsert.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("id");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String writer = request.getParameter("writer");
		String rdt = request.getParameter("rdt");
		
		BoardVO vo = new BoardVO();
		vo.setId(id);
		vo.setTitle(title);
		vo.setContent(content);
		vo.setWriter(writer);
		vo.setRdt(rdt);
		
		BoardDAO boardDAO = new BoardDAO();
		int cnt = boardDAO.boardInsert(vo);
		response.sendRedirect("boardList");
		System.out.println(cnt+"건 등록완료"); //요건 뜸...
		
		//화면에 등록완료 띄운 후 list로 돌아가도록 처리 (안뜨고있음...)
		response.getWriter()
		        .append("<script>")
                .append("alert('"+cnt+"건 삭제완료');")
		        .append("location.href='boardList';")
		        .append("</script>");
		
	}

}
