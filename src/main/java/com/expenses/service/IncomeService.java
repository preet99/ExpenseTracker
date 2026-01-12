package com.expenses.service;

import java.util.List;

import com.expenses.entity.Income;

public interface IncomeService {

    Income createIncome(Income income);

    List<Income> getAllIncome();

    Income getIncomeById(Long id);

    void deleteIncome(Long id);
}
	