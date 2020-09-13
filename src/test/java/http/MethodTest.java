package http;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MethodTest {
    @DisplayName("GET 메서드라면 true를 반환해야 한다.")
    @Test
    void isGetTest() {
        Method method = Method.GET;

        assertThat(method.isGet()).isTrue();
    }

    @DisplayName("POST 메서드라면 true를 반환해야 한다.")
    @Test
    void isPostTest() {
        Method method = Method.POST;

        assertThat(method.isPost()).isTrue();
    }
}