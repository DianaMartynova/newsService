package com.andersenlad.newsService.newsService.service.impl;

import com.andersenlad.newsService.newsService.domain.dto.StatusUpdateNewsDto;
import com.andersenlad.newsService.newsService.domain.model.News;
import com.andersenlad.newsService.newsService.domain.model.Status;
import com.andersenlad.newsService.newsService.repository.NewsRepository;
import com.andersenlad.newsService.newsService.repository.StatusRepository;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;


class NewsServiceImplTest {
    NewsRepository newsRepository = Mockito.mock(NewsRepository.class);
    StatusRepository statusRepository = Mockito.mock(StatusRepository.class);
    NewsServiceImpl newsService = new NewsServiceImpl(newsRepository, statusRepository);

    private int statusPublished;
    private String statusPublishedName;
    private int statusArhived;
    private String statusArhivedName;
    private UUID newsId= UUID.fromString("254e8333-e29b-41d4-a716-446655449990");


    @BeforeEach
    public void setUp() {
        statusPublished = 1;
        statusPublishedName = "Записи опубликованы";

        statusArhived = 2;
        statusArhivedName = "Записи опубликованы";

    }


    @Test
    void updateStatusNews() {
        StatusUpdateNewsDto statusUpdateNewsDto = new StatusUpdateNewsDto(statusArhived,
                List.of((newsId)));

        Status status = new Status();
        status.setNameStatus(statusArhivedName);
        status.setStatusId(statusArhived);

        Status status2 = new Status();
        status2.setNameStatus(statusPublishedName);
        status2.setStatusId(statusPublished);

        News news = new News();
        news.setNewsId(newsId);
        news.setStatusId(status2);

        when(newsRepository.findById(UUID.fromString("254e8333-e29b-41d4-a716-446655449990")))
                .thenReturn(Optional.of(news));
        when(statusRepository.findById(2)).thenReturn(Optional.of(status));

        String result = newsService.updateStatusNews(statusUpdateNewsDto);
        assertEquals("Записи заархивированы", result);


    }

    @Test
    void updateStatus2News() {
        StatusUpdateNewsDto statusUpdateNewsDto = new StatusUpdateNewsDto(statusPublished,
                List.of(newsId));

        Status status = new Status();
        status.setNameStatus(statusArhivedName);
        status.setStatusId(statusArhived);

        Status status2 = new Status();
        status2.setNameStatus(statusPublishedName);
        status2.setStatusId(statusPublished);

        News news = new News();
        news.setNewsId(newsId);
        news.setStatusId(status);


        when(newsRepository.findById(UUID.fromString("254e8333-e29b-41d4-a716-446655449990")))
                .thenReturn(Optional.of(news));
        when(statusRepository.findById(1)).thenReturn(Optional.of(status2));

        String result = newsService.updateStatusNews(statusUpdateNewsDto);
        assertEquals("Записи опубликованы", result);


    }

    @Test
    void testServiceThrowsException() {

        UUID newsId = UUID.randomUUID();
        StatusUpdateNewsDto statusUpdateNewsDto = new StatusUpdateNewsDto(statusArhived,
                List.of(newsId));
        Status status = new Status();
        status.setNameStatus(statusPublishedName);
        status.setStatusId(statusPublished);
        News news = new News();
        news.setNewsId(UUID.fromString("254e8333-e29b-41d4-a716-446655449990"));
        news.setStatusId(status);

        when(newsRepository.findById(newsId)).thenThrow(new EntityNotFoundException("Новость не найдена"));
        assertThrows(EntityNotFoundException.class, () -> newsService.updateStatusNews(statusUpdateNewsDto));
    }
}
