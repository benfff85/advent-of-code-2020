package com.adventofcode.day8;

import com.adventofcode.common.InputReader;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Slf4j
@Component("controller-day-8")
public class Controller {

    public Controller(InputReader inputReader, InstructionProcessor processor) {
        List<Instruction> instructions = inputReader.read("puzzle-input/day-8.txt").stream().map(Instruction::new).collect(toList());
        log.info("{}", processor.process(instructions));
        log.info("{}", processor.processCorruptFile(instructions));
    }

}
