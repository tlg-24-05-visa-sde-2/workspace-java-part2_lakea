package com.entertainment;

import org.junit.Before;
import org.junit.Test;

import java.util.Comparator;

import static org.junit.Assert.*;

public class TelevisionBrandChannelComparatorTest {

    private Television tv1;
    private Television tv2;
    private TelevisionBrandChannelComparator comparator;

    @Before
    public void setUp() {
        tv1 = new Television("Samsung");
        tv2 = new Television("Samsung");
        comparator = new TelevisionBrandChannelComparator();
    }

    @Test
    public void compare_shouldReturnZero_whenSameBrand_sameChannel() {
        assertEquals(0, comparator.compare(tv1, tv2));
    }

    @Test
    public void compare_shouldReturnNegative_whenFirstBrandLessThanSecond() {
        tv1.setBrand("A_lessThan");
        tv2.setBrand("B_greaterThan");
        assertTrue(comparator.compare(tv1, tv2) < 0);
    }

    @Test
    public void compare_shouldReturnPositive_whenFirstBrandGreaterThanSecond() {
        tv1.setBrand("A_greaterThan");
        tv2.setBrand("B_lessThan");
        assertTrue(comparator.compare(tv1, tv2) < 0);
    }

    @Test
    public void compare_shouldReturnNegativeNumber_whenSameBrand_FirstChannelLessThanSecondChannel() throws InvalidChannelException {
        tv1.changeChannel(1);
        tv2.changeChannel(2);
        assertTrue(comparator.compare(tv1, tv2) < 0);
    }

    @Test
    public void compare_shouldReturnPositiveNumber_whenSameBrand_FirstChannelGreaterThanSecondChannel() throws InvalidChannelException {
        tv1.changeChannel(2);
        tv2.changeChannel(1);
        assertTrue(comparator.compare(tv1, tv2) > 0);
    }
}