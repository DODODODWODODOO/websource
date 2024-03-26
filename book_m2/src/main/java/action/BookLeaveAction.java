package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dto.MemberDto;
import lombok.AllArgsConstructor;
import service.BookService;
import service.BookServiceImpl;

@AllArgsConstructor
public class BookLeaveAction implements Action {

    private String path;

    @Override
    public ActionForword execute(HttpServletRequest req) throws Exception {

        MemberDto delDto = new MemberDto();
        delDto.setUserid(req.getParameter("userid"));
        delDto.setPassword(req.getParameter("password"));

        BookService service = new BookServiceImpl();
        if (!service.leave(delDto)) {
            // 탈퇴 시 기존 세션 제거
            HttpSession session = req.getSession();
            session.invalidate();
        } else {
            path = "/view/leave.jsp";
        }

        return new ActionForword(path, false);
    }

}
