package com.example.urlshortener.dto;

public class UrlResponse {

    private String shortUrl;
    private String longUrl;
    private int clickCount;

    public UrlResponse(){}

    public UrlResponse(String shortUrl,String longUrl,int clickCount){
        this.shortUrl=shortUrl;
        this.longUrl=longUrl;
        this.clickCount=clickCount;

    }

    public String getShortUrl() {
        return shortUrl;
    }

    public String getLongUrl() {
        return longUrl;
    }

    public int getClickCount() {
        return clickCount;
    }

}
