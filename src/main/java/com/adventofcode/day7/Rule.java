package com.adventofcode.day7;

import lombok.Data;

import static java.lang.Integer.parseInt;

@Data
public class Rule {

    private final Integer quantity;
    private final String bagColor;

    public Rule(String input) {
        quantity = parseInt(input.split(" ")[0]);
        bagColor = input.split(" ", 2)[1].split(" bag")[0];
    }

}
