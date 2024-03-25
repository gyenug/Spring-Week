package com.example.blogjpa.dto;

import com.example.blogjpa.domain.Article;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ArticleResponse {
    private String title;
    private String content;

    public ArticleResponse(Article article) {
        this.title = article.getTitle();
        this.content = article.getContent();

    }
}