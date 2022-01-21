package Threads;

import java.util.ArrayList;

public class Company {

    Boss boss;

    public Company(){
        boss = new Boss("Leonhard Euler");
    }

    public void PrintImployees(){
        System.out.println("Boss name : " + boss.name);
        System.out.println(boss.getListOfWorkers());
    }

    public static void main(String[] args){
        Company company = new Company();
        company.PrintImployees();
        company.boss.start();
    }


}
