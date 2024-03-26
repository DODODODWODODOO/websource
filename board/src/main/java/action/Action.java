package action;

import javax.servlet.http.HttpServletRequest;

public interface Action {
    public ActionForword execute(HttpServletRequest req)
            throws Exception;
}
