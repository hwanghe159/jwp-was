package controller;

import http.ContentType;
import http.request.Request;
import http.response.Response;
import utils.Directory;
import utils.FileIoUtils;

import java.io.IOException;
import java.net.URISyntaxException;

public class StaticController implements Controller {
    @Override
    public void service(Request request, Response response) throws IOException, URISyntaxException {
        String requestUrl = request.getRequestLine().getRequestUri();

        byte[] body = FileIoUtils.loadFileFromClasspath(Directory.STATIC.getDirectory() + requestUrl);
        ContentType contentType = ContentType.of(requestUrl);
        response.response200Header(body.length, contentType.getContentType());
        response.responseBody(body);
    }
}
