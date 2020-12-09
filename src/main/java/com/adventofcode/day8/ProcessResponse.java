package com.adventofcode.day8;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@ToString
public class ProcessResponse {

    @Getter
    private final String type;
    private final Long accumulator;

}
