package xiao.offer;


/**
 * @author XM
 *3���������ظ�������
 *˼·��
 *1.��������nlogn���ڱ���
 *2.hash�� ���� n  �ռ�n
 *3.�±��ֵ�Ƿ���� n
 */
public class DuplicateArray {
   
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        if(numbers==null||length<=0) return false;
        for(int i=0;i<length;i++){
            if(numbers[i]<0||numbers[i]>=length) return false;
        }
        int count=0;
        for(int j=0;j<length;j++){
            while(numbers[j]!=j){
                if(numbers[j]==numbers[numbers[j]]){
                    duplication[count++]=numbers[j];
                    return true;
                }
                
                int temp=numbers[j];
                numbers[j]=numbers[temp];
                numbers[temp]=temp;
                
            }
            
            
        }
        return false;
        
    }
    public static void main(String[] args) {
		// TODO Auto-generated method stub
    	int a[]={2,3,1,0,2,9,3};
    	int duplication[]=new int[a.length];
    	boolean flag=new DuplicateArray().duplicate(a, a.length, duplication);
    	System.out.println(flag);
	}

}


	

