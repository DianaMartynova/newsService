package com.andersenlad.newsService.newsService.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;
@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "NEWS")
public class News {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "NEWS_ID")
    private UUID newsId;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "INTRO")
    private String intro;

    @Column(name = "TEXT")
    private String text;

    @ManyToOne
    @JoinColumn(name = "CATEGORY_ID")
    private Category categoryId;

    @ManyToOne
    @JoinColumn(name = "STATUS_ID")
    private Status statusId;

    @Column(name="N_DATE_CREATE")
    private LocalDateTime nDateCreate;

    @Column(name="N_DATE_PUBLISHED")
    private LocalDateTime nDatePublished;


}
