package com.example.blogjpa.Service;

import com.example.blogjpa.domain.Article;
import com.example.blogjpa.domain.Comment;
import com.example.blogjpa.dto.AddArticleRequest;
import com.example.blogjpa.repository.BlogRepository;
import com.example.blogjpa.repository.CommentRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BlogService {

    private final BlogRepository blogRepository;
    private final CommentRepository commentRepository;
    public BlogService(BlogRepository blogRepository, CommentRepository commentRepository) {
        this.blogRepository = blogRepository;
        this.commentRepository = commentRepository;
    }

    public Article save(AddArticleRequest request) {
        return blogRepository.save(request.toEntity());
    }

    public List<Article> findAll(){
        return blogRepository.findAll();
    }
    public Article findById(Long id){
        return blogRepository.findAllById(id);
    }
    public void delete(Long id){
        blogRepository.deleteById(id);
    }

    public List<Comment> findAllCommentByArticleID(Long articleId){ return commentRepository.findAllByArticleId(articleId);}

    @Transactional
    public Article update(Long id, AddArticleRequest request) {
        Article article = blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found " + id));

        article.update(request.getTitle(), request.getContent());
        return article;
    }

    public Comment findByArticleIdAndId(Long articleId, Long id) {
        return commentRepository.findByArticleIdAndId(articleId, id);
    }

    @Transactional
    public void saveComment(Long articleID, String body) {
        Comment comment = new Comment(articleID, body);
        commentRepository.save(comment);
    }

    public void deleteById(Long id) {
        blogRepository.deleteById(id);
    }
}
