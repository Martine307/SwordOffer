package test2;

public class PrinterABC {

	public static class ThreadPrint implements Runnable{
		private String name;
		private Object prev;
		private Object self;
		public ThreadPrint(String name, Object prev, Object self) {
			super();
			this.name = name;
			this.prev = prev;
			this.self = self;
		}
		
		public void run(){
			int count=10;
			while(count>0){
				synchronized(prev){
					synchronized(self){
						System.out.print(name);
						count--;
						self.notifyAll();
					}
					
					try {
						prev.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Object a=new Object();
		Object b=new Object();
		Object c=new Object();
		
		ThreadPrint pa=new ThreadPrint("A",c,a);
		ThreadPrint pb=new ThreadPrint("B",a,b);
		ThreadPrint pc=new ThreadPrint("C",b,c);
		
		
		new Thread(pa).start();
		new Thread(pb).start();
		new Thread(pc).start();
	}

}
