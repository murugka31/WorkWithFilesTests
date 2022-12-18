package com.emurugova;

import net.lingala.zip4j.exception.ZipException;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static com.emurugova.ZipData.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static utils.Files.readTextFromPath;
import static utils.ZipClass.unzip;

public class ZipExampleTest {

    @Test
    void zipWithPasswordTest() throws IOException, ZipException {
        unzip(zipFilePath, unzipFolderPath, zipPassword);
        String actualData = readTextFromPath(unzipTxtFilePath);
        assertThat(actualData, containsString(expectedData));
    }
}
