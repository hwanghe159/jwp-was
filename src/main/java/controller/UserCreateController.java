package controller;

import db.UserRepository;
import http.request.Request;
import http.response.Response;
import model.User;

public class UserCreateController implements Controller {
    @Override
    public void service(Request request, Response response) {
        if (request.isPost()) {
            doPost(request, response);
        }
    }

    public void doPost(Request request, Response response) {
        User user = request.getUser();
        UserRepository.save(user);

        response.response302Header("/index.html");
    }
}
