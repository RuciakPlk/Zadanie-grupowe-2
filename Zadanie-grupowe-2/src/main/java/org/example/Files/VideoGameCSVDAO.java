package org.example.Files;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// CSV file implementation with OpenCSV library
public class VideoGameCSVDAO implements DAO<VideoGame> {
    private final String filePath;

    public VideoGameCSVDAO(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public Boolean create(VideoGame newObj) {
        String[] record = newObj.toStringRecord();
        // TODO check for duplicates
        return writeRecordToFile(this.filePath, record);
    }

    @Override
    public Optional<VideoGame> read(Integer id) {
        Optional<String[]> record = readRecordFromFile(this.filePath, id);
        return recordToVideoGame(record);
    }

    @Override
    public List<Optional<VideoGame>> readAll() {
        return readRecordsFromFile(this.filePath).stream()
                .map(VideoGameCSVDAO::recordToVideoGame).toList();
    }

    public static List<String[]> readRecordsFromFile(String filePath) {
        try {
            FileReader fileReader = new FileReader(filePath);
            CSVReader csvReader = new CSVReader(fileReader);

            return csvReader.readAll();
        }
        catch (IOException e) {
            return new ArrayList<>();
        }
    }

    public static Optional<String[]> readRecordFromFile(String filePath, Integer id) {
        List<String[]> records = readRecordsFromFile(filePath);

        if (id >= 0 && id < records.size()) {
            return Optional.of(records.get(id));
        }
        else {
            return Optional.empty();
        }
    }

    public static Boolean writeRecordToFile(String filePath, String[] record) {
        try {
            FileWriter fileWriter = new FileWriter(filePath, true);
            CSVWriter csvWriter = new CSVWriter(fileWriter);

            csvWriter.writeNext(record);
            csvWriter.close();

            return true;
        }
        catch (IOException e) {
            return false;
        }
    }

    public static Optional<VideoGame> recordToVideoGame(Optional<String[]> record) {
        if (record.isPresent()) {
            return recordToVideoGame(record.get());
        }
        else {
            return Optional.empty();
        }
    }

    public static Optional<VideoGame> recordToVideoGame(String[] record) {
        try {
            return Optional.of(new VideoGame(record));
        }
        catch (IllegalArgumentException e) {
            return Optional.empty();
        }
    }
}
