package net.svera.RestAPISvera.expenses.models;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name="expense")
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String location;
    private String name;
    @NonNull private Date date;
    private double price;
    private double quantity;
    private String unit;
    private Date expireDate;

    @ManyToOne
    @JoinColumn(name="subcategory_id", nullable = false)
    @NonNull private Subcategory subcategory;

    public Expense() {
    }
}
