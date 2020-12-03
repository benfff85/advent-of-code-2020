package com.adventofcode.day3;

import com.adventofcode.common.InputReader;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Slf4j
@Component("controller-day-3")
public class Controller {


    public Controller(InputReader inputReader) {
        List<String> input = inputReader.read("puzzle-input/day-3.txt");
        List<Row> treeMap = input.stream().map(Row::new).collect(toList());
        List<Long> treeCollisionsPerRun = new ArrayList<>();
        treeCollisionsPerRun.add(process(1, 1, treeMap));
        treeCollisionsPerRun.add(process(1, 3, treeMap));
        treeCollisionsPerRun.add(process(1, 5, treeMap));
        treeCollisionsPerRun.add(process(1, 7, treeMap));
        treeCollisionsPerRun.add(process(2, 1, treeMap));
        log.info("Total Tree Count: {}", treeCollisionsPerRun.stream().reduce(1L, (a, b) -> a * b));
    }

    private Long process(int verticalSpeed, int horizontalSpeed, List<Row> treeMap) {
        int treeCount = 0;
        int horizontalIndex = 0;
        int verticalIndex = 0;

        while (verticalIndex < treeMap.size()) {
            if (treeMap.get(verticalIndex).isTree(horizontalIndex)) {
                treeCount++;
            }
            horizontalIndex += horizontalSpeed;
            verticalIndex += verticalSpeed;
        }
        log.info("Tree Count: {}", treeCount);
        return (long) treeCount;
    }

}
