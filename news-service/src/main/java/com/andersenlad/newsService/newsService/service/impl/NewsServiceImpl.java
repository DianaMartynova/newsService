package com.andersenlad.newsService.newsService.service.impl;

import com.andersenlad.newsService.newsService.domain.dto.StatusUpdateNewsDto;
import com.andersenlad.newsService.newsService.domain.model.Status;
import com.andersenlad.newsService.newsService.domain.model.UpdateStatus;
import com.andersenlad.newsService.newsService.repository.NewsRepository;
import com.andersenlad.newsService.newsService.repository.StatusRepository;
import com.andersenlad.newsService.newsService.service.StatusUpdateNewsService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Slf4j
@Service
@RequiredArgsConstructor
public class NewsServiceImpl implements StatusUpdateNewsService {

    private final NewsRepository newsRepository;
    private final StatusRepository statusRepository;

    @Override
    @Transactional
    public String updateStatusNews(StatusUpdateNewsDto statusUpdateNewsDtos) {

        Status status = statusRepository.findById(statusUpdateNewsDtos.statusId()).orElseThrow(()
                -> new EntityNotFoundException("Статус не найден"));
        statusUpdateNewsDtos.newsIds().stream()
                .map(newsId -> newsRepository.findById(newsId)
                        .orElseThrow(() -> new EntityNotFoundException("Новость не найдена")))
                .forEach(newsUpdate -> {
                    newsUpdate.setStatusId(status);
                    newsRepository.save(newsUpdate);
                });


        return UpdateStatus.getMassage(status.getStatusId());

    }
}


