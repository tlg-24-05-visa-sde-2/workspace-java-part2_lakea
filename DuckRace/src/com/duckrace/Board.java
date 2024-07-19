package com.duckrace;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

/*
 * This is a lookup table of ids to student names.
 * When a duck wins for the first time, we need to find out who that is.
 * This lookup table could be hardcoded with the data, or we could read the data 
 * in from a file, so that no code changes would need to be made for each cohort.
 *
 * Map<Integer,String> studentIdMap;
 * 
 * Integer    String
 * =======    ======
 *    1       John
 *    2       Jane
 *    3       Danny
 *    4       Armando
 *    5       Sheila
 *    6       Tess
 * 
 *
 * We also need a data structure to hold the results of all winners.
 * This data structure should facilitate easy lookup, retrieval, and storage.
 *
 * Map<Integer,DuckRacer> racerMap;
 *
 * Integer    DuckRacer
 * =======    =========
 *            id    name     wins   rewards
 *            --    ----     ----   -------
 *    5        5    Sheila     2    PRIZES, PRIZES
 *    6        6    Tess       1    PRIZES
 *   13       13    Zed        3    PRIZES, DEBIT_CARD, DEBIT_CARD
 *   17       17    Dom        1    DEBIT_CARD
 */

class Board {
    private final Map<Integer,String> studentIdMap = loadStudentIdMao();
    private final Map<Integer,DuckRacer> racerMap  = new TreeMap<>();

    /*
     * Updates the board by making DuckRacer win().
     *
     * Mean fetching existing DuckRacer from raceMap
     * Or create a new DuckRacer and add to map then make them win
     *
     * Someone needs to win
     */
    public void update(int id, Reward reward) {
        DuckRacer racer = null;

        if (racerMap.containsKey(id)) {
             racer = racerMap.get(id);

           // get DuckRacer at that id and call to win().

        }
        else {
            // get() DuckRacer that has that id, get() name associated with id from studentMapId
            // put() DuckRacer in the map *^DONT FORGET THIS STEP**
            // call win() on them
             racer = new DuckRacer(id, studentIdMap.get(id));
            racerMap.put(id, racer);
            racer.win(reward);
        }
        racer.win(reward);
    }
        // print title and column headings
    public void show () {
        Collection<DuckRacer> racers = racerMap.values();

        for (DuckRacer racer : racers) {
            System.out.printf("%s %s %s %s\n",
                    racer.getId(), racer.getName(), racer.getWins(), racer.getRewards());
        }
    }

    // FOR TESTING ONLY
    void dumpRacerMap() {
        Collection<DuckRacer> racers = racerMap.values();

        for (DuckRacer racer : racers) {
            System.out.println(racer);
        }
    }

    // FOR TESTING ONLY
    void dumpStudentIdMap() {
        System.out.println(studentIdMap);
    }

    private Map<Integer, String> loadStudentIdMao() {
        Map<Integer, String> map = new HashMap<>();

        // read all lines from CSV file, and process each one into an integer and a string
        try {
            List<String> lines = Files.readAllLines(Path.of("conf/student-ids.csv"));
            // for each line, "split the string into "token" -> 8 Kea
            for (String line : lines) {
                String[] tokens = line.split(",");  //"8" and "Kea"
                Integer id = Integer.valueOf(tokens[0]);
                String name = tokens[1];
                map.put(id, name);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }


        return map;
    }

}