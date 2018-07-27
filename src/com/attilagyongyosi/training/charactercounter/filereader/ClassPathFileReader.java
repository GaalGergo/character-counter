package com.attilagyongyosi.training.charactercounter.filereader;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ClassPathFileReader implements FileReader {

    @Override
    public String read(final String path) throws FileReaderException {
        String content = "";

        try {
            Path asPath = Paths.get(getResource(path).toURI());
            content = new String(Files.readAllBytes(asPath), StandardCharsets.UTF_8);
        } catch (final IOException | URISyntaxException exception) {
            throw new FileReaderException("Failed to read file!", exception);
        }

        return content;
    }

    private URL getResource(final String path) throws FileNotFoundException  {
        URL asUrl = this.getClass().getClassLoader().getResource(path);
        if (asUrl == null) {
            throw new FileNotFoundException("File not found!");
        }

        return asUrl;
    }
}
