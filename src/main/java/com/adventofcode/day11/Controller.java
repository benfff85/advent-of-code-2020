package com.adventofcode.day11;

import com.adventofcode.common.InputReader;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component("controller-day-11")
public class Controller {

    public Controller(InputReader inputReader) {
        List<String> input = inputReader.read("puzzle-input/day-11.txt");

        Plane plane = new Plane();
        input.forEach(plane::initRow);
        String previousPlaneString;
        do {
            previousPlaneString = plane.toString();
            plane.process(4, false);
        }
        while (!previousPlaneString.equals(plane.toString()));
        log.info("Total occupied seat count: {}", plane.getTotalOccupiedSeatCount());


        plane = new Plane();
        input.forEach(plane::initRow);
        do {
            previousPlaneString = plane.toString();
            plane.process(5, true);
        }
        while (!previousPlaneString.equals(plane.toString()));
        log.info("Total occupied seat count: {}", plane.getTotalOccupiedSeatCount());
    }

}
