package com.example.blogjpa.dto;

import com.example.blogjpa.domain.Comment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CommentResponse {
    private Long id;
    private String body;
    private String createdAt;

    @Builder
    public CommentResponse(Comment comment) {
        this.id = comment.getId();
        this.body = comment.getBody();
        this.createdAt = Comment.changeDateFormat(comment.getCreatedAt());
    }


}
