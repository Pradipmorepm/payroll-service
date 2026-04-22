package com.baalvion.payroll.engine;

import com.baalvion.payroll.model.EmployeePayroll;

import java.util.HashMap;
import java.util.Map;

public class SalaryRuleEngine {

    public Map<String, Double> apply(EmployeePayroll payroll) {

        Map<String, Double> components = new HashMap<>();

        double basic = payroll.getSalaryStructure().getBasic();
        components.put("BASIC", basic);

        // configurable style logic (can be DB driven later)
        components.put("HRA", basic * 0.4);

        if (payroll.getPerformanceRating() > 4) {
            components.put("PERFORMANCE_BONUS", basic * 0.1);
        }

        return components;
    }
}