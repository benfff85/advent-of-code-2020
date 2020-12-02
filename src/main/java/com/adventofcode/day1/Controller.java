package com.adventofcode.day1;

import com.adventofcode.common.InputReader;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Set;

import static com.google.common.collect.Sets.combinations;
import static java.util.stream.Collectors.toSet;


@Slf4j
@Component("controller-day-1")
public class Controller {

    public Controller(InputReader inputReader) {
        Set<Integer> input = inputReader.read("puzzle-input/day-1.txt").stream().map(Integer::parseInt).collect(toSet());
        process(input, 2);
        process(input, 3);
    }

    private void process(Set<Integer> input, Integer size) {
        for (Set<Integer> combination : combinations(input, size)) {
            if (combination.stream().mapToInt(Integer::intValue).sum() == 2020) {
                log.info("Combination: {} | Product: {}", combination, combination.stream().reduce(1, (a, b) -> a * b));
            }
        }
    }

}
