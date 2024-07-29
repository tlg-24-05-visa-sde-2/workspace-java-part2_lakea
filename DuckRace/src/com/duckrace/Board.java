package com.duckrace;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

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

public class Board implements Serializable {
    private static final String DATA_FILE_PATH = "data/board.dat";
    private static final String CONF_FILE_PATH = "conf/student-ids.csv";

    /*
     * If data/board.dat exists the application has been run before =, at least once.
     * Therefore, recreate the board object from that binary final.
     *
     * If the file is not there, this is the very first time the app has been ran.
     * Therefore, create and return new board.
     */
    public static Board getInstance() {

        Board board = null;

        if (Files.exists(Path.of(DATA_FILE_PATH))) {
            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(DATA_FILE_PATH))) {
                board = (Board) in.readObject();

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            board = new Board();
        }
        return board;
    }

    private final Map<Integer, String> studentIdMap = loadStudentIdMao();
    private final Map<Integer, DuckRacer> racerMap = new TreeMap<>();

    // private ctor - prevent instantiation outside = only getInstance() cn do this

    private Board() {

    }

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

        } else {
            racer = new DuckRacer(id, studentIdMap.get(id));
            racerMap.put(id, racer);
        }
        racer.win(reward);

        save();
    }

    private void save() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(DATA_FILE_PATH))) {
            out.writeObject(this);      // write "me: binary file ("I" am a board object)
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // print title and column headings
    public void show() {
        Collection<DuckRacer> racers = racerMap.values();

        String header = """
                Duck Race Results
                =================
                
                id    name     wins   rewards
                --    ----     ----   -------
                """;

        StringBuilder board = new StringBuilder(header);

        for (DuckRacer racer : racerMap.values()) {
            String rewardsString = racer.getRewards().toString();
            String rewards = rewardsString.substring(1, rewardsString.length() - 1);

            String row = String.format("%2d    %-9s %4d    %s\n",
                    racer.getId(), racer.getName(), racer.getWins(), rewards);
            board.append(row);
        }
        System.out.println(board);
    }


    private Map<Integer, String> loadStudentIdMao() {
        Map<Integer, String> map = new HashMap<>();

        // read all lines from CSV file, and process each one into an integer and a string
        try {
            List<String> lines = Files.readAllLines(Path.of(CONF_FILE_PATH));

            // for each line, "split" the string into "tokens"
            for (String line : lines) {
                String[] tokens = line.split(",");  // "1" and "Bullen"
                Integer id = Integer.valueOf(tokens[0]);
                String name = tokens[1];
                map.put(id, name);
            }
        } catch (IOException e) {
            e.printStackTrace();

        }
        return map;
    }
}