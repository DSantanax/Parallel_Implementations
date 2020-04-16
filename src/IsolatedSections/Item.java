package IsolatedSections;

import java.util.ArrayList;

public class Item {
    //max capacity 10
    private ArrayList<Item> items = new ArrayList<>(10);
    private final Object lock1 = new Object();

    public Item() { }

    public void produceItem() {
        synchronized (lock1) {
            while (items.size() >= 10) {
                System.out.println("Waiting");
                try {
                    lock1.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Going");
            }
            items.add(new Item());
            System.out.println("Added item!");
            lock1.notifyAll();
        }
    }

    //TODO: remove one at a time
    public Item getItem() {
        synchronized (lock1) {
            Item removed = null;
            try {
                //wait if list is empty
                while (items.size() == 0) {
                    System.out.println("Waiting for emptiness");
                    lock1.wait();
                }
                removed = items.remove(0);
                System.out.println("Item removed!");
                lock1.notifyAll();

                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return removed;
        }
    }
}