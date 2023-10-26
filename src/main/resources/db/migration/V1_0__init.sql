CREATE TABLE IF NOT EXISTS posts
(
    id              BIGINT AUTO_INCREMENT PRIMARY KEY,
    title           VARCHAR (255) NOT NULL,
    content         VARCHAR (1000) NOT NULL,
    creation_date   DATE NOT NULL,
    creator         VARCHAR (200),
    image           VARCHAR (500)
);