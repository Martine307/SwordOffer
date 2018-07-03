package xiao.test;
//一个死锁的例子
public class TestDeadLock implements Runnable {
	
	private static Object lock1=new Object();
	private static Object lock2=new Object();
	
	private boolean flag;
	TestDeadLock(boolean flag){
		this.flag=flag;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread t1=new Thread(new TestDeadLock(true));
		Thread t2=new Thread(new TestDeadLock(false));
		t1.start();
		t2.start();
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		if(flag){
			synchronized (lock1) {
				System.out.println("t1 get lock1");
				synchronized (lock2) {
					System.out.println("t1 get lock2");
				}
			}
		}else{
			synchronized (lock2) {
				System.out.println("t2 get lock2");
				synchronized (lock1) {
					System.out.println("t2 get lock1");
				}
			}
		}
		
	}

}
