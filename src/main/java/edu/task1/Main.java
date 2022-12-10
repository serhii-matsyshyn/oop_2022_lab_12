package edu.task1;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // set coinsAvailable to the list of coins available
        List<Integer> coinsAvailable = Arrays.asList(3,2);

        // set amount to the amount to be dispensed
        int amount = 10;

        try {
            // solve the problem
            List<Integer> coins = ChangeMakingProblem.solve(coinsAvailable, amount);

            System.out.println("=== Result ===");

            // print the result
            System.out.println("Coins list to dispense: " + coins);

            // print the sum of the coins
            System.out.println("Sum of the coins: " + coins.stream().mapToInt(Integer::intValue).sum());

            // print the number of coins
            System.out.println("Number of coins: " + coins.size());
        } catch (CannotChangeMakeException e) {
            System.out.println(e.getMessage());
        }
    }
}
