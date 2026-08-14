CREATE TABLE users
(
    id         BIGINT AUTO_INCREMENT NOT NULL,
    username   VARCHAR(155) NOT NULL,
    email      VARCHAR(155) NOT NULL,
    password   VARCHAR(155) NOT NULL,
    `role`     VARCHAR(255) NOT NULL,
    created_at datetime     NOT NULL,
    CONSTRAINT pk_users PRIMARY KEY (id)
);

ALTER TABLE users
    ADD CONSTRAINT uc_users_email UNIQUE (email);

ALTER TABLE users
    ADD CONSTRAINT uc_users_username UNIQUE (username);