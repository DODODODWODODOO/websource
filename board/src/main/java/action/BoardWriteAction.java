package action;

import java.io.File;
import java.net.URLEncoder;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import dto.BoardDto;
import lombok.AllArgsConstructor;
import service.BoardService;
import service.BoardServiceImpl;

@AllArgsConstructor
public class BoardWriteAction implements Action {

    private String path;

    @Override
    public ActionForward execute(HttpServletRequest req) throws Exception {

        // qna_board_write.jsp 넘긴 값 가져오기
        BoardDto insertDto = new BoardDto();
        insertDto.setName(req.getParameter("name"));
        insertDto.setTitle(req.getParameter("title"));
        insertDto.setContent(req.getParameter("content"));
        insertDto.setPassword(req.getParameter("password"));

        // 페이지 나누기 개념 추가 후
        String page = req.getParameter("page");
        String amount = req.getParameter("amount");
        String criteria = req.getParameter("criteria");
        String keyword = URLEncoder.encode(req.getParameter("keyword"), "utf-8");

        // 업로드 처리
        Part part = req.getPart("attach");
        String fileName = getFileName(part);

        String saveDir = "C:\\upload";

        if (!fileName.isEmpty()) {

            // 중복 파일명은 저장을 해주지 않음 => 서버에 저장 시 다른 이름을 사용
            // 고유한 값 생성 => 고유한값_사용자가 올린 파일명
            UUID uuid = UUID.randomUUID();
            File uploadFile = new File(saveDir + File.separator + uuid + "_" + fileName);

            // c:\\upload\\올라온 파일명.jpg
            part.write(uploadFile.toString()); // 서버에 디스크에 파일 저장
            insertDto.setAttach(uploadFile.getName());

        }

        System.out.println(insertDto);

        // 서비스 호출
        BoardService service = new BoardServiceImpl();

        // true : 목록, false : qna_board_write.jsp
        if (!service.insert(insertDto)) {
            path = "/view/qna_board_write.jsp?page=" + page + "&amount=" + amount
                    + "&criteria=" + criteria + "&keyword=" + keyword;

        } else {
            // /qList.do
            path += "?page=" + page + "&amount=" + amount + "&criteria=" + criteria
                    + "&keyword=" + keyword;
        }

        return new ActionForward(path, true);
    }

    private String getFileName(Part part) {
        // Content-Disposition: attachment; filename="filename.jpg"
        String header = part.getHeader("content-disposition");
        String[] arr = header.split(";");
        for (int i = 0; i < arr.length; i++) {
            String temp = arr[i];
            if (temp.trim().startsWith("filename")) {
                return temp.substring(temp.indexOf("=") + 2, temp.length() - 1);
            }
        }
        return "";
    }

}
