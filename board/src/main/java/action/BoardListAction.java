package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import dto.BoardDto;
import lombok.AllArgsConstructor;
import service.BoardService;
import service.BoardServiceImpl;

@AllArgsConstructor
public class BoardListAction implements Action {

    private String path;

    @Override
    public ActionForward execute(HttpServletRequest req) throws Exception {

        // BoardService list 호출
        BoardService service = new BoardServiceImpl();
        List<BoardDto> list = service.list();

        // req 결과 담기
        req.setAttribute("list", list);

        return new ActionForward(path, false);
    }

}
