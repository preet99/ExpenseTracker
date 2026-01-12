CREATE TABLE incomes (
    id BIGSERIAL PRIMARY KEY,
    amount DECIMAL(12,2) NOT NULL,
    description TEXT,
    category_id BIGINT NOT NULL,
    account_id BIGINT NOT NULL,
    income_date DATE NOT NULL,
    user_id BIGINT NOT NULL,
    
    CONSTRAINT fk_income_category
        FOREIGN KEY (category_id) REFERENCES categories (id),
        
    CONSTRAINT fk_income_account
        FOREIGN KEY (account_id) REFERENCES accounts (id),
        
    CONSTRAINT fk_income_user
        FOREIGN KEY (user_id) REFERENCES users (id)
);
