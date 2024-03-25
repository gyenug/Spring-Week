DROP TABLE IF EXISTS article;
DROP TABLE IF EXISTS comment;
CREATE TABLE article (
    id BIGINT AUTO_INCREMENT primary key,
    title varchar(255) not null,
    content varchar(255) not null,
    created_at varchar(255) not null,
    updated_at varchar(255) not null
);

CREATE TABLE comment(
    id BIGINT AUTO_INCREMENT primary key,
    article_id BIGINT not null,
    body varchar(255) not null,
    created_at DATETIME not null,
    FOREIGN KEY (article_id) REFERENCES article(id)
);

INSERT INTO article (title, content, created_at, updated_at) VALUES ('제목1', '내용1', NOW(), NOW());
INSERT INTO article (title, content, created_at, updated_at) VALUES ('제목2', '내용2', NOW(), NOW());
INSERT INTO article (title, content, created_at, updated_at) VALUES ('제목3', '내용3', NOW(), NOW());

INSERT INTO comment (article_id, body, created_at) VALUES (1, '댓글 내용1', NOW());
INSERT INTO comment (article_id, body, created_at) VALUES (2, '댓글 내용2', NOW());
INSERT INTO comment (article_id, body, created_at) VALUES (2, '댓글 내용3', NOW());