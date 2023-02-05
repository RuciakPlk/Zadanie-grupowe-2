package org.example.Files;

import java.util.Optional;

public class VideoGameManager {
    private final DAO<VideoGame> dao;

    public VideoGameManager(DAO<VideoGame> dao) {
        this.dao = dao;
    }

    public void seed() {
        dao.create(new VideoGame("Assassin's Creed", "Ubisoft", "Action-adventure", 2008));
        dao.create(new VideoGame("Holy Stick!", "Always Too Late", "Party Game", 2023));
        dao.create(new VideoGame("The Witcher 3", "CD Projekt", "RPG", 2015));
        dao.create(new VideoGame("Metal Gear Solid V", "Konami", "Stealth", 2015));
        dao.create(new VideoGame("The Legend of Zelda Breath of the Wild", "Nintendo", "Action-adventure", 2017));
    }

    public void test() {
        for (Optional<VideoGame> game : dao.readAll()) {
            game.ifPresentOrElse(System.out::println, () -> System.out.println("CORRUPT DATA"));
        }
    }
}
