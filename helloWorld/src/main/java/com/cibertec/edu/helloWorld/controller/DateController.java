package com.cibertec.edu.helloWorld.controller;

import java.text.DateFormatSymbols;
import java.time.LocalDate;
import java.time.Month;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DateController {
    @GetMapping("/days-until-month")
    public String daysUntilMonth(@RequestParam(name="month") int month, Model model) {
        Month targetMonth = Month.of(month);
        LocalDate today = LocalDate.now();
        LocalDate targetDate = LocalDate.of(today.getYear(), targetMonth, 1);
        int daysUntilMonth = targetDate.getDayOfYear() - today.getDayOfYear();
        if (daysUntilMonth < 0) {
            daysUntilMonth += targetDate.lengthOfYear();
        }
        
        DateFormatSymbols symbols = new DateFormatSymbols(new Locale("es"));
        String[] monthNames = symbols.getMonths();
        String targetMonthName = monthNames[month-1];
        model.addAttribute("month", targetMonthName);
        model.addAttribute("days", daysUntilMonth);
        return "daysUntilMonth";
    }
}