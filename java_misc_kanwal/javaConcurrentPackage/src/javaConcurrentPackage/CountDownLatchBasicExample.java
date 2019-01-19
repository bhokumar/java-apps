package javaConcurrentPackage;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchBasicExample {

	public static void main(String[] args) {
	CountDownLatch latch = new CountDownLatch(3);
	Waiter waiter = new Waiter(latch);
	Decrementer decrementer = new Decrementer(latch);
	new Thread(waiter).start();
	
	new Thread(decrementer).start();
	}
}
	
	class Waiter implements Runnable {

		public void run() {
			try{
				System.out.println("Waiter acquired");
				latch.await();
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			System.out.println("Waiter released");
		}
		CountDownLatch latch = null;
		public Waiter(CountDownLatch latch) {
			super();
			this.latch = latch;
		}
		
		
	}
	
	class Decrementer implements Runnable{

		
		CountDownLatch latch = null;
		public Decrementer(CountDownLatch latch) {
			super();
			this.latch = latch;
		}
		
		public void run() {
			try{
				System.out.println("Inside Decrementer acquired");
				Thread.sleep(1000);
				this.latch.countDown();
				 Thread.sleep(1000);
		            this.latch.countDown();
		            Thread.sleep(1000);
		            this.latch.countDown();
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			
		}
		
	}


