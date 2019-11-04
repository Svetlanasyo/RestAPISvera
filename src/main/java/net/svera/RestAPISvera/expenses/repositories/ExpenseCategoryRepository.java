package net.svera.RestAPISvera.expenses.repositories;

import net.svera.RestAPISvera.expenses.models.ExpenseCategory;
import org.springframework.data.repository.CrudRepository;

public interface ExpenseCategoryRepository extends CrudRepository <ExpenseCategory, Long> {
}
