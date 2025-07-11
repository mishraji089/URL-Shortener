package com.example.urlshortener.model;

import jakarta.persistence.*;

@Entity
public class UrlMapping {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String shortUrl;
    @Column(nullable = false, length = 2048)
    private String longUrl;

    private int clickcount;

    public UrlMapping() {

    }

    public UrlMapping(String shortUrl, String longUrl, int clickcount) {
        this.shortUrl = shortUrl;
        this.longUrl = longUrl;
        this.clickcount = clickcount;

    }

    public Long getId() {
        return id;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    public String getLongUrl() {
        return longUrl;
    }

    public void setLongUrl(String longUrl) {
        this.longUrl = longUrl;
    }

    public int getClickcount() {
        return clickcount;
    }

    public void setClickcount(int clickcount) {
        this.clickcount = clickcount;
    }

}