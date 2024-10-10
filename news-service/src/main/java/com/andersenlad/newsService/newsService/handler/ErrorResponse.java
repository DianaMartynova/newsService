package com.andersenlad.newsService.newsService.handler;

import lombok.Getter;
import java.util.List;

@Getter
public class ErrorResponse {

    private final String code;
    private final String message;
    private List<String> errors;

    public ErrorResponse(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public ErrorResponse(String code, String message, List<String> errors) {
        this.code = code;
        this.message = message;
        this.errors = errors;
    }


}

