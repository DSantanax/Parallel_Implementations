package IsolatedSections;

public class Consumer implements Runnable {

    private Item items;
    private int each;

    public Consumer(Item item, int each){
        this.items = item;
        this.each = each;
    }

    @Override
    public void run(){
            System.out.println("Hello Locks.Consumer");
        for(int i = 0; i < each; i++)
            System.out.println(items.getItem());
    }
}