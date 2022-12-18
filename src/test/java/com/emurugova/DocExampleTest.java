package com.emurugova;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;

public class DocExampleTest {

    @Test
    void simpleRussianTxtTest() throws IOException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        String docFile;
        try (InputStream stream = classLoader.getResourceAsStream("Труды.doc")) {
            docFile = new String(stream.readAllBytes(), "windows-1251");
        }
        assertThat(docFile).contains("5 Класс");
    }
}
