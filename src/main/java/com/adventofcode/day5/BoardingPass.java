package com.adventofcode.day5;

import lombok.Data;

import static java.lang.Integer.parseInt;

@Data
public class BoardingPass {

    private int row;
    private int column;
    private int seadId;

    public BoardingPass(String input) {
        row = parseInt(input.substring(0, 7).replace('B', '1').replace('F', '0'), 2);
        column = parseInt(input.substring(7, 10).replace('R', '1').replace('L', '0'), 2);
        seadId = (row * 8) + column;
    }
}
