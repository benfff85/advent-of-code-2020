package com.adventofcode.day1;


import java.util.List;

public class ListPairIterator {

    private final List<Integer> list;
    private int leftIndex;
    private int rightIndex;

    public ListPairIterator(List<Integer> list) {
        this.list = list;
        leftIndex = 0;
        rightIndex = 1;
    }

    public IntPair next() {
        IntPair pair = new IntPair(list.get(leftIndex), list.get(rightIndex));
        rightIndex++;
        if(rightIndex >= list.size()){
            leftIndex++;
            rightIndex = leftIndex + 1;
        }
        return pair;
    }

    public boolean hasNext() {
        return (leftIndex < (list.size() - 1)) || rightIndex < (list.size());
    }

}
