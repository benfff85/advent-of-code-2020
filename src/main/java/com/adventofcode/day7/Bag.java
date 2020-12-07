package com.adventofcode.day7;

import lombok.Data;

import java.util.List;

import static java.util.Arrays.stream;
import static java.util.Collections.emptyList;
import static java.util.stream.Collectors.toList;

@Data
public class Bag {

    private final String color;
    private final List<Rule> rules;

    public Bag(String input) {
        color = input.split(" bags ")[0];
        if (input.contains("no other bags")) {
            rules = emptyList();
            return;
        }
        rules = stream(input.split(" bags contain ")[1].split(", ")).map(Rule::new).collect(toList());
    }

    public boolean containsBagOfColor(String color) {
        for (Rule rule : rules) {
            if (rule.getBagColor().equals(color)) {
                return true;
            }
        }
        return false;
    }

    public int countBagsWithin() {
        return rules.stream().map(Rule::getQuantity).mapToInt(Integer::intValue).sum();
    }

}
