public class MainDriver {
    public static void main(String[] args) {

        IsolatedSections.ProducerConsumerSystem IsoPC = new IsolatedSections.ProducerConsumerSystem();
        IsoPC.PC();

        Locks.ProducerConsumerSystem locksPC = new Locks.ProducerConsumerSystem();
        locksPC.PC();


        Atomics.ProducerConsumerSystem atomicPC = new Atomics.ProducerConsumerSystem();
        atomicPC.PC();

    }
}
