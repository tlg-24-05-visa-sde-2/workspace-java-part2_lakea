package com.javatunes.personnel;

import org.junit.Before;
import org.junit.Test;

import java.sql.Date;

import static org.junit.Assert.*;

public class EmployeeTest {
    private Employee emp1;
    private Employee emp2;

    @Before
    public void setUp() {
        emp1 = getEmployee();
        emp2 = getEmployee();

//        emp1 = new DummyEmployee("Kea", Date.valueOf("1997-02-17"));
//        emp2 = new DummyEmployee("Kea", Date.valueOf("1997-02-17"));
    }

    private static Employee getEmployee() {
        return new Employee("Kea", Date.valueOf("1997-02-17")) {
            public double pay() {return 0;}
            public double payTaxes() { return 0;}
        };

    }

    @Test
    public void equals_shouldReturnFalse_differentName_sameHireDate() {
        emp2.setName("Miink");

        assertNotEquals(emp1, emp2);
    }

    @Test
    public void equals_shouldReturnFalse_sameName_differentireDate() {
        emp2.setHireDate(Date.valueOf("2022-04-15"));

        assertNotEquals(emp1, emp2);
    }

    @Test
    public void equals_shouldReturnTrue_sameName_sameHireDate() {
        assertEquals(emp1, emp2);
    }

    // NAMED MEMBER LEVEL INNER CLASSES. This is called a mock
    // A fake business type for testing
    private class DummyEmployee extends Employee {

        public DummyEmployee() {
        }

        public DummyEmployee(String name, Date hireDate) {
            super(name, hireDate);
        }

        @Override
        public double pay() {
            return 0;
        }

        @Override
        public double payTaxes() {
            return 0;
        }
    }
}