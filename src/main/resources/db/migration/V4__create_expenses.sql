CREATE TABLE expenses (
    id BIGSERIAL PRIMARY KEY,
    amount DECIMAL(12,2) NOT NULL,
    description TEXT,
    category_id BIGINT NOT NULL,
    account_id BIGINT NOT NULL,
    expense_date DATE NOT NULL,
    user_id BIGINT NOT NULL,
    
    CONSTRAINT fk_expense_category
        FOREIGN KEY (category_id) REFERENCES categories (id),
        
    CONSTRAINT fk_expense_account
        FOREIGN KEY (account_id) REFERENCES accounts (id),
        
    CONSTRAINT fk_expense_user
        FOREIGN KEY (user_id) REFERENCES users (id)
);
