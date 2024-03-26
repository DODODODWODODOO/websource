package action;

import javax.servlet.http.HttpServletRequest;

import dto.BookDto;
import lombok.AllArgsConstructor;
import service.BookService;
import service.BookServiceImpl;

@AllArgsConstructor
public class BookUpdateAction implements Action {

    private String path;

    @Override
    public ActionForword execute(HttpServletRequest req) throws Exception {

        // modify.jsp 넘긴 값 가져오기
        BookDto modifyDto = new BookDto();
        modifyDto.setCode(Integer.parseInt(req.getParameter("code")));
        modifyDto.setPrice(Integer.parseInt(req.getParameter("price")));

        // 서비스 update
        BookService service = new BookServiceImpl();
        boolean result = service.update(modifyDto);

        if (result) {
            // 수정 내용 보여주기 read.do
            path += "?code=" + modifyDto.getCode();

        } else {
            path = "/view/modify.jsp";
        }
        return new ActionForword(path, true);
    }

}
