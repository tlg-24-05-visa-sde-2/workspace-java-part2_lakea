/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */

package com.javatunes.catalog.test;

import com.javatunes.catalog.Catalog;
import com.javatunes.catalog.InMemoryCatalog;
import com.javatunes.catalog.MusicCategory;
import com.javatunes.catalog.MusicItem;

import java.util.Collection;

class InMemoryCatalogTest {

    /*
     * One by one, complete each test method below, and then "activate" it by
     * uncommenting the call to that method in main().
     *
     * Once you see that the test method verifies the corresponding business method
     * works correctly, you can comment out that call in main() and proceed to the next one.
     */
    public static void main(String[] args) {
        //testFindById();
        // testFindByKeyword();
        //  testFindByCategory();
        // testSize();
        // testGetAll();
        // TASK test methods above and beyond the spec (Catalog interface)
        // test findSelfTitled()
         testFindRockByPrice();

        // testFindBySelfTitled();
    }

    private static void testFindRockByPrice() {
        InMemoryCatalog catalog = new InMemoryCatalog();

        Collection<MusicItem> cheapRockItems = catalog.findRockByPrice(12.0);
        dump(cheapRockItems);
    }

    private static void testFindBySelfTitled() {
        Catalog catalog = new InMemoryCatalog();

    }

    private static void testFindById() {
        InMemoryCatalog catalog = new InMemoryCatalog();

        MusicItem item = catalog.findById(6L);  //autobox primitive long to Long object
        System.out.println(item);

        MusicItem notFound = catalog.findById(66L);     // should return null
        System.out.println(notFound);
    }

    private static void testFindByKeyword() {
    }

    private static void testFindByCategory() {
        InMemoryCatalog catalog = new InMemoryCatalog();

        Collection<MusicItem> items = catalog.findByCategory(MusicCategory.RAP);
        dump(items);
    }


    private static void testSize() {
        InMemoryCatalog catalog = new InMemoryCatalog();
        System.out.println(catalog.size());
    }

    private static void testGetAll() {
        InMemoryCatalog catalog = new InMemoryCatalog();

        Collection<MusicItem> readOnlyItems = catalog.getAll();     // read only view of the 18
        readOnlyItems.clear();
    }

    private static void dump(Collection<MusicItem> items) {
        for (MusicItem item : items) {
            System.out.println(items);
        }
    }
}