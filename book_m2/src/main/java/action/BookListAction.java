package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import dto.BookDto;
import service.BookService;
import service.BookServiceImpl;

public class BookListAction implements Action {

    private String path;

    public BookListAction(String path) {
        this.path = path;
    }

    @Override
    public ActionForword execute(HttpServletRequest req) throws Exception {

        // service listAll() 호출
        BookService service = new BookServiceImpl();
        List<BookDto> list = service.listAll();
        // 결과 request 에 담기
        req.setAttribute("list", list);

        return new ActionForword(path, false);
    }

}
