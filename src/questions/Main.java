package questions;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BlockingQueue<String> queue=new LinkedBlockingQueue(2);
		Consumer consumer=new Consumer(queue);
		Producer producer=new Producer(queue);
		
		for(int i=0;i<5;i++){
		new Thread(producer,"producer"+(i+1)).start();
		
		new Thread(consumer,"consumer"+(i+1)).start();
		}
	}

}
