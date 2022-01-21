package Threads;

import java.util.ArrayList;

public class Company {

    Boss boss;

    public Company(){
        boss = new Boss("Khabib Nurmagomedov");
    }

    public static void main(String[] args){
        Company company = new Company();
        company.boss.start();
    }


}
