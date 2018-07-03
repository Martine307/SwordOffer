package xiao.test;

/*
有三个线程T1 T2 T3，如何保证他们按顺序执行-转载
在T2的run中，调用t1.join，让t1执行完成后再让T2执行
在T2的run中，调用t2.join，让t2执行完成后再让T3执行
*/
public class ThreadByOrder {

   static Thread t1 = new Thread(new Runnable() {

       @Override
       public void run() {
           System.out.println("t1");
       }
   });

   static Thread t2 = new Thread(new Runnable() {

       @Override
       public void run() {
           try {
               t1.join();
              // Thread.sleep(500);
           } catch (InterruptedException e) {
               // TODO Auto-generated catch block
               e.printStackTrace();
           }
           System.out.println("t2");
       }
   });

   static Thread t3 = new Thread(new Runnable() {

       @Override
       public void run() {
           try {
               t2.join();
               //Thread.sleep(500);
           } catch (InterruptedException e) {
               // TODO Auto-generated catch block
               e.printStackTrace();
           }
           System.out.println("t3");
       }
   });
   public static void main(String[] args) {
      
       t2.start();
       t3.start();
       t1.start();
   }

}