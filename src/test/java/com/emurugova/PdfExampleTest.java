package com.emurugova;

import com.codeborne.pdftest.PDF;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static com.emurugova.PdfData.*;

public class PdfExampleTest {

    @Test
    void simplePdfTest() throws IOException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        PDF parsedPdf = new PDF(classLoader.getResourceAsStream(pdfFilePath));
        assertThat(parsedPdf.author).contains(expectedAuthor);
        assertThat(parsedPdf.text).contains(expectedText);
    }
}

