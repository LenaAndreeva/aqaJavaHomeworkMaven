package org.andreevaelena.homework;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

public class AllureReport {
    public static void main(String[] args) {

        String uniqueID = UUID.randomUUID().toString();

        String allureResultsPath = "./allure-results/" + uniqueID;
        Path path = Paths.get(allureResultsPath);

        try {
            Files.createDirectories(path);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
