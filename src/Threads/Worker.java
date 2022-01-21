package Threads;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.Stack;

public class Worker extends Thread{
    Tax taxes;
    String name;
    TaxPayer taxPayer;
    Stack pile_of_work; /* A Stack of tackPayers*/
    public Worker(TaxPayer taxPayer, String name){
        this.taxPayer = taxPayer;
        this.taxes = new Tax();
        this.name = name;
        pile_of_work = new Stack();
    }
    public void add_Work(Collection work){
        Iterator iter = work.iterator();
        while(iter.hasNext())
            this.pile_of_work.push(iter.next());
    }

    public Stack getPile_of_work() {
        return pile_of_work;
    }

    public void setPile_of_work(Stack pile_of_work) {
        this.pile_of_work = pile_of_work;
    }
    @Override
    public void run(){
        /*It takes a worker at least 1 second to calculate the Taxes per taxPayer */
        TaxPayer taxPayer1;
        File file = new File("output.txt");
        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter(file);
        }
        catch (IOException e){
            System.out.println("No file Found");
            return;
        }
        while(!this.pile_of_work.isEmpty()){
            taxPayer1 = (TaxPayer) pile_of_work.pop();
            try {
                sleep(1000);
            }
            catch(InterruptedException e){
                System.out.println("Yes boss . . .");
                try {
                    fileWriter.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                return;
            }
            double tax_for_taxPayer = this.taxes.IncomeTax(taxPayer1);
            try {
                fileWriter.append("Tax Payer : " + taxPayer1.getName() + " need to pay : " + tax_for_taxPayer + "\n");
                System.out.println("[Worker] " + this.name + " wrote to output.txt");
            }
            catch (IOException e){
                System.out.println("Cannot append to the file.");
            }
        }
        try {
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void startWorking(){
        this.run();
    }
}

