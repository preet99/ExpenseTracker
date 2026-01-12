CREATE TABLE recurring_transactions (
    id BIGSERIAL PRIMARY KEY,
    amount DECIMAL(12,2) NOT NULL,
    description TEXT,
    interval_type VARCHAR(50) NOT NULL,     -- WEEKLY, MONTHLY, YEARLY
    next_run_date DATE NOT NULL,
    category_id BIGINT NOT NULL,
    account_id BIGINT NOT NULL,
    user_id BIGINT NOT NULL,
    
    CONSTRAINT fk_recurring_category
        FOREIGN KEY (category_id) REFERENCES categories (id),
        
    CONSTRAINT fk_recurring_account
        FOREIGN KEY (account_id) REFERENCES accounts (id),
        
    CONSTRAINT fk_recurring_user
        FOREIGN KEY (user_id) REFERENCES users (id)
);
