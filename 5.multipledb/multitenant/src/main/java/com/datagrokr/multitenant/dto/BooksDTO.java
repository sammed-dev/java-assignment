package com.datagrokr.multitenant.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BooksDTO {

    private Integer book_id;
    private String bookname;
    private String genre;
    private String author;
    private Integer dtoId;

    public Integer getBook_id() {
        return book_id;
    }

    public void setBook_id(Integer book_id) {
        this.book_id = book_id;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getDtoId() {
        return dtoId;
    }

    public void setDtoId(Integer dtoId) {
        this.dtoId = dtoId;
    }
}
