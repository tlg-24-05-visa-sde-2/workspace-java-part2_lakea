package com.entertainment.client;

import com.entertainment.Television;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

class TelevisionClient {
    public static void main(String[] args) {
        Television tv1 = new Television();
        Television tv2 = new Television("RCA", 10);

        System.out.println(tv1);
        System.out.println(tv2);

        System.out.println();

        // examine behavior of == and equals()

        Television tvA = new Television("Sony", 50);
        Television tvB = new Television("Sony", 50);
        Television tvC = new Television("Sony", 52);
        Television tvD = new Television("Sony", 12);


        System.out.println("tvA == tvB: "      + (tvA == tvB));     //false
        System.out.println("tv1a.equals(tvB: " + tvA.equals(tvB));      // true
        System.out.println();

        System.out.println(tvA.hashCode()); //54
        System.out.println(tvB.hashCode()); //54

        Set<Television> tvs = new TreeSet<>();
        tvs.add(tvA);
        tvs.add(tvB);
        tvs.add(tvC);
        tvs.add(tvD);
        System.out.println("The size of the Set is " + tvs.size());

        // Change the channel on tv2
        tv2.changeChannel(52);
        System.out.println(tv2);

    }

}