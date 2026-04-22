package com.baalvion.payroll.engine;

public class TaxRuleEngine {

    public double calculateMonthlyTDS(double annualIncome) {

        double tax;

        if (annualIncome <= 250000) tax = 0;
        else if (annualIncome <= 500000) tax = (annualIncome - 250000) * 0.05;
        else if (annualIncome <= 1000000) tax = 12500 + (annualIncome - 500000) * 0.2;
        else tax = 112500 + (annualIncome - 1000000) * 0.3;

        return tax / 12;
    }
}