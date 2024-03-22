package action;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import dao.BookDao;
import dto.BookDto;
import lombok.AllArgsConstructor;
import service.BookService;
import service.BookServiceImpl;

@AllArgsConstructor
public class BookReadAction implements Action {

    private String path;

    @Override
    public ActionForword execute(HttpServletRequest req) throws Exception {
        // code 가져오기
        String code = req.getParameter("code");

        // 서비스 read()
        BookService service = new BookServiceImpl();
        BookDto dto = service.read(Integer.parseInt(code));

        // request 담기
        req.setAttribute("dto", dto);

        return new ActionForword(path, false);
    }

}
