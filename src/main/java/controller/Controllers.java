package controller;

import http.ContentType;

import java.util.HashMap;
import java.util.Map;

public class Controllers {
    private final static TemplatesController templatesController = new TemplatesController();
    private final static StaticController staticController = new StaticController();
    private final static Map<String, Controller> controllers = new HashMap<>();

    static {
        controllers.put("/users", new UserCreateController());
    }

    public static Controller getController(String requestUrl) {
        Controller controller = controllers.get(requestUrl);

        if (controller != null) {
            return controller;
        }

        ContentType contentType = ContentType.of(requestUrl);

        if (contentType == ContentType.HTML) {
            return templatesController;
        }

        return staticController;
    }
}
