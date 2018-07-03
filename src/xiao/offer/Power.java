package xiao.offer;

public class Power {
	public static double getPower(double base,int exponent){
		if(base==0&&exponent<=0) return -1;
		int abs=0;
		if(exponent<0) 
			 abs=-exponent;
		double result=getPowerCore(base,abs);
		
		if(exponent<0) result=1.0/result;
		
		return result;
	}
	public static double getPowerCore(double base,int exponent){
		int result=1;
		for(int i=1;i<=exponent;i++){
			result*=base;
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getPower(3,-2));
	}

}
