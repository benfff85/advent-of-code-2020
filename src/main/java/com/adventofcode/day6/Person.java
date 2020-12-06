package com.adventofcode.day6;

import lombok.Getter;

import java.util.HashSet;
import java.util.Set;

import static java.util.Arrays.asList;

public class Person {

    @Getter
    private final Set<String> questions;

    public Person(String input) {
        questions = new HashSet<>(asList(input.split("")));
    }

}
