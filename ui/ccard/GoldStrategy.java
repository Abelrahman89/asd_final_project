package edu.mum.cs.cs525.labs.exercises.project.ui.ccard;

import edu.mum.cs.cs525.labs.exercises.project.ui.framework.interest_strategy.InterestStrategy;

public class GoldStrategy implements InterestStrategy {
    @Override
    public double getInterestPercentage() {
        return 0.06;
    }

    @Override
    public double calculateInterest(double balance) {
        return    balance * getInterestPercentage();
    }

    @Override
    public double minimumPaymentPercentage() {
        return 0.10;
    }

    @Override
    public String getStrategyType() {
        return "Gold";
    }
}
