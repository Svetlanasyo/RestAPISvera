package net.svera.RestAPISvera.expenses.bootstrap;

import net.svera.RestAPISvera.expenses.models.Expense;
import net.svera.RestAPISvera.expenses.models.ExpenseCategory;
import net.svera.RestAPISvera.expenses.models.Subcategory;
import net.svera.RestAPISvera.expenses.repositories.ExpenseCategoryRepository;
import net.svera.RestAPISvera.expenses.repositories.ExpenseRepository;
import net.svera.RestAPISvera.expenses.repositories.SubcategoryRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private ExpenseRepository expenseRepository;
    private ExpenseCategoryRepository expenseCategoryRepository;
    private SubcategoryRepository subcategoryRepository;

    public DevBootstrap(ExpenseRepository expenseRepository, ExpenseCategoryRepository expenseCategoryRepository, SubcategoryRepository subcategoryRepository) {
        this.expenseRepository = expenseRepository;
        this.expenseCategoryRepository = expenseCategoryRepository;
        this.subcategoryRepository = subcategoryRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initTestData();
    }

    private void initTestData() {

        //Bread
        ExpenseCategory food = new ExpenseCategory();
        food.setName("Food");
        Subcategory product = new Subcategory();
        product.setName("Product");
        product.setExpensecategory(food);
        Date date = new Date();
        Expense bread = new Expense();
        bread.setName("Bread");
        bread.setDate(date);
        bread.setPrice(2.53);
        bread.setSubcategory(product);
        bread.setLocation("Makro");
        bread.setUnit("pc");
        Date expireDate = new Date(date.getTime()+(1000*60*60*24*7));
        bread.setExpireDate(expireDate);
        bread.setQuantity(1);

        expenseCategoryRepository.save(food);
        subcategoryRepository.save(product);
        expenseRepository.save(bread);

        //Milk

        Expense milk = new Expense();
        milk.setName("Milk");
        milk.setDate(date);
        milk.setPrice(2.15);
        milk.setSubcategory(product);
        milk.setLocation("Makro");
        milk.setUnit("pc");
        Date expireDateMilk = new Date(date.getTime()+(1000*60*60*24*14));
        milk.setExpireDate(expireDateMilk);
        milk.setQuantity(1);

        expenseRepository.save(milk);

        //mobilePhone
        ExpenseCategory services = new ExpenseCategory();
        services.setName("Connection");
        Subcategory mobile = new Subcategory();
        mobile.setName("Mobile");
        mobile.setExpensecategory(services);
        Expense mobilePhone = new Expense();
        mobilePhone.setName("Mobile phone");
        mobilePhone.setDate(date);
        mobilePhone.setPrice(60);
        mobilePhone.setSubcategory(mobile);
        mobilePhone.setLocation("Plus");
        mobilePhone.setUnit("month");

        expenseCategoryRepository.save(services);
        subcategoryRepository.save(mobile);
        expenseRepository.save(mobilePhone);
    }
}
