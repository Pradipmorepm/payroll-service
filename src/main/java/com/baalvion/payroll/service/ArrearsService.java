package com.baalvion.payroll.service;

public class ArrearsService {

    public double calculate(double oldSalary, double newSalary, int months) {
        return (newSalary - oldSalary) * months;
    }
}