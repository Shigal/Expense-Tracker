package com.shigal.springbootmongodbtutorial.service;/*
 *
 * @author Lawshiga
 *
 */

import com.shigal.springbootmongodbtutorial.model.Expense;
import com.shigal.springbootmongodbtutorial.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    private final ExpenseRepository expenseRepository;

    @Autowired
    public ExpenseServiceImpl(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    @Override
    public void addExpense(Expense expense) {
        expenseRepository.insert(expense);
    }

    @Override
    public void updateExpense(Expense expense) {
        Expense savedExpense = expenseRepository.findById(expense.getId())
                .orElseThrow(() ->
                        new RuntimeException(String.format("Cannot find expense with id %s", expense.getId())));
        savedExpense.setExpenseName(expense.getExpenseName());
        savedExpense.setExpenseAmount(expense.getExpenseAmount());
        savedExpense.setExpenseCategory(expense.getExpenseCategory());

        expenseRepository.save(savedExpense);
    }

    @Override
    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }

    @Override
    public Expense getExpenseByName(String name) {
        return expenseRepository.findByName(name).orElseThrow(() ->
                new RuntimeException(String.format("Cannot find expense by the name %s", name)));
    }

    @Override
    public void deleteExpense(String id) {
        expenseRepository.deleteById(id);
    }
}
