package xiao.offer;

public class CutRope {
	public static int getMax(int length){
		
		if(length<2) return 0;
		if(length==2) return 1;
		if(length==3) return 2;
		int products[]=new int[length+1];
		products[0]=0;
		products[1]=1;
		products[2]=2;
		int max=0;
		for(int i=3;i<=length;i++){
			 max=0;
			for(int j=1;j<=i/2;j++){
				int pro=products[j]*products[i-j];
				if(max<pro) max=pro;
				products[i]=max;
			}
		}
		max=products[length];
		return max;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getMax(4));
	}

}
