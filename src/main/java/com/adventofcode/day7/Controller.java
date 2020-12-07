package com.adventofcode.day7;

import com.adventofcode.common.InputReader;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Map;

import static java.util.stream.Collectors.toMap;

@Slf4j
@Component("controller-day-7")
public class Controller {

    private final Map<String, Bag> bags;

    public Controller(InputReader inputReader) {
        bags = inputReader.read("puzzle-input/day-7.txt").stream().map(Bag::new).collect(toMap(Bag::getColor, b -> b));
        int countContainingGold = 0;
        for (String bagColor : bags.keySet()) {
            if (containsGoldBag(bagColor)) {
                countContainingGold++;
            }
        }
        log.info("Count of bags containing a gold bag: {}", countContainingGold);
        log.info("Total bags within gold bag: {}", countBagsWithin("shiny gold", 1));
    }

    // TODO this logic probably belongs in the Bag class
    private boolean containsGoldBag(String bagColor) {
        Bag bag = bags.get(bagColor);
        if (bag.containsBagOfColor("shiny gold")) {
            return true;
        }
        for (Rule rule : bag.getRules()) {
            if (containsGoldBag(rule.getBagColor())) {
                return true;
            }
        }
        return false;
    }

    private Integer countBagsWithin(String bagColor, Integer multiplier) {
        Bag bag = bags.get(bagColor);
        Integer count = bag.countBagsWithin() * multiplier;
        for (Rule rule : bag.getRules()) {
            count += countBagsWithin(rule.getBagColor(), rule.getQuantity() * multiplier);
        }
        return count;
    }

}
