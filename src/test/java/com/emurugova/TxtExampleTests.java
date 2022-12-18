package com.emurugova;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;

public class TxtExampleTests {

    @Test
    void simpleEnglishTxtTest() throws IOException {
       ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
       String txtFile;
        try (InputStream stream = classLoader.getResourceAsStream("TxtFile.txt")) {
            txtFile = new String(stream.readAllBytes(), "UTF-8");
        }
        assertThat(txtFile).contains("The syntax of Java is similar to C and C++, but has fewer low-level facilities than either of them.");
    }

    @Test
    void simpleRussianTxtTest() throws IOException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        String txtFile;
        try (InputStream stream = classLoader.getResourceAsStream("TxtFileTwo.txt")) {
            txtFile = new String(stream.readAllBytes(), "windows-1251");
        }
        assertThat(txtFile).contains("Права на торговую марку принадлежат корпорации Oracle.");
    }
}