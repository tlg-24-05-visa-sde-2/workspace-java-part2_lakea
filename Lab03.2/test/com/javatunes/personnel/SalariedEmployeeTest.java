package com.javatunes.personnel;

import org.junit.Before;
import org.junit.Test;

import java.sql.Date;

import static org.junit.Assert.*;

public class SalariedEmployeeTest {
    // business objects under test called the fixture
    private SalariedEmployee emp;
    private SalariedEmployee emp2;

    @Before
    public void setUp() {
        emp = new SalariedEmployee("Nova", Date.valueOf("2024-03-18"), 1500.0);
        emp2 = new SalariedEmployee("Nova", Date.valueOf("2024-03-18"), 1500.0);
    }

    @Test
    public void equals_shouldReturnFalse_sameName_differentHireDate_sameSalary() {
        emp2.setHireDate(Date.valueOf("2016-03-31"));
        assertNotEquals(emp, emp2);
    }

    @Test
    public void equals_shouldReturnFalse_sameName_sameHireDate_differentSalary() {
        emp2.setSalary(1299.0);

        assertNotEquals(emp, emp2);
       // assertFalse(emp.equals(emp2));    // alternative method
    }

    @Test
    public void equals_shouldReturnTrue_allPropertiesSame() {
        assertEquals(emp, emp2);    // assertEquals() for objects does a .equals() check
        // assertTrue(emp.equals(emp2)); // alternative method
    }

    @Test
    public void testPayTaxes() {
            assertEquals(450.0, emp.payTaxes(), .001);      // 30% of the salary
    }

    @Test
    public void testPay() {
        assertEquals(1500.0, emp.pay(), .001);          // just their fixed salary

        }
    }