package org.example;

public class Main {
    public static void main(String[] args) {
        WordArray wordArray = new WordArray();
        wordArray.originalList();
        wordArray.uniqueList();

        PhoneDirectory phoneDirectory = new PhoneDirectory();

        phoneDirectory.add("Ivanov", "8-929-000-00-00");
        phoneDirectory.add("Ivanov", "8-929-000-00-02");
        phoneDirectory.add("Ivanov", "8-929-000-00-03");
        phoneDirectory.add("Petrov", "8-929-000-00-00");
        phoneDirectory.get("Ivanov");

    }
}