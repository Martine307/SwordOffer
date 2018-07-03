package questions;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {
	BlockingQueue<String> queue;

	public Consumer(BlockingQueue<String> queue) {
		super();
		this.queue = queue;
	}
	public void run(){
		try {
			String temp=queue.take();
			System.out.println(temp);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
