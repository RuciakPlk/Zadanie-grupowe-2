package org.example.Files;

public class VideoGame {
    private final String title;
    private final String publisher;
    private final String genre;
    private final Integer releaseYear;

    public VideoGame(String title, String publisher, String genre, Integer releaseYear) {
        this.title = title;
        this.publisher = publisher;
        this.genre = genre;
        this.releaseYear = releaseYear;
    }

    public VideoGame(String textLine, String separator) {
        this(textLine.replace("\n", "").split(separator));
    }

    public VideoGame(String[] record) {
        if (record.length != 4) {
            throw new IllegalArgumentException();
        }
        else {
            this.title = record[0];
            this.publisher = record[1];
            this.genre = record[2];

            try {
                this.releaseYear = Integer.parseInt(record[3]);
            }
            catch (NumberFormatException e) {
                throw new IllegalArgumentException();
            }
        }
    }

    public String getTitle() {
        return title;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getGenre() {
        return genre;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    @Override
    public String toString() {
        return "VideoGame{" +
                "title='" + title + '\'' +
                ", publisher='" + publisher + '\'' +
                ", genre='" + genre + '\'' +
                ", releaseYear=" + releaseYear +
                '}';
    }

    public String toString(String separator) {
        return this.title + separator + this.publisher + separator + this.genre + separator + this.releaseYear;
    }

    public String[] toStringRecord() {
        return new String[] { this.title, this.publisher, this.genre, this.releaseYear.toString() };
    }
}
