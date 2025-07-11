package com.example.urlshortener.controller;

import com.example.urlshortener.dto.UrlRequest;
import com.example.urlshortener.dto.UrlResponse;
import com.example.urlshortener.model.UrlMapping;
import com.example.urlshortener.service.UrlShortenerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/")
@Tag(name="URL Shortener API")
public class UrlController {

    @Autowired
    UrlShortenerService service;

    @PostMapping("/shorten")
    @Operation(summary = "Generate short URL from a long URL")
    public ResponseEntity<UrlResponse> shorten(@RequestBody UrlRequest request){

        UrlMapping mapping=service.createShortUrl(request.getLongUrl());
        UrlResponse response=new UrlResponse(
                "http://localhost:8080/" + mapping.getShortUrl(),
                mapping.getLongUrl(),
                mapping.getClickcount()
        );
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{shortUrl}")
    @Operation(summary = "Redirect to the original long URL")
    public RedirectView redirect(@PathVariable String shortUrl) {
        return service.getByShortUrl(shortUrl)
                .map(mapping -> {
                    service.incrementCLick(mapping);
                    return new RedirectView(mapping.getLongUrl());
                })
                .orElse(new RedirectView("/not-found"));
    }
}
