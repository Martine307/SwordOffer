package questions;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {
	BlockingQueue<String> queue;
	
	public Producer(BlockingQueue<String> queue) {
		super();
		this.queue = queue;
	}

	 public void run(){
		try {
			String temp="produceœﬂ≥Ã"+Thread.currentThread().getName();
			System.out.println("I have made a product"+Thread.currentThread().getName());
			queue.put(temp);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
