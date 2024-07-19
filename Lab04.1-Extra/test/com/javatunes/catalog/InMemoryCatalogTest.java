package com.javatunes.catalog;

import org.junit.Before;

import static org.junit.Assert.*;

public class InMemoryCatalogTest {
    // object(s) under test called 'fixture'
    private InMemoryCatalog catalog;

    @Before
    public void setUp() {
        catalog = new InMemoryCatalog();
    }
}