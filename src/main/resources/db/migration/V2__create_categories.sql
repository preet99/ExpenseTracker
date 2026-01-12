CREATE TABLE categories (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    type VARCHAR(50) NOT NULL,                -- INCOME / EXPENSE
    user_id BIGINT NOT NULL,
    CONSTRAINT fk_category_user
        FOREIGN KEY (user_id) REFERENCES users (id)
);
