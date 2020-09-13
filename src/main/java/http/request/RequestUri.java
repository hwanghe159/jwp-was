package http.request;

public class RequestUri {
    private final static String URL_DELIMITER = "\\?";

    private String path;
    private QueryParams params;

    public RequestUri(String requestUri) {
        String[] token = requestUri.split(URL_DELIMITER);
        this.path = token[0];
        if (token.length == 2) {
            this.params = new QueryParams(requestUri);
        }
    }

    public String getPath() {
        return path;
    }

    public QueryParams getParams() {
        return params;
    }
}
