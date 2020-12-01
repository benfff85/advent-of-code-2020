package com.adventofcode.day1;


import java.util.List;

public class ListTripleIterator {

    private final List<Integer> list;
    private int leftIndex;
    private int middleIndex;
    private int rightIndex;

    public ListTripleIterator(List<Integer> list) {
        this.list = list;
        leftIndex = 0;
        middleIndex = 1;
        rightIndex = 2;
    }

    public IntTriple next() {
        IntTriple triple = new IntTriple(list.get(leftIndex), list.get(middleIndex), list.get(rightIndex));
        rightIndex++;
        if (rightIndex >= list.size()) {
            middleIndex++;
            rightIndex = middleIndex + 1;
            if (middleIndex >= list.size() - 1) {
                leftIndex++;
                middleIndex = leftIndex + 1;
            }
            rightIndex = middleIndex + 1;
        }
        return triple;
    }

    public boolean hasNext() {
        return (leftIndex < (list.size() - 2)) || (middleIndex < (list.size() - 1)) || rightIndex < (list.size());
    }


}
