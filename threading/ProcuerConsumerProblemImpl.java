import java.util.concurrent.*;

class ProcuerConsumerProblemImpl {
	
	
	private static final BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(5);
	
	public static void main(String[] args) {
	
	ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.submit(new ProducerThread());
        executor.submit(new ConsumerThread());

        executor.shutdown();
	}
	
	static class ProducerThread implements Runnable {
	
	public void run() {
            try {
                int count = 0;
                while (true) {
                    System.out.println("Producing: " + count);
                    queue.put(count++); // blocks if queue is full
                    Thread.sleep(500); // simulate production time
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
}


	static class ConsumerThread implements Runnable {
	
	public void run() {
            try {
                while (true) {
                    Integer item = queue.take(); // blocks if queue is empty
                    System.out.println("Consuming: " + item);
                    Thread.sleep(1000); // simulate processing time
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
}
}


