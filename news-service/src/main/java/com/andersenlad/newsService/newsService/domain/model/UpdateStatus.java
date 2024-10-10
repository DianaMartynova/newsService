package com.andersenlad.newsService.newsService.domain.model;

import lombok.Getter;

@Getter
public enum UpdateStatus {
    PUBLISHED(2),
    ARCHIVED(1);

    private final int id;

    UpdateStatus(int id) {
        this.id = id;
    }


    public String getUpdateMessage() {
        return switch (this) {
            case PUBLISHED -> "Записи опубликованы";
            case ARCHIVED -> "Записи заархивированы";

        };

    }

    public static String getMassage(int id) {
        return switch (id) {
            case 1 -> "Записи опубликованы";
            case 2 -> "Записи заархивированы";
            default -> throw new IllegalStateException("Unexpected value: " + id);
        };
    }
}

