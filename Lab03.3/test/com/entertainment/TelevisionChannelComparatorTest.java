package com.entertainment;

import org.junit.Before;
import org.junit.Test;

import java.util.Comparator;

import static org.junit.Assert.*;

public class TelevisionChannelComparatorTest {

    // need: 2 Television objects (tv1, tv2) and independent agent (comparator object)

    private TelevisionChannelComparator comparator;

    private Television tv1;
    private Television tv2;

    @Before
    public void setUp() {
        comparator = new TelevisionChannelComparator();
    }

    @Test
    public void compare_shouldReturnZero_whenChannelsAreSame() {
        int result = comparator.compare(tv1, tv2);
        assertEquals(0, result);
    }

    @Test
    public void compare_shouldReturnPositive_whenChannelIsNotEqual_firstGreaterThanSecond() throws InvalidChannelException {
        tv1.changeChannel(999);
        int result = comparator.compare(tv1, tv2);
        assertTrue(result > 0);
    }

    @Test
    public void compare_shouldReturnNegative_whenChannelIsNotEqual_firstLessThanSecond() throws Exception {
        tv2.changeChannel(999);

        int result = comparator.compare(tv1, tv2);
        assertTrue(result < 0);
    }
}
