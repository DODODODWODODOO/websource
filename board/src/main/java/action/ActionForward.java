package action;

public class ActionForward {
    private String path; // 경로 지정 변수
    private boolean redirect; // sandRedirect 여부(true)

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public boolean isRedirect() {
        return redirect;
    }

    public void setRedirect(boolean redirect) {
        this.redirect = redirect;
    }

    public ActionForward() {
    }

    public ActionForward(String path, boolean redirect) {
        this.path = path;
        this.redirect = redirect;
    }

}
