package com.aiceltech.interview.algorithm;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ContainerTest {

    private static final int EXPECTED_COUNT_PER_VALUE = 1;
    private static final List<Integer> INITIAL_VALUES = List.of(1, 2, 3, 4, 5);

    private Container<Integer> container;

    @BeforeEach
    public void init() {
        container = new DefaultContainer<>(INITIAL_VALUES);
    }

    @Test
    public void test_contains() {
        // Given
        final int existingValue = 5;
        // When
        boolean contains = container.contains(existingValue);
        // Then
        Assertions.assertTrue(contains);
    }

    @Test
    public void test_getCount() {
        // Given
        final int valueToCount = 5;
        // When
        int actualCount = container.getCount(valueToCount);
        // Then
        Assertions.assertEquals(EXPECTED_COUNT_PER_VALUE, actualCount);
    }

    @Test
    public void test_add() {
        // Given
        final int valueToAdd = 5;
        // When
        container.add(valueToAdd);
        // Then
        Assertions.assertEquals(EXPECTED_COUNT_PER_VALUE + 1, container.getCount(valueToAdd));
    }

    @Test
    public void test_remove() {
        // Given
        final int valueToRemove = 5;
        final int nonExistingValueToRemove = -1;
        // When
        boolean hasRemovedExistingValue = container.remove(valueToRemove);
        boolean hasRemovedNonExistingValue = container.remove(nonExistingValueToRemove);
        // Then
        Assertions.assertTrue(hasRemovedExistingValue);
        Assertions.assertFalse(hasRemovedNonExistingValue);
        Assertions.assertEquals(EXPECTED_COUNT_PER_VALUE - 1, container.getCount(valueToRemove));
    }
}
