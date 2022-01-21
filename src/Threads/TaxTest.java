package Threads;

import static org.junit.jupiter.api.Assertions.*;

class TaxTest {

    @org.junit.jupiter.api.Test
    void incomeTax() {
        TaxPayer taxPayer = new TaxPayer(100000,0,0.06f,null);
        Tax tax = new Tax();
        System.out.println(tax.IncomeTax(taxPayer));


    }
}