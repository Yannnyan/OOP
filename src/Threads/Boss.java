package Threads;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Boss {
    String name;
    ArrayList<Worker> workers;
    ArrayList<ArrayList<TaxPayer>> work_piles;
    public Boss(String name){
        this.name = name;
        this.workers = new ArrayList<>();
        this.workers.add(new Worker(new TaxPayer(600000,0,0.06f,null),"Json"));
        work_piles = new ArrayList();

    }
    private void Parse_input_to_work_piles(){
        ArrayList<TaxPayer> pile = new ArrayList<>();
        pile.add(new TaxPayer(100000,0,0.06f, "Connor Mcgregor"));
        pile.add(new TaxPayer(200000,100,0.06f, "Dana White"));
        this.work_piles.add(pile);
    }
    public void start(){
        this.Parse_input_to_work_piles();
        Iterator iter_worker = workers.iterator(), iter_work_piles = work_piles.iterator();
        while(iter_worker.hasNext())
            ( (Worker) iter_worker.next() ).add_Work( (Collection) iter_work_piles.next());
        iter_worker = workers.iterator();

        while(iter_worker.hasNext()){
            ((Worker)iter_worker.next()).startWorking();
        }
    }
}
