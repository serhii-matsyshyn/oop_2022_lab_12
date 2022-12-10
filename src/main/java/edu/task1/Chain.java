package edu.task1;

import java.util.List;

public interface Chain {
    void setNextChain(Chain nextChain);

    List<Integer> dispense(Amount cur) throws CannotChangeMakeException;

    List<Integer> chainDispense(Amount cur) throws CannotChangeMakeException;
}

