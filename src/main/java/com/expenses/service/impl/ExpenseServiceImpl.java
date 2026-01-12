package com.expenses.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.expenses.entity.Expense;
import com.expenses.repository.ExpenseRepository;
import com.expenses.service.ExpenseService;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    private final ExpenseRepository expenseRepository;

    public ExpenseServiceImpl(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    @Override
    public Expense createExpense(Expense expense) {
        return expenseRepository.save(expense);
    }

    @Override
    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }

    @Override
    public Expense getExpenseById(Long id) {
        return expenseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Expense not found: " + id));
    }

    @Override
    public Expense updateExpense(Long id, Expense updatedExpense) {
        Expense existing = getExpenseById(id);

        existing.setTitle(updatedExpense.getTitle());
        existing.setDescription(updatedExpense.getDescription());
        existing.setAmount(updatedExpense.getAmount());
        existing.setDate(updatedExpense.getDate());
        existing.setCategory(updatedExpense.getCategory());

        return expenseRepository.save(existing);
    }

    @Override
    public void deleteExpense(Long id) {
        expenseRepository.deleteById(id);
    }
}
