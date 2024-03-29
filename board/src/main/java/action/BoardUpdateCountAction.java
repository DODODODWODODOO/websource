package action;

import java.net.URLEncoder;

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
        // 페이지 나누기 개념 추가 후
        String page = req.getParameter("page");
        String amount = req.getParameter("amount");
        String criteria = req.getParameter("criteria");
        // 한글일 경우 get 넘어올때 깨짐 => 인코딩
        // 인코딩 할 문자, 인코딩할유니코드
        String keyword = URLEncoder.encode(req.getParameter("keyword"), "utf-8");

        // BoardService호출
        BoardService service = new BoardServiceImpl();

        // 조회수 업데이트
        service.updateCount(bno);

        path += "?bno=" + bno + "&page=" + page + "&amount=" + amount + "&criteria=" + criteria + "&keyword=" + keyword;
        return new ActionForward(path, true);
    }

}
