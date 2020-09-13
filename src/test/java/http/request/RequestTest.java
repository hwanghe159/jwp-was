package http.request;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThat;

class RequestTest {

    @DisplayName("post Request 생성 테스트")
    @Test
    void postRequestTest() throws Exception {
        String request = "POST /user/create HTTP/1.1\n"
                + "Host: localhost:8080\n"
                + "Connection: keep-alive\n"
                + "Content-Length: 92\n"
                + "Content-Type: application/x-www-form-urlencoded\n"
                + "Accept: */*\n"
                + "\n"
                + "userId=javajigi&password=password&name=%EB%B0%95%EC%9E%AC%EC%84%B1&email=javajigi%40slipp.net";

        Request expected = new Request(new ByteArrayInputStream(request.getBytes()));

        assertThat(expected.getRequestLine().getRequestUri()).isEqualTo("/user/create");
        assertThat(expected.getRequestHeader().getRequestHeaders()).hasSize(5);
        assertThat(expected.getMessageBody().getRequestBodies()).hasSize(4);
    }

    @DisplayName("get Request 생성 테스트")
    @Test
    void getRequestTest() throws Exception {
        String request =
                "GET /user/create?userId=javajigi&password=password&name=%EB%B0%95%EC%9E%AC%EC%84%B1&email=javajigi%40slipp.net HTTP/1.1\n"
                        + "Host: localhost:8080\n"
                        + "Connection: keep-alive\n"
                        + "Accept: */*";

        Request expected = new Request(new ByteArrayInputStream(request.getBytes()));

        assertThat(expected.getRequestLine().getRequestUri()).isEqualTo(
                "/user/create?userId=javajigi&password=password&name=%EB%B0%95%EC%9E%AC%EC%84%B1&email=javajigi%40slipp.net");
        assertThat(expected.getRequestLine().getMethod()).isEqualTo(Method.GET);
        assertThat(expected.getRequestHeader().getRequestHeaders()).hasSize(3);
        assertThat(expected.getMessageBody().getRequestBodies()).hasSize(0);
    }
}
