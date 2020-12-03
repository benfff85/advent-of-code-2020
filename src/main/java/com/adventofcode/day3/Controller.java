package com.adventofcode.day3;

import com.adventofcode.common.InputReader;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Slf4j
@Component("controller-day-3")
public class Controller {

    private final List<Row> treeMap;

    public Controller(InputReader inputReader) {
        treeMap = inputReader.read("puzzle-input/day-3.txt").stream().map(Row::new).collect(toList());
        log.info("Total Tree Count: {}", process(1, 1) * process(1, 3) * process(1, 5) * process(1, 7) * process(2, 1));
    }

    private Long process(int verticalSpeed, int horizontalSpeed) {
        int treeCount = 0;
        int horizontalIndex = 0;

        for (int verticalIndex = 0; verticalIndex < treeMap.size(); verticalIndex += verticalSpeed) {
            if (treeMap.get(verticalIndex).isTree(horizontalIndex)) {
                treeCount++;
            }
            horizontalIndex += horizontalSpeed;
        }
        log.info("Tree Count: {}", treeCount);
        return (long) treeCount;
    }

}
