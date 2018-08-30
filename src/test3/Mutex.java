package test3;

import java.util.concurrent.TimeUnit;

public class Mutex {
	private final static Object MUTEX=new Object();
	public void ac(){
		synchronized(MUTEX){
			try{
				TimeUnit.MINUTES.sleep(10);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final Mutex mutex=new Mutex();
		for(int i=0;i<5;i++){
			new Thread(mutex::ac).start();
		}
	}

}
