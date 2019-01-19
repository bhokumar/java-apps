package javaConcurrentPackage;

import java.util.concurrent.Exchanger;

public class ExchangerBasicExample {

	public static void main(String[] args) {
		Exchanger exchanger = new Exchanger();
		ExchangeRunnable exchangeRunnable1 = new ExchangeRunnable(exchanger, "A");
		ExchangeRunnable exchangeRunnable2 = new ExchangeRunnable(exchanger, "B");
			new Thread(exchangeRunnable1).start();
			new Thread(exchangeRunnable2).start();
	}

}

class ExchangeRunnable implements Runnable{

	Exchanger exchanger = null;
	Object object = null;
	
	
	public ExchangeRunnable(Exchanger exchanger, Object object) {
		super();
		this.exchanger = exchanger;
		this.object = object;
	}

	
	

	@Override
	public void run() {
	try{
		Object previous = this.object;
		this.object = this.exchanger.exchange(this.object);
		System.out.println(Thread.currentThread().getName()+"exchannged"+previous+" for "+this.object);
	}catch(InterruptedException e){
		e.printStackTrace();
	}
		
	}
	
}
