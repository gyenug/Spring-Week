package com.example.blogjpa.dto;

import com.example.blogjpa.domain.Article;
import com.example.blogjpa.domain.Comment;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@NoArgsConstructor
@Getter
public class ArticleCommentResponse {
    private Long id;
    private String title;
    private String content;
    private String createdAt;
    private String updatedAt;
    private List<CommentResponse> comments;
    public ArticleCommentResponse(Article article, List<CommentResponse> comments) {
        this.id = article.getId();
        this.title = article.getTitle();
        this.content = article.getContent();
        this.createdAt = Comment.changeDateFormat(article.getCreatedAt());
        this.updatedAt = Comment.changeDateFormat(article.getUpdatedAt());
        this.comments = comments;
    }
}
