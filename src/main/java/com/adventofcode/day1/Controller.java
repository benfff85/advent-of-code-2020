package com.adventofcode.day1;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;


@Slf4j
@Component
public class Controller {

    public Controller(InputReader inputReader) {

        ListPairIterator pairIterator = new ListPairIterator(inputReader.read("puzzle-input/day-1.txt"));
        IntPair pair;
        while (pairIterator.hasNext()) {
            pair = pairIterator.next();
            if (pair.getA() + pair.getB() == 2020) {
                log.info("Pair {}", pair);
                log.info("Product {}", pair.getA() * pair.getB());
            }
        }

        ListTripleIterator tripleIterator = new ListTripleIterator(inputReader.read("puzzle-input/day-1.txt"));
        IntTriple triple;
        while (tripleIterator.hasNext()) {
            triple = tripleIterator.next();
            if (triple.getA() + triple.getB() + triple.getC() == 2020) {
                log.info("Triple {}", triple);
                log.info("Product {}", triple.getA() * triple.getB() * triple.getC());
            }
        }

    }

}
