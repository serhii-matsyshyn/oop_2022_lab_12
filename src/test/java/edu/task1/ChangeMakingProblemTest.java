package edu.task1;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ChangeMakingProblemTest {

    @org.junit.jupiter.api.Test
    void solveException() {
        List<Integer> coinsAvailable = Arrays.asList(2, 5, 10, 20, 50, 100, 200, 500);

        // set amount to the amount to be dispensed
        int amount = 123;

        // must throw an exception
        assertThrows(CannotChangeMakeException.class, () -> ChangeMakingProblem.solve(coinsAvailable, amount));
    }

    @org.junit.jupiter.api.Test
    void solveCorrect() throws CannotChangeMakeException {
        List<Integer> coinsAvailable = Arrays.asList(2, 5, 10, 20, 50, 100, 200, 500);

        // set amount to the amount to be dispensed
        int amount = 120;

        assertArrayEquals(new Integer[]{100, 20}, ChangeMakingProblem.solve(coinsAvailable, amount).toArray());
    }

    @org.junit.jupiter.api.Test
    void solveSecondTry() throws CannotChangeMakeException {
        List<Integer> coinsAvailable = Arrays.asList(3, 2);

        int amount = 10;

        assertArrayEquals(new Integer[]{2, 2, 2, 2, 2}, ChangeMakingProblem.solve(coinsAvailable, amount).toArray());
    }

    @org.junit.jupiter.api.Test
    void solveHashMap() throws CannotChangeMakeException {
        List<Integer> coinsAvailable = Arrays.asList(3, 2);

        int amount = 10;

        assertArrayEquals(new Integer[]{2}, ChangeMakingProblem.solveHashMap(coinsAvailable, amount).keySet().toArray());
    }
}