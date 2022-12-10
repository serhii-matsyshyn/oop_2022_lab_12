package edu.task1;

import java.util.ArrayList;
import java.util.List;

class CannotChangeMakeException extends Exception {
    public CannotChangeMakeException(String message) {
        super(message);
    }
}

public class UniversalChain implements Chain {

    private Chain chain;
    private final int nominal;

    public UniversalChain(int nominal) {
        this.nominal = nominal;
    }

    @Override
    public void setNextChain(Chain nextChain) {
        this.chain = nextChain;
    }

    @Override
    public List<Integer> dispense(Amount cur) throws CannotChangeMakeException {
        List<Integer> result = new ArrayList<>();
        if (cur.getAmount() >= nominal) {
            try {
                int num = cur.getAmount() / nominal;
                int remainder = cur.getAmount() % nominal;

                // add the number of coins to the result
                for (int i = 0; i < num; i++) {
                    result.add(nominal);
                }

                if (remainder != 0) {
                    result.addAll(chainDispense(new Amount(remainder)));
                }
            } catch (CannotChangeMakeException e) {
                result.clear();
                result.addAll(chainDispense(cur));
            }
        } else {
            result.addAll(chainDispense(cur));
        }
        return result;
    }

    @Override
    public List<Integer> chainDispense(Amount cur) throws CannotChangeMakeException {
        if (this.chain != null) {
            return this.chain.dispense(cur);
        }
        throw new CannotChangeMakeException("Cannot change make");
    }
}