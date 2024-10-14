package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneDirectory {

    private Map<String, List<String>> contact = new HashMap<>();
    private List<String> number;

    public void add(String lastName, String phoneNumber) {
        if (contact.containsKey(lastName)) {
            number = contact.get(lastName);
            number.add(phoneNumber);
            contact.put(lastName, number);
        } else {
            number = new ArrayList<>();
            number.add(phoneNumber);
            contact.put(lastName, number);
        }
    }

    public void get(String lastName) {
        System.out.println("Номера найденные по фамилии " + lastName + '\n' + contact.get(lastName));
    }
}
