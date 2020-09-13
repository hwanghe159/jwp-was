package controller;

import db.DataBase;
import http.request.Request;
import http.response.Response;
import model.User;

import java.util.Map;

public class UserCreateController implements Controller {
    @Override
    public void service(Request request, Response response) {
        if (request.isGet()) {
//            doGet(request, response);
        } else if (request.isPost()) {
            doPost(request, response);
        }
    }

//    public void doGet(Request request, Response response) {
//        String requestUri = request.getRequestLine().getRequestUri();
//        QueryParams queryParams = new QueryParams(requestUri);
//        Map<String, String> queryParamsMap = queryParams.getQueryParams();
//
//        if (!queryParamsMap.isEmpty()) {
//            User user = new User(queryParamsMap.get("userId"), queryParamsMap.get("password"),
//                    queryParamsMap.get("name"), queryParamsMap.get("email"));
//            DataBase.addUser(user);
//            response.response302Header("/index.html");
//        }
//    }

    public void doPost(Request request, Response response) {
        Map<String, String> requestBodies = request.getMessageBody().getRequestBodies();
        User user = new User(requestBodies.get("userId"), requestBodies.get("password"),
                requestBodies.get("name"), requestBodies.get("email"));
        DataBase.addUser(user);

        response.response302Header("/index.html");
    }
}
