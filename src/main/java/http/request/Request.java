package http.request;

import http.MessageBody;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Request {
    private RequestLine requestLine;
    private RequestHeader requestHeader;
    private MessageBody messageBody;

    public Request(InputStream in) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        this.requestLine = new RequestLine(br);
        this.requestHeader = new RequestHeader(br);
        this.messageBody = new MessageBody(br, requestHeader.getContentLength());
    }

    public RequestLine getRequestLine() {
        return requestLine;
    }

    public RequestHeader getRequestHeader() {
        return requestHeader;
    }

    public MessageBody getMessageBody() {
        return messageBody;
    }

    public boolean isMethod(Method method) {
        return method == requestLine.getMethod();
    }
}
