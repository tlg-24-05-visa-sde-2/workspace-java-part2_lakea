package com.javatunes.personnel;

import java.sql.Date;

class DummyEmployee extends Employee {

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