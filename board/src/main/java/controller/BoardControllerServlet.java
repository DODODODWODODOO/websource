package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.ActionForward;
import action.BoardDeleteAction;
import action.BoardListAction;
import action.BoardModifyAction;
import action.BoardReadAction;
import action.BoardReplyAction;
import action.BoardSearchAction;
import action.BoardUpdateCountAction;
import action.BoardWriteAction;

@WebServlet("*.do")
@MultipartConfig(maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 50) // 파일 업로드 지원
public class BoardControllerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 한글처리
        req.setCharacterEncoding("utf-8");

        // URI 분리
        String requestUri = req.getRequestURI();
        String contextPath = req.getContextPath();
        String cmd = requestUri.substring(contextPath.length());

        // cmd 를 가지고 액션 생성
        Action action = null;

        if (cmd.equals("/qList.do")) {
            action = new BoardListAction("/view/qna_board_list.jsp");
        } else if (cmd.equals("/qWrite.do")) {
            action = new BoardWriteAction("/qList.do");
        } else if (cmd.equals("/qRead.do")) {
            action = new BoardReadAction("/view/qna_board_view.jsp");
        } else if (cmd.equals("/qModify.do")) {
            action = new BoardReadAction("/view/qna_board_modify.jsp");
        } else if (cmd.equals("/qUpdate.do")) {
            action = new BoardModifyAction("/qRead.do");
        } else if (cmd.equals("/qDelete.do")) {
            action = new BoardDeleteAction("/qList.do");
        } else if (cmd.equals("/qReplyView.do")) {
            action = new BoardReadAction("/view/qna_board_reply.jsp");
        } else if (cmd.equals("/qReply.do")) {
            action = new BoardReplyAction("/qList.do");
        } else if (cmd.equals("/qCount.do")) {
            action = new BoardUpdateCountAction("/qRead.do");
        }
        // else if (cmd.equals("/qSearch.do")) {
        // action = new BoardSearchAction("/view/qna_board_list.jsp");
        // }

        // 생성된 action 에게 일 시키기(서블릿(~pro)이 해야했던 일)
        ActionForward af = null;
        try {
            af = action.execute(req);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 이동방식과 경로에 따라 움직이기
        if (af.isRedirect()) {
            resp.sendRedirect(af.getPath());
        } else {
            RequestDispatcher rd = req.getRequestDispatcher(af.getPath());
            rd.forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
