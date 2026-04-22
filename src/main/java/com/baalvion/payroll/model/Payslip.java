package com.baalvion.payroll.model;

import java.util.Map;

public class Payslip {

    private String employeeId;
    private double grossSalary;
    private double totalDeductions;
    private double tax;
    private double netSalary;
    private Map<String, Double> breakdown;

    // getters/setters
    public String getEmployeeId() { return employeeId; }
    public void setEmployeeId(String employeeId) { this.employeeId = employeeId; }

    public double getGrossSalary() { return grossSalary; }
    public void setGrossSalary(double grossSalary) { this.grossSalary = grossSalary; }

    public double getTotalDeductions() { return totalDeductions; }
    public void setTotalDeductions(double totalDeductions) { this.totalDeductions = totalDeductions; }

    public double getTax() { return tax; }
    public void setTax(double tax) { this.tax = tax; }

    public double getNetSalary() { return netSalary; }
    public void setNetSalary(double netSalary) { this.netSalary = netSalary; }

    public Map<String, Double> getBreakdown() { return breakdown; }
    public void setBreakdown(Map<String, Double> breakdown) { this.breakdown = breakdown; }
}