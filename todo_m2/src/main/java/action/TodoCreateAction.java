package action;

import javax.servlet.http.HttpServletRequest;

import dto.TodoDto;
import service.TodoService;
import service.TodoServiceImpl;

public class TodoCreateAction implements Action {

    private String path;

    public TodoCreateAction(String path) {
        this.path = path;
    }

    @Override
    public ActionForword execute(HttpServletRequest req) throws Exception {
        // TodoCreateServlet 에서 했던 작업
        String title = req.getParameter("title");
        String description = req.getParameter("description");

        TodoDto insertDto = new TodoDto();
        insertDto.setTitle(title);
        insertDto.setDescription(description);

        TodoService service = new TodoServiceImpl();
        boolean result = service.insert(insertDto);

        return new ActionForword(path, true);
    }

}
