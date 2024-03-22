package action;

import javax.servlet.http.HttpServletRequest;

import dto.TodoDto;
import service.TodoService;
import service.TodoServiceImpl;

public class TodoUpdateAction implements Action {

    private String path;

    public TodoUpdateAction(String path) {
        this.path = path;
    }

    @Override
    public ActionForword execute(HttpServletRequest req) throws Exception {
        // TodoUpdateServlet 에서 했던 작업
        String completed = req.getParameter("completed");
        String description = req.getParameter("description");
        String no = req.getParameter("no");

        TodoDto dto = new TodoDto();
        dto.setCompleted(Boolean.parseBoolean(completed));
        dto.setDescription(description);
        dto.setNo(Integer.parseInt(no));

        TodoService service = new TodoServiceImpl();
        boolean result = service.update(dto);

        // sendRedirect 라서 true
        return new ActionForword(path, true);
    }

}
