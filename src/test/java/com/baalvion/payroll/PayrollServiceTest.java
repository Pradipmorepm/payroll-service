package com.baalvion.payroll;

import com.baalvion.payroll.model.*;
import com.baalvion.payroll.service.PayrollService;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

public class PayrollServiceTest {

    private PayrollService payrollService = new PayrollService();

    private EmployeePayroll createEmployee(double basic, int presentDays, int rating) {

        SalaryStructure structure = new SalaryStructure();
        structure.setBasic(basic);
        structure.setAllowances(new HashMap<>());
        structure.setDeductions(new HashMap<>());
        structure.setBonuses(new HashMap<>());

        EmployeePayroll emp = new EmployeePayroll();
        emp.setEmployeeId("EMP001");
        emp.setSalaryStructure(structure);
        emp.setTotalWorkingDays(30);
        emp.setDaysPresent(presentDays);
        emp.setPerformanceRating(rating);
        emp.setOvertimeHours(5);

        return emp;
    }

    // 1. Employee with leave (LOP)
    @Test
    public void testSalaryWithLOP() {
        EmployeePayroll emp = createEmployee(50000, 25, 3);

        Payslip payslip = payrollService.process(emp);

        assertTrue(payslip.getGrossSalary() < 75000);
    }

    // 2. Employee with bonus
    @Test
    public void testSalaryWithBonus() {
        EmployeePayroll emp = createEmployee(50000, 30, 5);

        Payslip payslip = payrollService.process(emp);

        assertTrue(payslip.getGrossSalary() > 50000);
    }

    // 3. High salary (tax heavy)
    @Test
    public void testHighSalaryTax() {
        EmployeePayroll emp = createEmployee(200000, 30, 3);

        Payslip payslip = payrollService.process(emp);

        assertTrue(payslip.getTax() > 10000);
    }

    // 4. Zero attendance case
    @Test
    public void testZeroAttendance() {
        EmployeePayroll emp = createEmployee(50000, 0, 3);

        Payslip payslip = payrollService.process(emp);

        assertTrue(payslip.getGrossSalary() < 10000);
    }

    // 5. Arrears applied case
    @Test
    public void testArrearsApplied() {
        EmployeePayroll emp = createEmployee(50000, 30, 3);

        Payslip payslip = payrollService.process(emp);

        assertTrue(payslip.getNetSalary() > payslip.getGrossSalary() - payslip.getTotalDeductions());
    }
}