package http.request;

public enum Method {
    GET, POST;

    public boolean isGet() {
        return this == GET;
    }

    public boolean isPost() {
        return this == POST;
    }
}
