package com.example.urlshortener.service;

import com.example.urlshortener.model.UrlMapping;
import com.example.urlshortener.repository.UrlMappingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UrlShortenerService {
    private static final String BASE62 = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    @Autowired
    UrlMappingRepository repository;

    public UrlMapping createShortUrl(String longUrl){
        UrlMapping mapping = new UrlMapping();
        mapping.setLongUrl(longUrl);
        mapping.setClickcount(0);

        // 🔥 Temporarily save without shortUrl to get the auto-generated ID
        UrlMapping saved = repository.saveAndFlush(mapping); // flush to get ID

        String shortUrl = encodeBase62(saved.getId());
        saved.setShortUrl(shortUrl);

        // 💾 Now update with shortUrl
        return repository.save(saved);
    }

    public Optional<UrlMapping> getByShortUrl(String shortUrl){
        return repository.findByShortUrl(shortUrl);
    }

    public void incrementCLick(UrlMapping mapping){
        mapping.setClickcount(mapping.getClickcount()+1);
        repository.save(mapping);

    }

    private String encodeBase62(Long id) {
        StringBuilder sb = new StringBuilder();
        while (id > 0) {
            sb.append(BASE62.charAt((int) (id % 62)));
            id /= 62;
        }
        return sb.reverse().toString();
    }
}
