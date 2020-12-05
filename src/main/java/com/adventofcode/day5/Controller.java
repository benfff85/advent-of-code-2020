package com.adventofcode.day5;

import com.adventofcode.common.InputReader;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Math.max;
import static java.util.Collections.sort;

@Slf4j
@Component("controller-day-5")
public class Controller {

    public Controller(InputReader inputReader) {
        long maxSeatID = 0;
        List<Long> seatIds = new ArrayList<>();
        for (BoardingPass pass : inputReader.read("puzzle-input/day-5.txt").stream().map(BoardingPass::new).collect(Collectors.toList())) {
            maxSeatID = max(pass.getSeadId(), maxSeatID);
            seatIds.add(pass.getSeadId());
        }
        log.info("Max seat number {}", maxSeatID);

        sort(seatIds);
        long previousSeatId = 69L;
        for (Long seatId : seatIds) {
            if (previousSeatId != (seatId - 1)) {
                log.info("My seat number: {}", seatId - 1);
            }
            previousSeatId = seatId;
        }

    }

}
