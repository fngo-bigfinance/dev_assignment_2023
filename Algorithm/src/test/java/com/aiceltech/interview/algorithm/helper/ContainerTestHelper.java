package com.aiceltech.interview.algorithm.helper;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ContainerTestHelper {

    private ContainerTestHelper() {}

    public static List<Integer> getRandomIntegers(int min, int max, int count) {
        return IntStream.range(0, count).boxed()
                .flatMap(i -> IntStream.rangeClosed(min, max).boxed())
                .collect(Collectors.toList());
    }
}
