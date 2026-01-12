package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Task2 {
    static void main(String[] args) {
        Gson gsonBuilder = new GsonBuilder().setPrettyPrinting().create();

        List<String> tmpUsersList = new ArrayList<>();

        try(BufferedReader br = new BufferedReader(new FileReader("src\\main\\resources\\users.txt"));) {
            String str;

            while ((str = br.readLine()) != null) {
                tmpUsersList.add(str);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        ArrayList<User> usersList = new ArrayList<User>();

        for (String str : tmpUsersList)
        {
            String[] user = str.split(" ");
            if(user[1].matches("\\d+"))
                usersList.add(new User(user[0], Integer.parseInt(user[1])));
        }

        try(FileWriter writer = new FileWriter("src\\main\\resources\\user.json"))
        {
            gsonBuilder.toJson(usersList, writer);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static class User
    {
        private String name;
        private int age;

        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }
    }
}
