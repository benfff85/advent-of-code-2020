package com.adventofcode.day1;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Set;

import static com.google.common.collect.Sets.combinations;


@Slf4j
@Component
public class Controller {

    public Controller(InputReader inputReader) {
        Set<Integer> input = inputReader.read("puzzle-input/day-1.txt");
        process(input, 2);
        process(input, 3);
    }

    private void process(Set<Integer> input, Integer size) {
        for (Set<Integer> combination : combinations(input, size)) {
            if (combination.stream().mapToInt(Integer::intValue).sum() == 2020) {
                log.info("Combination {}", combination);
                log.info("Product {}", combination.stream().reduce(1, (a, b) -> a * b));
            }
        }
    }

}
