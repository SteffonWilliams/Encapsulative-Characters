package io.zipcoder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Iterator;
import java.util.Scanner;
import java.util.*;
import static java.util.stream.Collectors.toMap;
public class WC {
    private Iterator<String> si;
    private Map<String, Integer> wordCounts = new HashMap<>();

    public WC(String fileName) {
        try {
            Scanner scanner = new Scanner(new FileReader(fileName));
            scanner.useDelimiter("[\\p{Punct}\\s]+");
            this.si = scanner;
        } catch (FileNotFoundException e) {
            System.out.println(fileName + " Does Not Exist");
            System.exit(-1);
        }
    }

    public WC(Iterator<String> si) {
        this.si = si;
    }

    public static void main(String[] args) {
        String fileName = "./../../someTextFile.txt";
        String fullPath = WC.class.getResource(fileName).getFile();
        WC wc = new WC(fullPath);
        wc.readFile();
        wc.printFile(wc.sortFile());
    }

    private void readFile() {
        for (Iterator<String> it = si; it.hasNext(); ) {
            String key = it.next().toLowerCase();
            if (wordCounts.containsKey(key)) {
                wordCounts.put(key, wordCounts.get(key) + 1);
            } else {
                wordCounts.put(key, 1);
            }
        }
    }

    private Map<String, Integer> sortFile() {
        Map<String, Integer> sorted = wordCounts
                .entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(
                        toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2,
                                LinkedHashMap::new));

        return sorted;
    }

    private void printFile(Map<String, Integer> sortedFile) {
        for (String key : sortedFile.keySet()) {
            System.out.println(key + ":  " + wordCounts.get(key));
        }
    }
}
