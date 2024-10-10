package com.andersenlad.newsService.newsService.controller;

import com.andersenlad.newsService.newsService.domain.dto.StatusUpdateNewsDto;
import com.andersenlad.newsService.newsService.service.StatusUpdateNewsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor
@RestController
@RequestMapping("/news-service/news/control-news")
public class NewsController {

    private final StatusUpdateNewsService statusUpdateNewsService;

    @PatchMapping("/status")
    public ResponseEntity<String> updateStatusPublished(@RequestBody @Valid StatusUpdateNewsDto statusUpdateNewsDtos) {

        return ResponseEntity.ok(statusUpdateNewsService.updateStatusNews(statusUpdateNewsDtos));


    }
}
