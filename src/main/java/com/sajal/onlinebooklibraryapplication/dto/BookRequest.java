package com.sajal.onlinebooklibraryapplication.dto;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BookRequest {
    private String title,authorName,genre,description;
    private Double price;
}
