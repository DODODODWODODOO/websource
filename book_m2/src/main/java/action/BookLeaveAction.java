package action;

import javax.servlet.http.HttpServletRequest;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BookLeaveAction implements Action {

    private String path;

    @Override
    public ActionForword execute(HttpServletRequest req) throws Exception {

        return new ActionForword(path, false);
    }

}
