package com.expenses.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.expenses.entity.Income;
import com.expenses.repository.IncomeRepository;
import com.expenses.service.IncomeService;

@Service
public class IncomeServiceImpl implements IncomeService {

    private final IncomeRepository incomeRepository;

    public IncomeServiceImpl(IncomeRepository incomeRepository) {
        this.incomeRepository = incomeRepository;
    }

    @Override
    public Income createIncome(Income income) {
        return incomeRepository.save(income);
    }

    @Override
    public List<Income> getAllIncome() {
        return incomeRepository.findAll();
    }

    @Override
    public Income getIncomeById(Long id) {
        return incomeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Income record not found: " + id));
    }

    @Override
    public void deleteIncome(Long id) {
        incomeRepository.deleteById(id);
    }
}
