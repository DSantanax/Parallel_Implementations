package Locks;

import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Item {
    //max capacity 10
    private ArrayList<Item> items = new ArrayList<>(10);

    //lock to add and remove one at a time
    private ReentrantLock lock = new ReentrantLock();
    //Condition to check if its full (Locks.Producer)
    private Condition bufferNotFull = lock.newCondition();
    //Condition to check if its empty (Locks.Consumer)
    private Condition bufferNotEmpty = lock.newCondition();

    public Item(){}

    public void produceItem() {
        lock.lock();
            try {
                while(items.size() >= 10) {
                    System.out.println("Waiting");
                    bufferNotFull.await();
                    System.out.println("Going");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        items.add(new Item());
        System.out.println("Added item!");
        //Signal consumer not empty
        bufferNotEmpty.signalAll();

        lock.unlock();
    }

    //TODO: remove one at a time

    public Item getItem() {
        Item removed = null;

        try {
            lock.lock();
            //wait if list is empty
            while (items.size() == 0) {
                bufferNotEmpty.await();
            }
            removed = items.remove(0);
            System.out.println("Locks.Item removed!");

            //TODO:signal all or signal?
            //signal before unlocking!
            bufferNotFull.signalAll();

            lock.unlock();

            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return removed;
    }
}
