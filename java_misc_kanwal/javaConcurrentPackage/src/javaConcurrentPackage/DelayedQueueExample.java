package javaConcurrentPackage;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelayedQueueExample {

	public static void main(String[] args) throws InterruptedException {

	final BlockingQueue<DelayedElement> q = new DelayQueue<DelayedElement>();
	DelayQueueProducer queueProducer = new DelayQueueProducer(q);
	new Thread(queueProducer).start();
	
	DelayQueueConsumer queueConsumer = new DelayQueueConsumer(q);
	new Thread(queueConsumer).start();
	
	
	DelayQueueConsumer queueConsumer1 = new DelayQueueConsumer(q);
	new Thread(queueConsumer1).start();
	}

}

class DelayedElement implements Delayed{

	
	private String element;
	
	private long expiryDate;
	
	
	public DelayedElement(String element, long expiryDate) {
		super();
		this.element = element;
		this.expiryDate =System.currentTimeMillis()+ expiryDate;
	}

	public int compareTo(Delayed o) {
		if(this.expiryDate<((DelayedElement)o).expiryDate){
			return -1;
		}
		if(this.expiryDate>((DelayedElement)o).expiryDate){
			return 1;
		}
		return 0;
	}
	
	@Override
	public String toString() {
		return element + ": " + expiryDate;
	}

	public long getDelay(TimeUnit unit) {
		long diff = expiryDate - System.currentTimeMillis();
		return unit.convert(diff, TimeUnit.MILLISECONDS);
	}
	
}




class DelayQueueProducer implements Runnable{

	
	protected BlockingQueue<DelayedElement> blockingQueue;
	final Random random = new Random();

	public DelayQueueProducer(BlockingQueue<DelayedElement> queue) {
		this.blockingQueue = queue;
	}
	public void run() {
		while (true) {
			try {
				int delay = random.nextInt(10000);
				DelayedElement delayElement = new DelayedElement(UUID.randomUUID()
						.toString(), delay);
				System.out.println("Put: "+ delayElement);
				blockingQueue.put(delayElement);
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
}

 class DelayQueueConsumer implements Runnable {

	protected BlockingQueue<DelayedElement> blockingQueue;

	public DelayQueueConsumer(BlockingQueue<DelayedElement> queue) {
		this.blockingQueue = queue;
	}


	public void run() {
		while (true) {
			try {
				DelayedElement delayElement = blockingQueue.take();
				System.out.println(Thread.currentThread().getName()
						+ " take(): " + delayElement);
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
