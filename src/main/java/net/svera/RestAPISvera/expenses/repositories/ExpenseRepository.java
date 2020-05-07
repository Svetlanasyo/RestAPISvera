package net.svera.RestAPISvera.expenses.repositories;

import net.svera.RestAPISvera.expenses.models.Expense;
import org.springframework.data.repository.CrudRepository;

public interface ExpenseRepository extends CrudRepository <Expense, Long> {
}
