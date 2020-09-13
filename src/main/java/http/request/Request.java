package http.request;

import http.MessageBody;

import java.io.BufferedReader;

public class Request {
    private RequestLine requestLine;
    private RequestHeader requestHeader;
    private MessageBody messageBody;

    public Request(BufferedReader br) throws Exception {
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
