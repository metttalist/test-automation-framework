package com.igor.khorev.qa.utility;

import java.util.ArrayList;
import java.util.List;


/**
 * This class is used to collect all failures that occurred during test execution using soft assertions.
 *
 * @author igor.khorev
 */
public class SoftAssertChain {

    private List<Throwable> failures;

    public SoftAssertChain() {
        failures = new ArrayList<>();
    }

    /**
     * Adds a failure to the list.
     *
     * @param failure
     */
    public void addFailure(Throwable failure){
        failures.add(failure);
    }

    /**
     * Returns all failures from the list.
     *
     * @return
     */
    public List<Throwable> getFailures(){
        return this.failures;
    }

    /**
     * Resets the list of failures.
     */
    public void reset(){
        failures.clear();
    }
}
