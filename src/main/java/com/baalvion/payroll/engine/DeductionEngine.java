package com.baalvion.payroll.engine;

public class DeductionEngine {

    public double calculatePF(double basic) {
        return basic * 0.12;
    }

    public double calculateESI(double gross) {
        return gross * 0.0175;
    }

    public double calculateProfessionalTax(double gross) {
        return gross > 15000 ? 200 : 0;
    }

    public double total(double basic, double gross) {
        return calculatePF(basic) + calculateESI(gross) + calculateProfessionalTax(gross);
    }
}