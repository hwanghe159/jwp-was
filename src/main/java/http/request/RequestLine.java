package http.request;

import exception.IllegalRequestException;

import java.io.BufferedReader;

public class RequestLine {
    private static final String DELIMITER = " ";
    private Method method;
    private RequestUri requestUri;
    private String httpVersion;

    public RequestLine(BufferedReader br) throws Exception {
        String requestLine = br.readLine();
        validate(requestLine);
        String[] tokens = requestLine.split(DELIMITER);
        this.method = Method.valueOf(tokens[0]);
        this.requestUri = new RequestUri(tokens[1]);
        this.httpVersion = tokens[2];
    }

    public RequestLine(String requestLine) {
        String[] tokens = requestLine.split(DELIMITER);
        this.method = Method.valueOf(tokens[0]);
        this.requestUri = new RequestUri(tokens[1]);
        this.httpVersion = tokens[2];
    }

    private void validate(String requestLine) throws IllegalRequestException {
        if (requestLine == null) {
            throw new IllegalRequestException();
        }
    }

    public boolean isGet() {
        return method.isGet();
    }

    public boolean isPost() {
        return method.isPost();
    }

    public Method getMethod() {
        return method;
    }

    public RequestUri getRequestUri() {
        return requestUri;
    }

    public String getHttpVersion() {
        return httpVersion;
    }
}
