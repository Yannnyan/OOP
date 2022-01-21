package Threads;

public interface TaxInterface {


    /*
        A tax is defined as compulsory financial charge or some other type of levy imposed on a taxpayer.
        Given a taxpayer calculate its amount of tax.
     */

    /* This interface mainly defines what taxes could be taxed. Based on the taxes in Israel */


    double IncomeTax(TaxPayer taxPayer);
    double BituahLeomi(TaxPayer taxPayer);
    double PurchaseTax(TaxPayer taxPayer, double buyAmount);
    double ValueAddedTax(TaxPayer taxPayer,double dealAmount);

    double zikuiPointToShekels(TaxPayer taxPayer);
    double pensionCompansationToShekels(TaxPayer taxPayer);

}
