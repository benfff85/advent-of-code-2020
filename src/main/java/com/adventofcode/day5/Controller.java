package com.adventofcode.day5;

import com.adventofcode.common.InputReader;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Component("controller-day-5")
public class Controller {

    public Controller(InputReader inputReader) {
        List<String> input = inputReader.read("puzzle-input/day-5.txt");
        input.stream().map(BoardingPass::new).map(BoardingPass::getSeadId).max(Long::compare).ifPresent(rec -> log.info("Max seat number: {}", rec));

        List<Integer> seatIds = input.stream().map(BoardingPass::new).map(BoardingPass::getSeadId).sorted().collect(Collectors.toList());
        int previousSeatId = 69;
        for (Integer seatId : seatIds) {
            if (previousSeatId != (seatId - 1)) {
                log.info("My seat number: {}", seatId - 1);
            }
            previousSeatId = seatId;
        }

    }

}
