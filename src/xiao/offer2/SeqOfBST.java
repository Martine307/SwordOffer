package xiao.offer2;

public class SeqOfBST {
	
	public boolean verifyCore(int array[],int start,int finish){
		
		if(start>=finish) return true;
		int root=array[finish];
		
		int i=0;
		for(;i<finish;i++){
			if(array[i]>root)
				break;
		}
		
		int j=i;
		for(;j<finish;j++){
			if(array[j]<root)
				return false;
		}
		
		return verifyCore(array,0,i-1)&&verifyCore(array,i,finish-1);
		
	}
	
	public boolean verify(int array[],int length){
		if(array==null||length<=0) return false;
		
		return verifyCore(array,0,length-1);
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[]={5,7,6,9,11,10,8};
		boolean l=new SeqOfBST().verify(a,7);
		System.out.println(l);
	}

}
