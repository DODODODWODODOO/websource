package action;

import javax.servlet.http.HttpServletRequest;

import dto.BoardDto;
import lombok.AllArgsConstructor;
import service.BoardService;
import service.BoardServiceImpl;

@AllArgsConstructor
public class BoardReplyAction implements Action {

    private String path;

    @Override
    public ActionForward execute(HttpServletRequest req) throws Exception {

        String name = req.getParameter("name");
        String title = req.getParameter("title");
        String content = req.getParameter("content");
        String password = req.getParameter("password");
        // 부모정보
        int bno = Integer.parseInt(req.getParameter("bno"));
        int reRef = Integer.parseInt(req.getParameter("reRef"));
        int reSeq = Integer.parseInt(req.getParameter("reSeq"));
        int reLev = Integer.parseInt(req.getParameter("reLev"));

        BoardDto replyDto = new BoardDto();
        replyDto.setName(name);
        replyDto.setTitle(title);
        replyDto.setContent(content);
        replyDto.setPassword(password);
        replyDto.setReRef(reRef);
        replyDto.setReSeq(reSeq);
        replyDto.setReLev(reLev);

        // BoardService호출
        // 성공시 리스트 보여주기
        BoardService service = new BoardServiceImpl();
        if (!service.reply(replyDto)) {
            // 실패시 댓글화면 보여주기
            path = "/qReplyView.do?bno=" + bno;
        }

        return new ActionForward(path, false);
    }

}
