package com.adventofcode.day13;

import com.adventofcode.common.InputReader;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static java.lang.Integer.parseInt;
import static java.util.Comparator.comparingInt;

@Slf4j
@Component("controller-day-13")
public class Controller {

    public Controller(InputReader inputReader) {
        List<String> input = new ArrayList<>(inputReader.read("puzzle-input/day-13.txt"));
        Integer earliestDepartTime = parseInt(input.get(0));

        List<Bus> buses = new ArrayList<>();
        int index = 0;
        for (String s : input.get(1).split(",")) {
            if (!s.equals("x")) {
                buses.add(new Bus(parseInt(s), earliestDepartTime, index));
            }
            index++;
        }

        Bus bus = buses.stream().min(comparingInt(Bus::getMinTillNextDepart)).orElseThrow(NoSuchElementException::new);
        log.info("Buses: {} {}", bus, bus.getFrequency() * bus.getMinTillNextDepart());

        // TODO not sure how to solve this system of equations, this will produce the equations for input to Wolfram Alpha
        for (Bus b : buses) {
            log.info("t = (v{} * {}) - {};", b.getTimeOffsetFromT(), b.getFrequency(), b.getTimeOffsetFromT());
        }

    }

}
