package com.adventofcode.day12;

import lombok.Data;

import static java.lang.Integer.parseInt;

@Data
public class Instruction {

    private final String order;
    private final Integer value;

    public Instruction(String input) {
        order = input.substring(0, 1);
        value = parseInt(input.substring(1));
    }

}
