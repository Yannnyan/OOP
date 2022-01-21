package Threads;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

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

    public TaxPayer(String jsonObject){
        /* example: {"name": "mwEjU","income": "843516","savings": "5720136"} */


    }
    public static ArrayList<TaxPayer> Generate_TaxPayers(String jsonObject){
        Generate_TaxPayer_Json.generate_input(5);
        Gson gson = new Gson();
        File file = new File(jsonObject);
        ArrayList<TaxPayer> taxPayers = new ArrayList<>();
        try {
            FileReader reader = new FileReader(file);
            Type collectionType = new TypeToken<ArrayList<TaxPayer>>(){}.getType();
            taxPayers = gson.fromJson(reader, collectionType);
        }
        catch (IOException e){
            System.out.println("Cant read");
        }
        return taxPayers;
    }
    public static void main(String[] args){
        //String obj = "{\"name\": \"mwEjU\",\"income\": \"843516\",\"savings\": \"5720136\"}";
       //TaxPayer taxPayer = new TaxPayer();
        ArrayList taxPayers = Generate_TaxPayers("input.json");
        Iterator iterator = taxPayers.iterator();
        while(iterator.hasNext()) {
            System.out.println(((TaxPayer)iterator.next()).toString());
        }
    }
    public String toString(){
        String format = this.name + " " + this.income + " " + this.savings;
        return format;
    }














    ////////////////////// Getters and setters ///////////////

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPensionRate() {
        return pensionRate;
    }

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

    public void setIncome(double income) {
        this.income = income;
    }

    public double getSavings() {
        return savings;
    }

    public void setSavings(double savings) {
        this.savings = savings;
    }
}
