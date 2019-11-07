package net.svera.RestAPISvera.expenses.controllers;

import lombok.AllArgsConstructor;
import net.svera.RestAPISvera.expenses.repositories.ExpenseRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;


@Controller
@AllArgsConstructor
public class ExpenseController {

    private ExpenseRepository expenseRepository;

    @RequestMapping("/expenses")
    public String getExpenses(Model model) {
        model.addAttribute("expenses", expenseRepository.findAll());

        return "expenses";
    }
}
