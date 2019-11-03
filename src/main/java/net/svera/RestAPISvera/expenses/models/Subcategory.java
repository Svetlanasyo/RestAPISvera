package net.svera.RestAPISvera.expenses.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name="SUBCATEGORY")
public class Subcategory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "subcategory")
    private Set<Expense> expenses;

    @ManyToOne
    @JoinColumn (name="expensecategory_id", nullable = false)
    private ExpenseCategory expensecategory;
}

