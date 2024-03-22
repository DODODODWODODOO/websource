package action;

import javax.servlet.http.HttpServletRequest;

import service.TodoService;
import service.TodoServiceImpl;

public class TodoDeleteAction implements Action {

    private String path;

    public TodoDeleteAction(String path) {
        this.path = path;
    }

    @Override
    public ActionForword execute(HttpServletRequest req) throws Exception {
        // TodoDeleteServlet 에서 했던 작업
        String no = req.getParameter("no");
        TodoService service = new TodoServiceImpl();
        boolean result = service.delete(no);

        return new ActionForword(path, true);
    }

}
