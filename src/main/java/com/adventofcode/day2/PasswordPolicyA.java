package com.adventofcode.day2;

import static org.springframework.util.StringUtils.countOccurrencesOf;

public class PasswordPolicyA {

    private final Integer minOccurances;
    private final Integer maxOccurances;
    private final String character;
    private final String password;

    public PasswordPolicyA(String input) {
        minOccurances = Integer.parseInt(input.split("-")[0]);
        maxOccurances = Integer.parseInt(input.split("-")[1].split(" ")[0]);
        character = input.split(" ")[1].substring(0, 1);
        password = input.split(" ")[2];
    }

    public boolean isValid() {
        int count = countOccurrencesOf(password, character);
        return count >= minOccurances && count <= maxOccurances;
    }

}
