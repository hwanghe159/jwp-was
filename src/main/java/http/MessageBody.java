package http;

import model.User;
import utils.IOUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MessageBody {
    private static final String URL_DELIMITER = "&";
    private static final String BODY_DELIMITER = "=";

    private Map<String, String> requestBodies = new HashMap<>();

    public MessageBody(BufferedReader br, Integer contentLength) throws IOException {
        String line = IOUtils.readData(br, contentLength);
        if (!"".equals(line)) {
            String[] tokens = line.split(URL_DELIMITER);
            this.requestBodies = parseRequestBody(tokens);
        }
    }

    private Map<String, String> parseRequestBody(String[] tokens) {
        Map<String, String> result = new HashMap<>();
        for (String token : tokens) {
            String[] value = token.split(BODY_DELIMITER);
            result.put(value[0], value[1]);
        }
        return result;
    }

    public User getUser() {
        return new User(requestBodies.get("userId"), requestBodies.get("password"),
                requestBodies.get("name"), requestBodies.get("email"));
    }

    public Map<String, String> getRequestBodies() {
        return requestBodies;
    }
}
