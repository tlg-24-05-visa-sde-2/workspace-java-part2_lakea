package com.javatunes.billing;

public class TaxCalculatorFactory {

    // no instantiation from outside, this is an all static class
    private TaxCalculatorFactory() {
    }

    public static TaxCalculator createTaxCalculator(Location location) {
        // Java Part 2 sessions manuel p. 122 for more details
        TaxCalculator calc = switch (location) {
            case ONLINE -> new OnlineTax();
            case USA -> new USATax();
            case EUROPE -> new EuropeTax();
        };

        return calc;

        /*
        TaxCalculator calc = null;

        switch (location) {
            case ONLINE:
                calc = new OnlineTax();
                break;
            case USA:
                calc = new USATax();
                break;
            case EUROPE:
                calc = new EuropeTax();
                break;
        }

        return calc;
         */

    }
}