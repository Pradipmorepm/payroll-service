package com.baalvion.payroll.service;

import com.baalvion.payroll.engine.SalaryRuleEngine;
import com.baalvion.payroll.model.EmployeePayroll;

import java.util.Map;

public class SalaryCalculationService {

    private final SalaryRuleEngine engine = new SalaryRuleEngine();

    public double calculateGross(EmployeePayroll payroll) {

        Map<String, Double> components = engine.apply(payroll);

        double total = components.values()
                .stream()
                .mapToDouble(Double::doubleValue)
                .sum();

        int absent = payroll.getTotalWorkingDays() - payroll.getDaysPresent();
        double lop = (total / payroll.getTotalWorkingDays()) * absent;

        double overtime = payroll.getOvertimeHours() * 100;

        return total - lop + overtime;
    }
}