package Threads;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Boss {
    String name;
    ArrayList<Worker> workers;
    ArrayList<TaxPayer> pile;
    public Boss(String name){
        this.name = name;
        this.workers = new ArrayList<>();
        this.workers.add(new Worker(new TaxPayer(600000,0,0.06f,null),"Kylie Hemilton"));
        this.workers.add(new Worker(new TaxPayer(600000,0,0.06f,null),"David A.Huffman"));
        this.pile = TaxPayer.Generate_TaxPayers("input.json");
        System.out.println("[Boss] All Ready!");
    }
    public static void SCREAM_AT_WORKERS(){
        System.out.println("[Boss] START WORKING!");
    }
    // dummy algorithm tries to give equal amount to each worker
    private void Give_Piles_To_Workers(){
        int num = workers.size();
        ArrayList<TaxPayer> pile_for_worker ;
        Iterator iterator = this.pile.iterator();
        for (int i = 0; i < num; i++) {
            pile_for_worker = new ArrayList<>();
            for (int j = 0; j < pile.size()/num && iterator.hasNext(); j++) {
                pile_for_worker.add((TaxPayer) iterator.next());
            }
            workers.get(i).add_Work(pile_for_worker);
        }
    }
    public void start(){
        Give_Piles_To_Workers();
        Iterator iter_worker = workers.iterator();
        SCREAM_AT_WORKERS();
        while(iter_worker.hasNext()){
            ((Worker)iter_worker.next()).startWorking();
        }
    }
    public String getListOfWorkers(){
        String toStrings =  "Names Of Workers: \n";
        Iterator iterator = this.workers.iterator();
        while(iterator.hasNext()){
            toStrings += ((Worker)iterator.next()).name + "\n";
        }
        return toStrings;
    }
}
