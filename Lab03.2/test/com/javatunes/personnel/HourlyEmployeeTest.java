package com.javatunes.personnel;

import org.junit.Before;
import org.junit.Test;
import java.sql.Date;
import static org.junit.Assert.*;

public class HourlyEmployeeTest {
    // business objects under test called fixture
    private HourlyEmployee emp;

    @Before
    public void setUp() {
        emp = new HourlyEmployee("Miink", Date.valueOf("2016-03-31"), 37.5, 25.0);
    }

    @Test
    public void testPayTaxes() {
        assertEquals(234.375, emp.payTaxes(), .001);        // should be 25%
    }

    @Test
    public void testPay() {
        assertEquals(937.5, emp.pay(), .001);        //rate * hours
    }
}