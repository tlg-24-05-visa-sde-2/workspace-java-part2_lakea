package com.jewelbox;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class JewelSortTest {
    public static void main(String[] args) {
        List<String> jewels = new ArrayList<>();
        jewels.add("opal");
        jewels.add("diamond");
        jewels.add("sapphire");
        jewels.add("onyx");
        jewels.add("malachite");
        jewels.add("emerald");


        jewels.sort(null);      // null means natural order
        dump(jewels);
        System.out.println();

        jewels.sort( (jewel1, jewel2) -> Integer.compare(jewel1.length(), jewel2.length()));
        dump(jewels);
        System.out.println();
    }

    private static void dump(List<String> jewelList) {
        for (String jewel : jewelList) {
            System.out.println(jewel);
        }
    }
}