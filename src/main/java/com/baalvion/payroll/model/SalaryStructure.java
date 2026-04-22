package com.baalvion.payroll.model;

import java.util.Map;

public class SalaryStructure {

    private double basic;
    private Map<String, Double> allowances;
    private Map<String, Double> deductions;
    private Map<String, Double> bonuses;

    public double getBasic() { return basic; }
    public void setBasic(double basic) { this.basic = basic; }

    public Map<String, Double> getAllowances() { return allowances; }
    public void setAllowances(Map<String, Double> allowances) { this.allowances = allowances; }

    public Map<String, Double> getDeductions() { return deductions; }
    public void setDeductions(Map<String, Double> deductions) { this.deductions = deductions; }

    public Map<String, Double> getBonuses() { return bonuses; }
    public void setBonuses(Map<String, Double> bonuses) { this.bonuses = bonuses; }
}