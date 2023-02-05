package org.example.Files;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// TXT file implementation with default Java libraries
public class VideoGameTXTDAO implements DAO<VideoGame> {
    private final String filePath;
    private final String separator;

    public VideoGameTXTDAO(String filePath, String separator) {
        this.filePath = filePath;
        this.separator = separator;
    }

    @Override
    public Boolean create(VideoGame newObj) {
        if (checkIfExistsAndCreateIfDoesnt(filePath)) {
            String newLine = newObj.toString(this.separator);
            List<String> lines = readLinesFromFile(this.filePath);

            if (lines.contains(newLine)) {
                return false;
            }
            else {
                writeLineToFile(filePath, newLine);
                return true;
            }
        }
        else {
            return false;
        }
    }

    @Override
    public Optional<VideoGame> read(Integer id) {
        if (checkIfExistsAndCreateIfDoesnt(filePath)) {
            return lineToVideoGameObject(readLineFromFile(this.filePath, id), this.separator);
        }
        else {
            return Optional.empty();
        }
    }

    @Override
    public List<Optional<VideoGame>> readAll() {
        if (checkIfExistsAndCreateIfDoesnt(filePath)) {
            return readLinesFromFile(filePath).stream()
                            .map(line -> lineToVideoGameObject(line, this.separator))
                            .toList();
        }
        else {
            return new ArrayList<>();
        }
    }

    private static Boolean checkIfExistsAndCreateIfDoesnt(String filePath) {
        // Checks whether the file exists, and if it doesn't, it creates it
        try {
            File myFile = new File(filePath);
            if (!myFile.exists()) {
                return myFile.createNewFile();
            }
            else {
                return true;
            }
        }
        catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    private static Optional<String> readStringFromFile(String filePath) {
        try {
            return Optional.of(Files.readString(Paths.get(filePath)));
        }
        catch (IOException e) {
            return Optional.empty();
        }
    }

    private static List<String> readLinesFromFile(String filePath) {
        try {
            return Files.lines(Paths.get(filePath)).toList();
        }
        catch (IOException e) {
            return new ArrayList<>();
        }
    }

    private static Optional<String> readLineFromFile(String filePath, Integer id) {
        List<String> lines = readLinesFromFile(filePath);
        if (id >= 0 && id < lines.size()) {
            return Optional.of(lines.get(id));
        }
        else {
            return Optional.empty();
        }
    }

    private static Boolean writeLineToFile(String filePath, String line) {
        try {
            FileWriter writer = new FileWriter(filePath, true);
            writer.append(line);
            writer.append("\n");
            writer.close();
            return true;
        }
        catch (IOException e) {
            return false;
        }
    }

    private static Optional<VideoGame> lineToVideoGameObject(Optional<String> line, String separator) {
        return line.isPresent()
                ? lineToVideoGameObject(line.get(), separator)
                : Optional.empty();
    }

    private static Optional<VideoGame> lineToVideoGameObject(String line, String separator) {
        try {
            VideoGame game = new VideoGame(line, separator);
            return Optional.of(game);
        }
        catch (IllegalArgumentException e) {
            return Optional.empty();
        }
    }
}
