package de.example.fajar.booklist.model;

public class Books {

    private String title, genre, writer, imgUrl;

    public Books(){

    }

    public Books(String title, String genre, String writer, String imgUrl) {
        this.title = title;
        this.genre = genre;
        this.writer = writer;
        this.imgUrl = imgUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}

