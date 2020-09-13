package controller;

import http.ContentType;
import http.request.Request;
import utils.Directory;
import utils.FileIoUtils;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;

import static http.ResponseHeader.response200Header;
import static webserver.RequestHandler.responseBody;

public class StaticController implements Controller {
    @Override
    public void service(Request request, DataOutputStream dos) throws IOException, URISyntaxException {
        String requestUrl = request.getRequestLine().getRequestUri();

        byte[] body = FileIoUtils.loadFileFromClasspath(Directory.STATIC.getDirectory() + requestUrl);
        ContentType contentType = ContentType.of(requestUrl);
        response200Header(dos, body.length, contentType.getContentType());
        responseBody(dos, body);
    }
}
