package Threads;

public class TaxPayer {
    /* A unit which has an income, savings. */
    private double income;
    private double savings;
    private float pensionRate;
    private float zikuiPoints;

    public TaxPayer(double income, double savings, float pensionRate, float zikuiPoints){
        this.income = income; this.savings = savings; this.pensionRate = pensionRate;this.zikuiPoints = zikuiPoints;
    }

    public TaxPayer(double income, double savings, float pensionRate){
        this.income = income; this.savings = savings; this.pensionRate = pensionRate;this.zikuiPoints = 2.25f;
    }

    public float getPensionRate() {
        return pensionRate;
    }

//    public void setPensionRate(float pensionRate) {
//        this.pensionRate = pensionRate;
//    }

    public void setPensionRate(float pensionRate) {
        this.pensionRate = pensionRate;
    }

    public float getZikuiPoints() {
        return zikuiPoints;
    }

    public void setZikuiPoints(float zikuiPoints) {
        this.zikuiPoints = zikuiPoints;
    }

    public double getIncome() {
        return income;
    }
//
//    public void setIncome(double income) {
//        this.income = income;
//    }

    public double getSavings() {
        return savings;
    }

//    public void setSavings(double savings) {
//        this.savings = savings;
//    }
}
