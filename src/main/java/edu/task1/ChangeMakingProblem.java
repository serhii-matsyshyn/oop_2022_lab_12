package edu.task1;

import java.util.HashMap;
import java.util.List;

public class ChangeMakingProblem {
    public static List<Integer> solve(List<Integer> coinsAvailable, int amount) throws CannotChangeMakeException {
        // sort coinsAvailable in descending order
        coinsAvailable.sort((a, b) -> b - a);

        // use UniversalChain to dispense the coins
        Chain firstChain = new UniversalChain(coinsAvailable.get(0));

        Chain chain = firstChain;
        for (int i = 1; i < coinsAvailable.size(); i++) {
            Chain nextChain = new UniversalChain(coinsAvailable.get(i));
            chain.setNextChain(nextChain);
            chain = nextChain;
        }

        return firstChain.dispense(new Amount(amount));

    }

    public static HashMap<Integer, Integer> solveHashMap(List<Integer> coinsAvailable, int amount) throws CannotChangeMakeException {
        List<Integer> coins = solve(coinsAvailable, amount);

        // convert the result to the hash map if needed
        HashMap<Integer, Integer> coinsMap = new HashMap<>();
        for (int coin : coins) {
            if (coinsMap.containsKey(coin)) {
                coinsMap.put(coin, coinsMap.get(coin) + 1);
            } else {
                coinsMap.put(coin, 1);
            }
        }
        return coinsMap;
    }
}
