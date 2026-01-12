CREATE TABLE accounts (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    balance DECIMAL(12,2) DEFAULT 0,
    user_id BIGINT NOT NULL,
    CONSTRAINT fk_account_user
        FOREIGN KEY (user_id) REFERENCES users (id)
);
