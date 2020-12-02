package com.adventofcode.day2;

import com.adventofcode.common.InputReader;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Stream;

@Slf4j
@Component("controller-day-2")
public class Controller {

    public Controller(InputReader inputReader) {
        List<String> input = inputReader.read("puzzle-input/day-2.txt");
        process(input.stream().map(PasswordPolicyA::new));
        process(input.stream().map(PasswordPolicyB::new));
    }

    private void process(Stream<PasswordPolicy> policies) {
        log.info("Valid count: {}", policies.filter(PasswordPolicy::isValid).count());
    }

}
