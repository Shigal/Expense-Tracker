package com.shigal.springbootmongodbtutorial.repository;/*
 *
 * @author Lawshiga
 *
 */

import com.shigal.springbootmongodbtutorial.model.Expense;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ExpenseRepository extends MongoRepository<Expense, String> {
}
