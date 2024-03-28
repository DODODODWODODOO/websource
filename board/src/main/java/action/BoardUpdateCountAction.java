package action;

import javax.servlet.http.HttpServletRequest;

import lombok.AllArgsConstructor;
import service.BoardService;
import service.BoardServiceImpl;

@AllArgsConstructor
public class BoardUpdateCountAction implements Action {

    private String path;

    @Override
    public ActionForward execute(HttpServletRequest req) throws Exception {

        int bno = Integer.parseInt(req.getParameter("bno"));

        // BoardService호출
        BoardService service = new BoardServiceImpl();

        // 조회수 업데이트
        service.updateCount(bno);

        path += "?bno=" + bno;
        return new ActionForward(path, true);
    }

}
