package xiao.offer;
//https://blog.csdn.net/nsw911439370/article/details/50456231 
/**
 * 1.�̲߳���ȫ����ģʽ
 * @return
 */
/*public class Singleton {
	
	private Singleton(){}
	
	private static Singleton instance=null;
	
	
	public static Singleton getInstance(){
		if(instance==null){
			instance=new Singleton();
			
		}
		return instance;
	}
	
	
	

}*/


/**
 * �̰߳�ȫ������ģʽ
 * @return
 */

/*public class Singleton {
	
	private Singleton(){}
	
	private static Singleton instance=null;
	
	
	public static synchronized Singleton getInstance(){
		if(instance==null){
			instance=new Singleton();
			
		}
		return instance;
	}

	
	

}*/

/**
 * ����ģʽ,���ַ���û����lazy loading��Ч��
 * @return
 */

/*public class Singleton {
	
	private Singleton(){}
	
	private static Singleton instance= new Singleton();
	public static synchronized Singleton getInstance(){
		return instance;
	}

}*/


/**
 * ��̬�ڲ���,�̰߳�ȫ
 * @return
 *//*

public class Singleton {
	
	private Singleton(){}
	private static class InnerClass{
		private static Singleton instance= new Singleton();
	}
	
	public static synchronized Singleton getInstance(){
		return InnerClass.instance;
	}

}*/


/**
 * ˫��У����,�̰߳�ȫ
 * @return
 */

public class Singleton {
	
	private Singleton(){}
	
	private static volatile Singleton instance;
	
	
	public static Singleton getInstance(){
		if(instance==null){
			synchronized(Singleton.class){
				if(instance==null){
					instance= new Singleton();
				}
			}
		}
		return instance;
	}

}
