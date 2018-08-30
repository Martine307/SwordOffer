package test3;

import java.util.concurrent.TimeUnit;

public class ConThread {

	public static void main(String args[]){
		
		new Thread(){
			public void run(){
				look();
			}
		}.start();
		
		listen();
	}
	public static void look(){
		for(;;){
			System.out.println("look");
			sleep(1);
		}
		
	}
	public static void listen(){
		for(;;){
		System.out.println("listen");
		sleep(1);
		}
	}
	public static void sleep(int sec){
		try{
			TimeUnit.SECONDS.sleep(sec);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
}
