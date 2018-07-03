package xiao.offer;
//https://blog.csdn.net/nsw911439370/article/details/50456231 
/**
 * 1.线程不安全懒汉模式
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
 * 线程安全的懒汉模式
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
 * 饿汉模式,这种方法没有起到lazy loading的效果
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
 * 静态内部类,线程安全
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
 * 双重校验锁,线程安全
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
