package com.baalvion.payroll.engine;

import com.baalvion.payroll.model.EmployeePayroll;

public class BonusEngine {

    public double calculate(EmployeePayroll payroll) {

        double basic = payroll.getSalaryStructure().getBasic();

        if (payroll.getPerformanceRating() > 4) {
            return basic * 0.1;
        }

        return 0;
    }
}