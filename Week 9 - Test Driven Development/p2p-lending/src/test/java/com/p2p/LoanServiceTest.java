package com.p2p;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.math.BigDecimal;

import com.p2p.domain.Borrower;
import com.p2p.domain.Loan;
import com.p2p.service.LoanService;

public class LoanServiceTest {

    @Test
    void shouldRejectLoanWhenBorrowerNotVerified() {
        Borrower borrower = new Borrower(false, 700);
        LoanService loanService = new LoanService();
        BigDecimal amount = BigDecimal.valueOf(1000);

        assertThrows(IllegalArgumentException.class, () -> {
            loanService.createLoan(borrower, amount);
        });
    }

    @Test
    void shouldRejectLoanWhenAmountIsZeroOrNegative() {

        Borrower borrower = new Borrower(true, 700);
        LoanService loanService = new LoanService();

        BigDecimal amount = BigDecimal.valueOf(0); // atau -100

        assertThrows(IllegalArgumentException.class, () -> {
            loanService.createLoan(borrower, amount);
        });
    }

    @Test
    void shouldApproveLoanWhenCreditScoreIsHigh() {

        Borrower borrower = new Borrower(true, 700); // verified & score tinggi
        LoanService loanService = new LoanService();
        BigDecimal amount = BigDecimal.valueOf(1000);

        var loan = loanService.createLoan(borrower, amount);

        assertEquals(Loan.Status.APPROVED, loan.getStatus());
    }

    @Test
    void shouldRejectLoanWhenCreditScoreIsLow() {

        Borrower borrower = new Borrower(true, 500); // verified tapi score rendah
        LoanService loanService = new LoanService();
        BigDecimal amount = BigDecimal.valueOf(1000);

        var loan = loanService.createLoan(borrower, amount);

        assertEquals(Loan.Status.REJECTED, loan.getStatus());
    }
}

