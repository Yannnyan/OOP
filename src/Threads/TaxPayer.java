package Threads;

public class TaxPayer {
    /* A unit which has an income, savings. */
    private double income;
    private double savings;
    private float pensionRate;
    private float zikuiPoints;
    private String name;

    public TaxPayer(){
        this.income = 0;
        this.savings = 0;
        this.pensionRate = 0;
        this.zikuiPoints = 0;
    }

    public TaxPayer(double income, double savings, float pensionRate, float zikuiPoints, String name){
        this.income = income; this.savings = savings; this.pensionRate = pensionRate;this.zikuiPoints = zikuiPoints;
    }

    public TaxPayer(double income, double savings, float pensionRate, String name){
        this.income = income; this.savings = savings; this.pensionRate = pensionRate;this.zikuiPoints = 2.25f;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
