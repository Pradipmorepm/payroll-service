package com.baalvion.payroll.service;

import com.baalvion.payroll.engine.*;
import com.baalvion.payroll.model.*;

public class PayrollService {

    private final SalaryCalculationService salaryService = new SalaryCalculationService();
    private final DeductionEngine deductionEngine = new DeductionEngine();
    private final TaxRuleEngine taxEngine = new TaxRuleEngine();
    private final BonusEngine bonusEngine = new BonusEngine();
    private final ArrearsService arrearsService = new ArrearsService();

    public Payslip process(EmployeePayroll payroll) {

        // 1. Salary structure applied (already inside payroll)

        // 2. Attendance handled in salary calc

        // 3. Salary rules + gross
        double gross = salaryService.calculateGross(payroll);

        // 4. Bonus
        double bonus = bonusEngine.calculate(payroll);
        gross += bonus;

        // 5. Deductions
        double deductions = deductionEngine.total(
                payroll.getSalaryStructure().getBasic(), gross
        );

        // 6. Tax
        double annualIncome = gross * 12;
        double tax = taxEngine.calculateMonthlyTDS(annualIncome);

        // 7. Arrears (example placeholder)
        double arrears = arrearsService.calculate(50000, 60000, 3);

        // 8. Final net
        double net = gross - deductions - tax + arrears;

        // 9. Build payslip
        Payslip payslip = new Payslip();
        payslip.setEmployeeId(payroll.getEmployeeId());
        payslip.setGrossSalary(gross);
        payslip.setTotalDeductions(deductions);
        payslip.setTax(tax);
        payslip.setNetSalary(net);

        return payslip;
    }
}