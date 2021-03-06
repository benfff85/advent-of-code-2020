package com.adventofcode.day10;

import com.adventofcode.common.InputReader;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static java.util.Objects.nonNull;
import static java.util.stream.Collectors.toList;
import static org.apache.commons.lang3.ObjectUtils.defaultIfNull;
import static org.springframework.util.CollectionUtils.isEmpty;

@Slf4j
@Component("controller-day-10")
public class Controller {

    private final Map<Integer, Integer> differenceOccurrenceMap = new HashMap<>();
    private final Map<Integer, Map<List<Integer>, Long>> cache = new HashMap<>();

    public Controller(InputReader inputReader) {

        List<Integer> input = inputReader.read("puzzle-input/day-10.txt").stream().map(Integer::parseInt).sorted().collect(toList());

        int difference;
        int previousNum = 0;
        for (Integer i : input) {
            difference = i - previousNum;
            trackOccurrencesOfDifferences(difference);
            previousNum = i;
        }
        trackOccurrencesOfDifferences(3);

        log.info("Product of adapters with diff 1 and adapters with diff 3: {}", differenceOccurrenceMap.get(1) * differenceOccurrenceMap.get(3));
        log.info("Count of possible adapter configurations: {}", getPossibleArrangements(0, new LinkedList<>(input)));

    }

    private void trackOccurrencesOfDifferences(int difference) {
        differenceOccurrenceMap.put(difference, defaultIfNull(differenceOccurrenceMap.get(difference), 0) + 1);
    }

    private Long getPossibleArrangements(int previous, List<Integer> remainingAdapters) {

        if (isEmpty(remainingAdapters)) {
            return 1L;
        }

        Long count = getFromCache(previous, remainingAdapters);
        if (nonNull(count)) {
            return count;
        }

        Integer nextAdapter = remainingAdapters.remove(0);
        count = getPossibleArrangements(nextAdapter, remainingAdapters);

        if (!remainingAdapters.isEmpty() && remainingAdapters.get(0) - previous <= 3) {
            count += getPossibleArrangements(previous, remainingAdapters);
        }
        remainingAdapters.add(0, nextAdapter);

        addToCache(previous, remainingAdapters, count);
        return count;
    }

    private void addToCache(int previous, List<Integer> remainingAdapters, Long count) {
        Map<List<Integer>, Long> map = new HashMap<>();
        map.put(remainingAdapters, count);
        cache.put(previous, map);
    }

    private Long getFromCache(int previous, List<Integer> remainingAdapters) {
        Map<List<Integer>, Long> map = cache.get(previous);
        return nonNull(map) ? map.get(remainingAdapters) : null;
    }

}
