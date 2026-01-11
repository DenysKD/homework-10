package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Task3 {
    static void main(String[] args) {

        StringBuilder sb = new StringBuilder("");

        try (BufferedReader br = new BufferedReader(new FileReader("D:\\java\\dz10\\src\\main\\resources\\words.txt"))) {
            String str;

            while ((str = br.readLine()) != null) {
                sb.append(str + " ");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        String text = sb.toString();
        text = text.replaceAll("\\s+", " ").trim();
        String[] tmpWords = text.split(" ");

        Map<String, Integer> wordsCounter = new HashMap<>();

        for (String str : tmpWords)
            wordsCounter.merge(str, 1, Integer::sum);

        Map<String, Integer> tmpMap = new HashMap<>(wordsCounter);

        List<Map.Entry<String, Integer>> list = new ArrayList<>(wordsCounter.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> e1,
                               Map.Entry<String, Integer> e2) {
                return e2.getValue().compareTo(e1.getValue());
            }
        });

        Map<String, Integer> sortedMap = new LinkedHashMap<>();

        for (Map.Entry<String, Integer> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        System.out.println(sortedMap);
    }
}
