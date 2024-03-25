package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dto.MemberDto;
import lombok.AllArgsConstructor;
import service.BookService;
import service.BookServiceImpl;

@AllArgsConstructor
public class BookLoginAction implements Action {

    private String path;

    @Override
    public ActionForword execute(HttpServletRequest req) throws Exception {
        req.setCharacterEncoding("utf-8");
        // userid, password 가져오기
        MemberDto dto = new MemberDto();
        dto.setUserid(req.getParameter("userid"));
        dto.setPassword(req.getParameter("password"));

        // 서비스 호출
        BookService service = new BookServiceImpl();
        MemberDto loginDto = service.login(dto);

        // true 로 결과를 받았다면 받은 정보를 session 저장
        if (loginDto != null) {
            HttpSession session = req.getSession();
            session.setAttribute("loginDto", loginDto);
        } else {
            path = "/view/login.jsp";
        }
        // sendRedirect, book 목록으로 이동

        return new ActionForword(path, false);
    }

}
