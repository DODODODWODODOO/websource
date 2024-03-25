package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dto.MemberDto;
import lombok.AllArgsConstructor;
import service.BookService;
import service.BookServiceImpl;

@AllArgsConstructor
public class BookRegisterAction implements Action {

    private String path;

    @Override
    public ActionForword execute(HttpServletRequest req) throws Exception {

        // register.jsp 넘긴 값 가져오기
        MemberDto regDto = new MemberDto();
        regDto.setUserid(req.getParameter("userid"));
        regDto.setPassword(req.getParameter("password"));
        regDto.setName(req.getParameter("name"));
        regDto.setEmail(req.getParameter("email"));

        // 서비스 호출
        BookService service = new BookServiceImpl();

        // 결과에 따라 성공 시 login.jsp, 실패 시 register.jsp
        if (!service.register(regDto)) {
            path = "/view/register.jsp";
        }

        return new ActionForword(path, false);
    }

}
