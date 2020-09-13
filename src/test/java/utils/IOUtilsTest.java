package utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.StringReader;

import static org.assertj.core.api.Assertions.assertThat;

public class IOUtilsTest {
    @DisplayName("BufferedReader로부터 데이터를 읽어올 수 있어야 한다.")
    @Test
    public void readDataTest() throws Exception {
        String data = "abcd123";
        StringReader sr = new StringReader(data);
        BufferedReader br = new BufferedReader(sr);

        assertThat(IOUtils.readData(br, data.length())).isEqualTo(data);
    }
}
