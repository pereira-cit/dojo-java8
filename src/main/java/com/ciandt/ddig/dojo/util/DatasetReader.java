package com.ciandt.ddig.dojo.util;

import com.ciandt.ddig.dojo.model.Exam;
import sun.misc.FloatingDecimal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.UncheckedIOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Responsável por ler um Arquivo CSV no classpath.
 */
public class DatasetReader {

    private static final String SEPARATOR = ",";

    private final Reader source;

    public DatasetReader(final Reader source) {
        this.source = source;
    }

    public List<String> readHeader() {
        try (BufferedReader datasetOrigin = new BufferedReader(source)) {
            return datasetOrigin
                    .lines()
                    .findFirst()
                    .map(line -> Arrays.asList(line.split(SEPARATOR)))
                    .get();

        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    public List<Exam> readExams() {
        try (BufferedReader datasetOrigin = new BufferedReader(source)) {
            Function<String, Exam> mapper = line -> {
                String[] split = line.split(SEPARATOR);
                double price;
                try {
                    price = Double.parseDouble(split[2]);
                } catch (NumberFormatException e) {
                    price = 0;
                }

                return new Exam(split[0], split[1], price);
            };
            return datasetOrigin
                    .lines()
                    .skip(1)
                    .map(mapper)
                    .collect(Collectors.toList());

        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
