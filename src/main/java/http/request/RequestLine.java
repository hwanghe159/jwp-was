package http.request;

import exception.IllegalRequestException;

import java.io.BufferedReader;

public class RequestLine {
    private static final String DELIMITER = " ";
    private Method method;
    private String requestUri;
    private String httpVersion;

    public RequestLine(BufferedReader br) throws Exception {
        String requestLine = br.readLine();
        validate(requestLine);
        String[] tokens = requestLine.split(DELIMITER);
        this.method = Method.valueOf(tokens[0]);
        this.requestUri = tokens[1];
        this.httpVersion = tokens[2];
    }

    public RequestLine(String requestLine) {
        String[] tokens = requestLine.split(DELIMITER);
        this.method = Method.valueOf(tokens[0]);
        this.requestUri = tokens[1];
        this.httpVersion = tokens[2];
    }

    private void validate(String requestLine) throws IllegalRequestException {
        if (requestLine == null) {
            throw new IllegalRequestException();
        }
    }

    public Method getMethod() {
        return method;
    }

    public String getRequestUri() {
        return requestUri;
    }

    public String getHttpVersion() {
        return httpVersion;
    }
}
