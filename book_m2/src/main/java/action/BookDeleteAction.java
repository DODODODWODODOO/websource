package action;

import javax.servlet.http.HttpServletRequest;

import dao.BookDao;
import lombok.AllArgsConstructor;
import service.BookService;
import service.BookServiceImpl;

@AllArgsConstructor
public class BookDeleteAction implements Action {

    private String path;

    @Override
    public ActionForword execute(HttpServletRequest req) throws Exception {
        // 도서코드 가져오기
        int code = Integer.parseInt(req.getParameter("code"));

        // 서비스 작업
        BookService service = new BookServiceImpl();
        boolean result = service.delete(code);

        if (!result) {
            path = "/view/delete.jsp";
        }
        // list.do
        return new ActionForword(path, true);
    }

}
