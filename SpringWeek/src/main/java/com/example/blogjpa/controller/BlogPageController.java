package com.example.blogjpa.controller;
import com.example.blogjpa.Service.BlogService;
import com.example.blogjpa.domain.Article;
import com.example.blogjpa.domain.Comment;
import com.example.blogjpa.dto.AddArticleRequest;
import com.example.blogjpa.dto.ArticleCommentResponse;
import com.example.blogjpa.dto.ArticleResponse;

import com.example.blogjpa.dto.ArticleViewResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class BlogPageController {
    private BlogService blogService;

    public BlogPageController(BlogService blogService) {
        this.blogService = blogService;

    }

    @GetMapping("/articles")
    public String getArticles(Model model) {
        List<ArticleViewResponse> articles = blogService.findAll().stream()
                .map(ArticleViewResponse::new)
                .toList();
        model.addAttribute("articles", articles);   // model에 블로그 글 리스트 저장

        return "articleList";   // articleList.html라는 뷰 조회
    }

    @GetMapping("/articles/{id}")
    public String showArticle(@PathVariable Long id, Model model) {
        Article article = blogService.findById(id);
        List<Comment> comments = blogService.findAllCommentByArticleID(id);

        model.addAttribute("article", new ArticleViewResponse(article));

        return "article";
    }

    // id 키를 가진 queryParameter 값을 id변수에 매핑(id값이 없을 경우도 있음)
    @GetMapping("/new-article")
    public String newArticle(@RequestParam(required = false) Long id, Model model) {
        if (id == null) {
            model.addAttribute("article", new ArticleViewResponse());
        } else {
            Article article = blogService.findById(id);
            model.addAttribute("article", new ArticleViewResponse(article));
        }
        return "newArticle";
    }
}