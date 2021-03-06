package IsolatedSections;
/*
    TODO: Move Consumer, producer, PC to other package to run
 */

public class ProducerConsumerSystem {

    public ProducerConsumerSystem(){}

    public void PC() {
        //Vary the producer & consumer
        int producers = 2;
        int consumers = 5;
        //each producer produces 100 items
        int totalProduction = producers*100;
        Item isoLocks = new Item();

        createPCSystem(producers, consumers, totalProduction, isoLocks);
    }

    private static void createPCSystem(int producers, int consumers, int totalProduction, Item typeItem) {
        //TODO: consume until there is no more (dont use each)
        int each = (totalProduction/consumers);
        //create X producers threads
        for(int i = 0; i < producers; i++){
            new Thread(new Producer(typeItem)).start();
        }
        //create Y consumers threads
        for(int i = 0; i <consumers; i++)
            new Thread(new Consumer(typeItem, each)).start();
    }
}
