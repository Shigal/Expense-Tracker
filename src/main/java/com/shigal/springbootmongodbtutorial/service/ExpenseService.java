package com.shigal.springbootmongodbtutorial.service;/*
 *
 * @author Lawshiga
 *
 */

import com.shigal.springbootmongodbtutorial.model.Expense;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ExpenseService {

    public void addExpense(Expense expense);
    public void updateExpense(Expense expense);
    public List<Expense> getAllExpenses();
    public Expense getExpenseByName(String name);
    public void deleteExpense(String id);
}
