package pl.edu.agh.hangman;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;
import java.util.Random;

public class RandomWordLoader {

    public String getRandomWordFromList() throws URISyntaxException {
        RandomWordLoader app = new RandomWordLoader();
        String fileName = "slowa.txt";
        File file = app.getFileFromResource(fileName);
        List<String> listFromFile = getListFromFile(file);

        Random random = new Random();
        int i = random.nextInt(1, listFromFile.size());
        return listFromFile.get(i);
    }

    private File getFileFromResource(String fileName) throws URISyntaxException {

        ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource(fileName);
        if (resource == null) {
            throw new IllegalArgumentException("file not found! " + fileName);
        } else {
            return new File(resource.toURI());
        }
    }

    private static List<String> getListFromFile(File file) {

        List<String> lines;

        try {
            lines = Files.readAllLines(file.toPath(), StandardCharsets.UTF_8);
            return lines.stream().toList();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return List.of();
    }

}
