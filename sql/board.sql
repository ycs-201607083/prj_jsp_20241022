use jsp;

CREATE TABLE board
(
    id       INT PRIMARY KEY KEY AUTO_INCREMENT,
    title    VARCHAR(200)  NOT NULL,
    content  VARCHAR(5000) NOT NULL,
    writer   VARCHAR(200)  NOT NULL,
    inserted DATETIME      NOT NULL DEFAULT NOW()
);

SELECT *
FROM board;