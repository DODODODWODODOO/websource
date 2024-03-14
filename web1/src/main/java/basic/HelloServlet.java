package basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// HttpServletRequest : 사용자의 요청을 가져오는 객체
// HttpServletResponse : 사용자에게 응답할 때 사용하는 객체

@WebServlet("/hello") // Servlet 별칭
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        // post 방식의 한글은 깨짐
        // 가져오는 모든 데이터는 String 임
        // req.getParameter("form 요소명")

        // post 방식으로 넘어오는 한글 인코딩 처리
        // getParameter 전에 작성
        req.setCharacterEncoding("utf-8");

        String id = req.getParameter("id");
        String name = req.getParameter("name");
        // value 가 여러개인 checkbox 값 가져오기
        String[] dogs = req.getParameterValues("dog");

        // 응답할 페이지 설정
        res.setContentType("text/html;charset=utf-8");
        PrintWriter out = res.getWriter();
        out.print("<ul>");
        out.print("<li>id : " + id + "</li>");
        out.print("<li>name : " + name + "</li>");
        for (String dog : dogs) {
            out.print("<li>dog : " + dog + "</li>");
        }
        out.print("</ul>");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
