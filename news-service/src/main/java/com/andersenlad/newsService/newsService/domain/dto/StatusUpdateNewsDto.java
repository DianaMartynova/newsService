package com.andersenlad.newsService.newsService.domain.dto;

import jakarta.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

public record StatusUpdateNewsDto(

         @NotNull int statusId,

         @NotNull List<UUID> newsIds
) {


}
