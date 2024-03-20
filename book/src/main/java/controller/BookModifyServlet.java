package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookDao;
import dto.BookDto;

@WebServlet("/modify")
public class BookModifyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // modify.jsp 넘긴 값 가져오기
        BookDto modifyDto = new BookDto();
        modifyDto.setCode(Integer.parseInt(req.getParameter("code")));
        modifyDto.setPrice(Integer.parseInt(req.getParameter("price")));

        BookDao dao = new BookDao();

        int result = dao.update(modifyDto);

        // 수정 성공시 list
        // 실패시 modify.jsp
        if (result > 0) {
            resp.sendRedirect("/list");
        } else {
            resp.sendRedirect("/view/modify.jsp");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
