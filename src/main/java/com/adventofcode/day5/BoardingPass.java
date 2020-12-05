package com.adventofcode.day5;

import lombok.Data;

@Data
public class BoardingPass {

    private long row = 0;
    private long column = 0;
    private long seadId;

    public BoardingPass(String input) {
        if('B' == input.charAt(0))
            row +=64;
        if('B' == input.charAt(1))
            row +=32;
        if('B' == input.charAt(2))
            row +=16;
        if('B' == input.charAt(3))
            row +=8;
        if('B' == input.charAt(4))
            row +=4;
        if('B' == input.charAt(5))
            row +=2;
        if('B' == input.charAt(6))
            row +=1;

        if('R' == input.charAt(7))
            column +=4;
        if('R' == input.charAt(8))
            column +=2;
        if('R' == input.charAt(9))
            column +=1;

        seadId = (row * 8) + column;

    }
}
