package com.adventofcode.day11;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static java.util.Arrays.stream;
import static java.util.Objects.nonNull;
import static java.util.stream.Collectors.toList;

public class Plane {

    private List<List<Seat>> seats = new ArrayList<>();

    public void initRow(String input) {
        seats.add(stream(input.split("")).map(Seat::new).collect(toList()));
    }

    private Seat getSeat(Integer row, Integer col) {
        try {
            return seats.get(row).get(col);
        } catch (Exception e) {
            return null;
        }
    }

    public void process(Integer adjacentThreshold, boolean travelIndicator) {
        List<List<Seat>> newSeats = new ArrayList<>();
        List<Seat> newRow;
        Seat seat;
        for (int i = 0; i < seats.size(); i++) {
            newRow = new ArrayList<>();
            for (int j = 0; j < seats.get(0).size(); j++) {
                seat = seats.get(i).get(j);
                if (seat.isSeat()) {
                    if (!seat.isOccupied() && calculateAdjacentOccupiedSeatCount(i, j, travelIndicator) == 0) {
                        newRow.add(new Seat(true, true));
                    } else if (seat.isOccupied() && calculateAdjacentOccupiedSeatCount(i, j, travelIndicator) >= adjacentThreshold) {
                        newRow.add(new Seat(true, false));
                    } else {
                        newRow.add(new Seat(true, seat.isOccupied()));
                    }
                } else {
                    newRow.add(new Seat(false, false));
                }
            }
            newSeats.add(newRow);
        }
        seats = newSeats;
    }


    private short calculateAdjacentOccupiedSeatCount(Integer row, Integer col, boolean travelIndicator) {
        short adjacentOccupiedSeatCount = 0;
        if (isNextSeatOccupied(row, col, -1, -1, travelIndicator))
            adjacentOccupiedSeatCount++;
        if (isNextSeatOccupied(row, col, -1, 0, travelIndicator))
            adjacentOccupiedSeatCount++;
        if (isNextSeatOccupied(row, col, -1, 1, travelIndicator))
            adjacentOccupiedSeatCount++;
        if (isNextSeatOccupied(row, col, 0, -1, travelIndicator))
            adjacentOccupiedSeatCount++;
        if (isNextSeatOccupied(row, col, 0, 1, travelIndicator))
            adjacentOccupiedSeatCount++;
        if (isNextSeatOccupied(row, col, 1, -1, travelIndicator))
            adjacentOccupiedSeatCount++;
        if (isNextSeatOccupied(row, col, 1, 0, travelIndicator))
            adjacentOccupiedSeatCount++;
        if (isNextSeatOccupied(row, col, 1, 1, travelIndicator))
            adjacentOccupiedSeatCount++;
        return adjacentOccupiedSeatCount;
    }

    private boolean isNextSeatOccupied(Integer row, Integer col, Integer xMove, Integer yMove, boolean travelIndicator) {
        Seat seat;
        int index = 1;
        do {
            seat = getSeat(row + (xMove * index), col + (yMove * index));
            if (nonNull(seat) && seat.isSeat()) {
                return seat.isOccupied();
            }
            index++;
        } while (nonNull(seat) && travelIndicator);
        return false;
    }

    public Integer getTotalOccupiedSeatCount() {
        AtomicInteger count = new AtomicInteger();
        seats.forEach(row -> row.forEach(seat -> count.addAndGet(seat.isOccupied() ? 1 : 0)));
        return count.get();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        seats.forEach(row -> {
            row.forEach(sb::append);
            sb.append("\n");
        });
        return sb.toString();
    }

}