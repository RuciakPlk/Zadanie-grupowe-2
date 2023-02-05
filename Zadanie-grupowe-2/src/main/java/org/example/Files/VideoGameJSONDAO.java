package org.example.Files;

import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

// JSON file implementation with GSON library
public class VideoGameJSONDAO implements DAO<VideoGame> {
    private final String filePath;

    public VideoGameJSONDAO(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public Boolean create(VideoGame newObj) {
        List<Optional<VideoGame>> games = readAll();
        games.add(Optional.of(newObj));
        List<VideoGame> gamesToSerialize = games.stream().map(o -> o.orElse(null)).toList();

        String json = new Gson().toJson(gamesToSerialize);
        try {
            FileWriter writer = new FileWriter(this.filePath);
            writer.write(json);
            writer.close();
            return true;
        }
        catch (IOException e) {
            return false;
        }
    }

    @Override
    public Optional<VideoGame> read(Integer id) {
        List<Optional<VideoGame>> games = readAll();

        if (id >= 0 && id < games.size()) {
            return games.get(id);
        }
        else {
            return Optional.empty();
        }
    }

    @Override
    public List<Optional<VideoGame>> readAll() {
        try {
            String json = Files.readString(Paths.get(this.filePath));
            VideoGame[] games = new Gson().fromJson(json, VideoGame[].class);
            if (games == null) {
                return new ArrayList<>();
            }
            else {
                return new ArrayList<>(Arrays.stream(games).map(Optional::ofNullable).toList());
            }
        }
        catch (IOException e) {
            return new ArrayList<>();
        }
    }
}
