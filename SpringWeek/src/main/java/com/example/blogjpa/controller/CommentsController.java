package com.example.blogjpa.controller;

import com.example.blogjpa.Service.BlogService;
import com.example.blogjpa.domain.Article;
import com.example.blogjpa.domain.Comment;
import com.example.blogjpa.dto.AddCommentRequest;
import com.example.blogjpa.dto.ArticleCommentResponse;
import com.example.blogjpa.dto.CommentResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class CommentsController {


    private final BlogService blogService;

    public CommentsController(BlogService blogService) {
        this.blogService = blogService;
    }
    @GetMapping("/comments/{articleId}")
    @ResponseBody
    public ArticleCommentResponse showArticle(@PathVariable Long articleId) {
        Article article = blogService.findById(articleId);
        List<CommentResponse> comments = blogService.findAllCommentByArticleID(articleId)
                                                    .stream()
                                                    .map(CommentResponse::new)
                                                    .collect(Collectors.toList());
        return new ArticleCommentResponse(article, comments);
    }

    @GetMapping("/comments/{articleId}/{commentId}")
    @ResponseBody
    public CommentResponse showComment(@PathVariable Long articleId,@PathVariable Long commentId){
        Comment comment = blogService.findByArticleIdAndId(articleId, commentId);
        return new CommentResponse(comment);
    }

    @PostMapping("/comments/{articleId}")
    public ResponseEntity<AddCommentRequest> saveComment(@PathVariable Long articleId, @RequestBody AddCommentRequest commentRequest){
        blogService.saveComment(articleId, commentRequest.getBody());
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(commentRequest);
    }

}
