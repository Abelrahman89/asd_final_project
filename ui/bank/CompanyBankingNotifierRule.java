package edu.mum.cs.cs525.labs.exercises.project.ui.bank;

import edu.mum.cs.cs525.labs.exercises.project.ui.framework.Transaction;
import edu.mum.cs.cs525.labs.exercises.project.ui.framework.notification.Rule;

public class CompanyBankingNotifierRule implements Rule<Transaction> {
    @Override
    public boolean isSatisfied(Transaction object) {
        return object != null && object.getAmount() > 0;
    }
}
