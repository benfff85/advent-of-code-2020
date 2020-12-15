package com.adventofcode.day12;

import com.adventofcode.common.InputReader;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Slf4j
@Component("controller-day-12")
public class Controller {

    public Controller(InputReader inputReader) {
        List<Instruction> input = inputReader.read("puzzle-input/day-12.txt").stream().map(Instruction::new).collect(toList());

        Ship ship = new Ship(false);
        input.forEach(ship::process);
        log.info("Manhattan Distance: {}", ship.getManhattanDistance());

        ship = new Ship(true);
        input.forEach(ship::process);
        log.info("Manhattan Distance: {}", ship.getManhattanDistance());

    }

}
