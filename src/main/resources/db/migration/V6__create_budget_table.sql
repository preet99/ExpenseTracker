CREATE TABLE budgets (
    id BIGSERIAL PRIMARY KEY,
    amount DECIMAL(12,2) NOT NULL,
    period VARCHAR(50) NOT NULL,        -- daily, monthly, yearly
    category_id BIGINT NOT NULL,
    user_id BIGINT NOT NULL,
    
    CONSTRAINT fk_budget_category
        FOREIGN KEY (category_id) REFERENCES categories (id),
        
    CONSTRAINT fk_budget_user
        FOREIGN KEY (user_id) REFERENCES users (id)
);
