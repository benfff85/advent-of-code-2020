package com.adventofcode.day13;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Bus {

    private final Integer frequency;
    private final Integer minTillNextDepart;
    private final Integer timeOffsetFromT;

    public Bus(Integer frequency, Integer earliestDepartTime, Integer timeOffsetFromT) {
        this.frequency = frequency;
        int mod = earliestDepartTime % frequency;
        minTillNextDepart = mod == 0 ? 0 : frequency - mod;
        this.timeOffsetFromT = timeOffsetFromT;
    }

}
