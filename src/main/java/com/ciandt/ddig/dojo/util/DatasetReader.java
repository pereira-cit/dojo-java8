package com.ciandt.ddig.dojo.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.UncheckedIOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        return new ArrayList<>();
    }
}
