package action;

import javax.servlet.http.HttpServletRequest;

import dao.BookDao;
import dto.BookDto;
import service.BookService;
import service.BookServiceImpl;

public class BookCreateAction implements Action {

    private String path;

    public BookCreateAction(String path) {
        this.path = path;
    }

    @Override
    public ActionForword execute(HttpServletRequest req) throws Exception {
        // 도서추가 화면에서 넘어오는 데이터 가져오기
        req.setCharacterEncoding("utf-8");

        int code = Integer.parseInt(req.getParameter("code"));
        String title = req.getParameter("title");
        String writer = req.getParameter("writer");
        int price = Integer.parseInt(req.getParameter("price"));
        String decription = req.getParameter("decription");

        BookDto dto = new BookDto(code, title, writer, price, decription);

        // 서비스 호출 create
        BookService service = new BookServiceImpl();
        boolean result = service.create(dto);

        // 리스트로 이동

        return new ActionForword(path, true);
    }

}
