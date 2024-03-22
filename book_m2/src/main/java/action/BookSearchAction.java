package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import dto.BookDto;
import lombok.AllArgsConstructor;
import service.BookService;
import service.BookServiceImpl;

@AllArgsConstructor
public class BookSearchAction implements Action {

    private String path;

    @Override
    public ActionForword execute(HttpServletRequest req) throws Exception {

        req.setCharacterEncoding("utf-8");

        // 검색기준(criteria)과 검색어(keyword) 가져오기
        String criteria = req.getParameter("criteria");
        String keyword = req.getParameter("keyword");

        BookService service = new BookServiceImpl();
        List<BookDto> list = service.searchListAll(criteria, keyword);

        req.setAttribute("list", list);

        return new ActionForword(path, false);
    }

}
