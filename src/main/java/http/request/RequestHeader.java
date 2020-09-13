package http.request;

import http.Header;
import utils.IOUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class RequestHeader {
    private final static String DELIMITER = ": ";

    private Map<String, String> headerData;

    public RequestHeader(BufferedReader br) throws IOException {
        this.headerData = toMap(br);
        IOUtils.printHeader(headerData);
    }

    private Map<String, String> toMap(BufferedReader br) throws IOException {
        Map<String, String> headerData = new HashMap<>();
        String line = br.readLine();
        while (line != null && !"".equals(line)) {
            String[] token = line.split(DELIMITER);
            headerData.put(token[0], token[1]);
            line = br.readLine();
        }
        return headerData;
    }

    public Integer getContentLength() {
        if (headerData.get(Header.CONTENT_TYPE.getName()) == null) {
            return 0;
        }
        return Integer.parseInt(headerData.get(Header.CONTENT_LENGTH.getName()));
    }

    public Map<String, String> getHeaderData() {
        return headerData;
    }
}
