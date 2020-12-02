package com.adventofcode.day2;

import com.adventofcode.common.InputReader;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component("controller-day-2")
public class Controller {

    private int validCount;

    public Controller(InputReader inputReader) {

        List<String> input = inputReader.read("puzzle-input/day-2.txt");
        input.stream().map(PasswordPolicyA::new).forEach(rec -> {
            if (rec.isValid()) {
                validCount++;
            }
        });
        log.info("Valid count part 1: {}", validCount);

        validCount = 0;
        input.stream().map(PasswordPolicyB::new).forEach(rec -> {
            if (rec.isValid()) {
                validCount++;
            }
        });
        log.info("Valid count part 2: {}", validCount);
    }

}
