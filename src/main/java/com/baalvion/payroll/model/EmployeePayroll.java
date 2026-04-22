package com.baalvion.payroll.model;

public class EmployeePayroll {

    private String employeeId;
    private SalaryStructure salaryStructure;
    private int totalWorkingDays;
    private int daysPresent;
    private double overtimeHours;
    private int performanceRating;

    // getters/setters
    public String getEmployeeId() { return employeeId; }
    public void setEmployeeId(String employeeId) { this.employeeId = employeeId; }

    public SalaryStructure getSalaryStructure() { return salaryStructure; }
    public void setSalaryStructure(SalaryStructure salaryStructure) { this.salaryStructure = salaryStructure; }

    public int getTotalWorkingDays() { return totalWorkingDays; }
    public void setTotalWorkingDays(int totalWorkingDays) { this.totalWorkingDays = totalWorkingDays; }

    public int getDaysPresent() { return daysPresent; }
    public void setDaysPresent(int daysPresent) { this.daysPresent = daysPresent; }

    public double getOvertimeHours() { return overtimeHours; }
    public void setOvertimeHours(double overtimeHours) { this.overtimeHours = overtimeHours; }

    public int getPerformanceRating() { return performanceRating; }
    public void setPerformanceRating(int performanceRating) { this.performanceRating = performanceRating; }
}