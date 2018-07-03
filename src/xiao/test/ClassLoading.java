package xiao.test;


 class SuperClass{
	static{
		System.out.println("super");
	}
	public static int value=123;
}
 class SubClass extends SuperClass{
	static{
		System.out.println("sub");
	}
	
}

public class ClassLoading {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(SubClass.value);
	}

}
