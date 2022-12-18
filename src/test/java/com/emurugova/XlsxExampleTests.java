package com.emurugova;

import com.codeborne.xlstest.XLS;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

import static com.emurugova.XlsxData.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class XlsxExampleTests {

    @Test
    void simpleXlsTest() throws IOException {
       ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
       InputStream stream = classLoader.getResourceAsStream(xlsxFilePath);
       XLS xlsFile = new XLS(stream);
       assertEquals(object, xlsFile.excel.getSheetAt(1).getRow(7).getCell(3).getStringCellValue());
       String actualData = xlsFile .excel.getSheetAt(1).getRow(2).getCell(8).toString();
       assertThat(actualData, containsString(expectedText));
    }
}
