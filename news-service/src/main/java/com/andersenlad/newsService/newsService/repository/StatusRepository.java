package com.andersenlad.newsService.newsService.repository;

import com.andersenlad.newsService.newsService.domain.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepository extends JpaRepository<Status,Integer> {
}
