package http.request;

import exception.IllegalRequestException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RequestLineTest {
    @DisplayName("request line 문자열이 주어진 경우 적절하게 정보를 분배해야 한다")
    @Test
    void generateTest() throws IllegalRequestException {
        RequestLine requestLine = new RequestLine("GET /index.html HTTP/1.1");

        assertThat(requestLine.getMethod()).isEqualTo(Method.GET);
        assertThat(requestLine.getRequestUri().getPath()).isEqualTo("/index.html");
        assertThat(requestLine.getHttpVersion()).isEqualTo("HTTP/1.1");
    }
}
