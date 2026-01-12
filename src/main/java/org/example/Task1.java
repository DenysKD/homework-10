package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Task1 {
    static void main(String[] args) {

        String patern = "\\([0-9]{3}\\)\\s[0-9]{3}\\-[0-9]{4}|[0-9]{3}\\-[0-9]{3}\\-[0-9]{4}";

        List<String> validData = new ArrayList<>();

        try {
            List<String> data = Files.readAllLines(Path.of("src\\main\\resources\\file.txt"));
            for (String str : data) {
                if (str.matches(patern))
                    validData.add(str);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(validData);
    }
}


