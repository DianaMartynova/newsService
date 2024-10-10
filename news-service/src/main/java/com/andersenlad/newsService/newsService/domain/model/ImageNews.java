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
import java.util.UUID;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "IMAGE_NEWS")
public class ImageNews {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "IMAGE_NEWS_ID")
    private UUID imageNewsId;

    @ManyToOne
    @JoinColumn(name = "NEWS_ID")
    private News newsId;

    @ManyToOne
    @JoinColumn(name = "IMAGE_ID")
    private Image imageId;

    @Column(name = "SIZE_IMAGE")
    private String sizeImage;
}
