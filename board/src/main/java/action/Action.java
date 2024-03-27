package action;

import javax.servlet.http.HttpServletRequest;

public interface Action {
    public ActionForward execute(HttpServletRequest req)
            throws Exception;
}
