package com.example.javen.BasicAdapter;

/**
 * Created by Administrator on 2015/10/27.
 */
public class Book {
    private String bName;
    private String bAuthor;

    public Book(String name, String author) {
        bName = name;
        bAuthor = author;
    }

    public String getbName() {
        return bName;
    }

    public void setbName(String bName) {
        this.bName = bName;
    }

    public String getbAuthor() {
        return bAuthor;
    }

    public void setbAuthor(String bAuthor) {
        this.bAuthor = bAuthor;
    }
}
