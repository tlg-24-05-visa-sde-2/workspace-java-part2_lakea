/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.entertainment.catalog;

import static org.junit.Assert.*;
import java.util.Collection;
import java.util.Map;

import org.junit.Test;
import com.entertainment.Television;

public class CatalogTest {

    @Test
    public void findByBrands_shouldReturnPopulatedMap_whenOneRowPerBrandPassed_severalBrands() {
        Map<String, Collection<Television>> tvMap = Catalog.findByBrands("Zenith","Sony", "Hitachi");

        assertEquals(3, tvMap.size());

    }

    @Test
    public void findByBrands_shouldReturnPopulatedMap_whenOneRowPerBrandPassed_singeBrand() {
        Map<String, Collection<Television>> tvMap = Catalog.findByBrands("Zenith");

        assertEquals(1, tvMap.size());

        Collection<Television> zenithTvs = tvMap.get("Zenith");

        assertEquals(9, zenithTvs.size());

        for (Television tv : zenithTvs) {
            assertEquals("Zenith", tv.getBrand());
        }
    }

    @Test
    public void findByBrand_shouldReturnCollectionWithMatchingBrand_whenBrandFound() {
        Collection<Television> tvs = Catalog.findByBrand("Zenith");

        assertEquals(9, tvs.size());

        for (Television tv : tvs) {
            assertEquals("Zenith", tv.getBrand());
        }
    }

    /**
     * Contract: a no-matches result should be an empty collection (not null).
     */
    @Test
    public void testFindByBrandNoMatches() {
        Collection<Television> tvs = Catalog.findByBrand("NO-MATCHES");
        assertNotNull(tvs);
        assertTrue(tvs.isEmpty());
    }
}