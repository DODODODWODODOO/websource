package action;

import javax.servlet.http.HttpServletRequest;

import dto.BoardDto;
import dto.SearchDto;
import lombok.AllArgsConstructor;
import service.BoardService;
import service.BoardServiceImpl;

@AllArgsConstructor
public class BoardReadAction implements Action {

    private String path;

    @Override
    public ActionForward execute(HttpServletRequest req) throws Exception {

        int bno = Integer.parseInt(req.getParameter("bno"));
        // 페이지 나누기 개념 추가 후
        int page = Integer.parseInt(req.getParameter("page"));
        int amount = Integer.parseInt(req.getParameter("amount"));
        String criteria = req.getParameter("criteria");
        String keyword = req.getParameter("keyword");

        SearchDto searchDto = new SearchDto(page, amount, criteria, keyword);

        // BoardService호출
        BoardService service = new BoardServiceImpl();

        BoardDto dto = service.read(bno);

        // req 결과 담기
        req.setAttribute("dto", dto);
        req.setAttribute("searchDto", searchDto);

        return new ActionForward(path, false);
    }

}
