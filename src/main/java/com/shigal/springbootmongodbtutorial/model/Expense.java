package com.shigal.springbootmongodbtutorial.model;/*
 *
 * @author Lawshiga
 *
 */

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.web.bind.annotation.PathVariable;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@Document("expense")
public class Expense {

    @Id
    private String id;

    @Field(name = "name")
    @Indexed(unique = true)
    private String expenseName;

    @Field(name = "category")
    private ExpenseCategory expenseCategory;

    @Field(name = "amount")
    private BigDecimal expenseAmount;
}
