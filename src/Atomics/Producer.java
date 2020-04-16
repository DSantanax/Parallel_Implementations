package Atomics;


public class Producer implements Runnable{

    Item item;
    int produce;

    public Producer(Item item, int production){
        this.item = item;
        this.produce = production;
    }

    @Override
    public void run() {
        System.out.println("Producer Running!");
        //each produces 100
        for(int i = 0; i < produce; i++)
            item.addItem();

        System.out.println("Producer Done!");
    }
}