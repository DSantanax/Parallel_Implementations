package Atomics;

import java.util.concurrent.atomic.AtomicReferenceArray;

public class Item {

    private AtomicReferenceArray<Item> itemArray = new AtomicReferenceArray<>(10);

    public Item() { }


    //TODO: i must be incremented to present the size 10
    // AtomicInteger?

    // Try adding to each until its added then return
    public void addItem() {
        for(;;)
        for (int i = 0; i < itemArray.length(); i++) {
            if (itemArray.compareAndSet(i, null, new Item())) {
                System.out.println("Added item");
                return;
            }
        }
    }

    public Item getItem() {
        Item item;
        for(int i = 0; i < itemArray.length(); i++) {
            if ((item = itemArray.getAndSet(i, null)) != null){
               return item;
            }
        }
        return null;
    }
}
