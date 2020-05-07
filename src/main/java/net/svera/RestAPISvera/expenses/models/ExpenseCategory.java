package net.svera.RestAPISvera.expenses.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;


@Data
@Entity
@Table(name="expense_category")
public class ExpenseCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;

    @OneToMany(mappedBy = "expensecategory")
    private Set<Subcategory> subcategory;

}
