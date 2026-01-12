package com.expenses.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.expenses.entity.Income;
import com.expenses.service.IncomeService;

@RestController
@RequestMapping("/api/income")
public class IncomeController {

    private final IncomeService incomeService;

    public IncomeController(IncomeService incomeService) {
        this.incomeService = incomeService;
    }

    @PostMapping
    public ResponseEntity<Income> createIncome(@RequestBody Income income) {
        return ResponseEntity.ok(incomeService.createIncome(income));
    }

    @GetMapping
    public ResponseEntity<List<Income>> getIncome() {
        return ResponseEntity.ok(incomeService.getAllIncome());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Income> getIncomeById(@PathVariable Long id) {
        return ResponseEntity.ok(incomeService.getIncomeById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteIncome(@PathVariable Long id) {
        incomeService.deleteIncome(id);
        return ResponseEntity.ok("Income record deleted successfully");
    }
}
