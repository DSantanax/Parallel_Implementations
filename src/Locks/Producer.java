package Locks;

public class Producer implements Runnable{

    Item item;

    public Producer(Item item){
        this.item = item;
    }

    @Override
    public void run() {
        System.out.println("Hello Locks.Producer");
        //each consumer produces 100
        for(int i = 0; i < 100; i++){
            item.produceItem();
        }
        System.out.println("Locks.Producer Done!");
    }
}