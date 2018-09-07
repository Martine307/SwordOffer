package xiao.test;


 class SuperClass{
	public void a(){
		System.out.println("a");
	}
	static{
		System.out.println("super");
	}
	public static int value=123;
}
 class SubClass extends SuperClass{
	static{
		System.out.println("sub");
	}
	public void a(){
		System.out.println("b");
	}
	public static int value=1234;
	
}

public class ClassLoading {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(SubClass.value);
		//new SuperClass().a();
		/*SuperClass s=new SubClass();
		s.a();*/
	}

}
