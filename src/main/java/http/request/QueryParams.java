package http.request;

import java.util.HashMap;
import java.util.Map;

public class QueryParams {
    private final static String QUERY_PARAM_DELIMITER = "=";
    private final static String QUERY_PARAMS_DELIMITER = "&";

    private Map<String, String> queryParams = new HashMap<>();

    public QueryParams(String url) {
        String[] queryParams = url.split(QUERY_PARAMS_DELIMITER);
        for (String queryParam : queryParams) {
            String[] token = queryParam.split(QUERY_PARAM_DELIMITER);
            this.queryParams.put(token[0], token[1]);
        }
    }

    public Map<String, String> getQueryParams() {
        return queryParams;
    }
}
