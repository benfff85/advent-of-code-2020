package com.adventofcode.day11;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Seat {

    private final boolean isSeat;
    private boolean isOccupied;

    public Seat(String input) {
        isSeat = "L".equals(input);
        isOccupied = false;
    }

    public String toString() {
        if (isSeat()) {
            if (isOccupied()) {
                return "#";
            } else {
                return "L";
            }
        } else {
            return ".";
        }
    }

}
