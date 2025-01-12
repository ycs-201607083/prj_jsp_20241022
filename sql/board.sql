use jsp;

CREATE TABLE board
(
    id       INT PRIMARY KEY KEY AUTO_INCREMENT,
    title    VARCHAR(200)  NOT NULL,
    content  VARCHAR(5000) NOT NULL,
    writer   VARCHAR(200)  NOT NULL,
    inserted DATETIME      NOT NULL DEFAULT NOW()
);

DROP TABLE board;

SELECT COUNT(*)
FROM board;

SELECT *
FROM board
ORDER BY id DESC;

SELECT COUNT(*)
FROM board;
# 페이징 연습용 게시물 복붙
INSERT INTO board
    (title, content, writer)
SELECT title, content, writer
FROM board;

#board.writer -> member.id 참조(외래키) 추가
ALTER TABLE board
    ADD FOREIGN KEY (writer) REFERENCES member (id);