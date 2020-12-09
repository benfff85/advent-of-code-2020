package com.adventofcode.day8;

import lombok.Getter;
import lombok.ToString;

import static java.lang.Integer.parseInt;

@Getter
@ToString
public class Instruction {

    private String action;
    private final Integer count;

    public Instruction(String input) {
        action = input.split(" ")[0];
        count = parseInt(input.split(" ")[1]);
    }

    public void flipAction() {
        if ("nop".equals(action)) {
            action = "jmp";
        } else if ("jmp".equals(action)) {
            action = "nop";
        }
    }

}
