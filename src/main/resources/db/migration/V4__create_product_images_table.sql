CREATE TABLE product_images
(
    id            BIGINT AUTO_INCREMENT NOT NULL,
    image_url     VARCHAR(255) NOT NULL,
    alt_text      VARCHAR(255) NULL,
    display_order INT          NOT NULL,
    type          VARCHAR(255) NULL,
    product_id    BIGINT       NOT NULL,
    created_at    datetime     NOT NULL,
    CONSTRAINT pk_product_images PRIMARY KEY (id)
);

ALTER TABLE product_images
    ADD CONSTRAINT FK_PRODUCT_IMAGES_ON_PRODUCT FOREIGN KEY (product_id) REFERENCES products (id);