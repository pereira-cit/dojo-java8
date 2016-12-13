package com.ciandt.ddig.dojo.util;

import com.ciandt.ddig.dojo.model.Exam;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.io.UncheckedIOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.hasSize;

public class DatasetReaderTest {

    private DatasetReader reader;

    @Before
    public void init() {
        reader = createDatasetReader();
    }

    @Test
    public void readHeader() {
        final List<String> readHeader = reader.readHeader();

        assertThat(readHeader, contains("name", "code", "price"));
        assertThat(readHeader, hasSize(3));
    }

    @Test
    public void readDataset(){
        final List<Exam> examList = reader.readExams();

        assertThat(examList, hasSize(229));
    }

    private DatasetReader createDatasetReader() {
        try {
            final Path path = Paths.get("src/test/resources", "exams.csv");
            Reader reader = Files.newBufferedReader(path, Charset.forName("UTF-8"));
            return new DatasetReader(reader);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}