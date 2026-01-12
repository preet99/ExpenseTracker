package com.expenses.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.expenses.entity.Income;

public interface IncomeRepository extends JpaRepository<Income, Long> {
}
