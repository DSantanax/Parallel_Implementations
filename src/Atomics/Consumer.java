package Atomics;

public class Consumer implements Runnable {

    private Item items;
    private int each;

    public Consumer(Item item, int each){
        this.items = item;
        this.each = each;
    }

    @Override
    public void run(){
            System.out.println("Consumer Running");
        for(int i = 0; i < each; i++) {
            //sleep 1 second for consumption
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(items.getItem());
        }
        System.out.println("Consumer Done");
    }
}