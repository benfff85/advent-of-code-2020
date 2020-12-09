package com.adventofcode.day8;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class InstructionProcessor {

    public ProcessResponse process(List<Instruction> instructions) {
        Long accumulator = 0L;
        int indx = 0;
        List<Instruction> executedInstructions = new ArrayList<>();
        String action;

        Instruction instruction = instructions.get(indx);
        while (!executedInstructions.contains(instruction)) {
            action = instruction.getAction();
            if ("nop".equals(action)) {
                indx++;
            } else if ("acc".equals(action)) {
                accumulator += instruction.getCount();
                indx++;
            } else {
                indx += instruction.getCount();
            }
            executedInstructions.add(instruction);
            if (indx == instructions.size()) {
                return ProcessResponse.builder().type("full-execution").accumulator(accumulator).build();
            }
            instruction = instructions.get(indx);
        }
        return ProcessResponse.builder().type("loop-encountered").accumulator(accumulator).build();
    }

    public ProcessResponse processCorruptFile(List<Instruction> instructions) {

        ProcessResponse response;
        for (Instruction instruction : instructions) {
            if ("nop".equals(instruction.getAction()) || "jmp".equals(instruction.getAction())) {
                instruction.flipAction();
                response = process(instructions);
                if ("full-execution".equals(response.getType())) {
                    return response;
                }
                instruction.flipAction();
            }
        }
        return null;

    }

}
