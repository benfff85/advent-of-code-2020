package com.adventofcode.day9;

import com.adventofcode.common.InputReader;
import lombok.extern.slf4j.Slf4j;
import org.paukov.combinatorics3.Generator;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.Collections.max;
import static java.util.Collections.min;
import static java.util.stream.Collectors.toList;

@Slf4j
@Component("controller-day-9")
public class Controller {

    public Controller(InputReader inputReader) {

        List<Long> input = inputReader.read("puzzle-input/day-9.txt").stream().map(Long::parseLong).collect(toList());

        int preamble = 25;
        Long invalidNumber = null;
        for (int i = preamble; i < input.size(); i++) {

            List<Long> combinationSums = Generator.combination(input.subList(i - preamble, i))
                    .simple(2)
                    .stream()
                    .map(combination -> combination.stream().reduce(0L, Long::sum))
                    .collect(toList());

            if (!combinationSums.contains(input.get(i))) {
                invalidNumber = input.get(i);
                log.info("Invalid Number: {}", invalidNumber);
                break;
            }

        }

        List<Long> sublist;
        for (int i = 0; i < input.size() - 1; i++) {
            for (int j = i + 1; j < input.size(); j++) {
                sublist = input.subList(i, j + 1);
                if (sublist.stream().reduce(0L, Long::sum).equals(invalidNumber)) {
                    log.info("Sum of min and max: {}", min(sublist) + max(sublist));
                    return;
                }
            }
        }

    }
}
