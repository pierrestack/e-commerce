CREATE TABLE products
(
    id            BIGINT AUTO_INCREMENT NOT NULL,
    name          VARCHAR(255) NOT NULL,
    `description` VARCHAR(1000) NULL,
    price         DECIMAL      NOT NULL,
    stock         INT          NOT NULL,
    created_at    datetime     NOT NULL,
    category_id   BIGINT NULL,
    CONSTRAINT pk_products PRIMARY KEY (id)
);

ALTER TABLE products
    ADD CONSTRAINT FK_PRODUCTS_ON_CATEGORY FOREIGN KEY (category_id) REFERENCES categories (id);