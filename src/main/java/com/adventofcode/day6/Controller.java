package com.adventofcode.day6;

import com.adventofcode.common.InputReader;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static org.apache.logging.log4j.util.Strings.isNotEmpty;

@Slf4j
@Component("controller-day-6")
public class Controller {

    public Controller(InputReader inputReader) {

        List<Group> groups = new ArrayList<>();
        Group group = new Group();
        for (String string : inputReader.read("puzzle-input/day-6.txt")) {
            if (isNotEmpty(string)) {
                group.add(new Person(string));
            } else {
                groups.add(group);
                group = new Group();
            }
        }
        groups.add(group);

        log.info("Sum of questions answered yes by anyone in group: {}", groups.stream().map(g -> g.getQuestionsAnsweredYesByAnyone().size()).mapToInt(Integer::intValue).sum());
        log.info("Sum of questions answered yes by everyone in group: {}", groups.stream().map(g -> g.getQuestionsAnsweredYesByEveryone().size()).mapToInt(Integer::intValue).sum());

    }

}
