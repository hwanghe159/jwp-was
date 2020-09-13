package webserver;

import controller.Controller;
import controller.Controllers;
import http.request.Request;
import http.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class RequestHandler implements Runnable {
    private static final Logger logger = LoggerFactory.getLogger(RequestHandler.class);

    private Socket connection;

    public RequestHandler(Socket connectionSocket) {
        this.connection = connectionSocket;
    }

    public void run() {
        logger.debug("New Client Connect! Connected IP : {}, Port : {}", connection.getInetAddress(),
                connection.getPort());

        try (InputStream in = connection.getInputStream(); OutputStream out = connection.getOutputStream()) {
            Request request = new Request(in);
            Response response = new Response(out);

            Controller controller = Controllers.getController(request.getRequestLine().getRequestUri().getPath());
            controller.service(request, response);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }
}
