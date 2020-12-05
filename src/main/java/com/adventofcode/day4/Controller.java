package com.adventofcode.day4;

import com.adventofcode.common.InputReader;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static org.apache.logging.log4j.util.Strings.isNotEmpty;

@Slf4j
@Component("controller-day-4")
public class Controller {

    public Controller(InputReader inputReader) {
        List<Passport> passports = new ArrayList<>();
        StringBuilder fullPassportText = new StringBuilder();
        for (String string : inputReader.read("puzzle-input/day-4.txt")) {
            if (isNotEmpty(string)) {
                fullPassportText.append(string).append(" ");
            } else {
                passports.add(new Passport(fullPassportText.append(" ").toString()));
                fullPassportText.setLength(0);
            }
        }
        passports.add(new Passport(fullPassportText.append(" ").toString()));

        log.info("Total Valid Part 1: {}", passports.stream().filter(Passport::isValidPart1).count());
        log.info("Total Valid Part 2: {}", passports.stream().filter(Passport::isValidPart1).filter(Passport::isValidPart2).count());

    }

}
