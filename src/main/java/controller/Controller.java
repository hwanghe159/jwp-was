package controller;

import http.request.Request;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;

public interface Controller {
    void service(Request request, DataOutputStream dos) throws IOException, URISyntaxException;
}
