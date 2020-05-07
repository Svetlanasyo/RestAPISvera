package net.svera.RestAPISvera.expenses.repositories;

import net.svera.RestAPISvera.expenses.models.Subcategory;
import org.springframework.data.repository.CrudRepository;

public interface SubcategoryRepository extends CrudRepository <Subcategory, Long> {
}
