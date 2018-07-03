package xiao.test;

/*
�������߳�T1 T2 T3����α�֤���ǰ�˳��ִ��-ת��
��T2��run�У�����t1.join����t1ִ����ɺ�����T2ִ��
��T2��run�У�����t2.join����t2ִ����ɺ�����T3ִ��
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