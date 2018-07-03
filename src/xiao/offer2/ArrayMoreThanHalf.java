package xiao.offer2;

public class ArrayMoreThanHalf {
	/*
	 ���ǵ��㷨���ܿ���������㷨�����������������������㷨�У��������������������ѡ��һ�����֣�
	 Ȼ������������ֵ�˳��ʹ�ñ�ѡ�е�����С��������������ߣ���ѡ�е����ִ�����ֶ����������ұߡ�
	 �������ѡ�е����ֵ��±�պ���n/2����ô������־��������е���λ������������±����n/2��
	 ��ô��λ��Ӧ��λ��������ߣ����ǿ��Խ�����������߲��ֵ������в��ҡ�
	 ��������±�С��n/2����ô��λ��Ӧ���������ұߣ����ǿ��Խ����������ұ߲����в��ҡ�
	 */
	public int getPivot(int array[],int low,int high){
		int left=low;
		int right=high;
		int pivot_item=array[left];
		
		while(left<right){
			
			while(left<right&&array[right]>=pivot_item) right--;
			if(left<right){
				int temp=array[left];
				array[left] = array[right];     
				array[right]=temp;
			}
			
			while(left<right&&array[left]<pivot_item) left++;
			
			if(left<right){
				int temp=array[left];
				array[left] = array[right];   
				array[right]=temp;
			}
		}
		return right;
	}
	public int moreThanHalf(int arr[]){
		 if(arr.length ==0||arr==null)  
	            return -1;  
	          
        int length = arr.length;  
        int middle = length >>1;  
        int start = 0;  
        int end = length -1;  
        int index = getPivot(arr,start,end);  
        while(index != middle){  
            if(index >middle){  
                end = index - 1;  
                index = getPivot(arr,start,end);  
            }  
            else{  
                start = index + 1;  
                index = getPivot(arr,start,end);  
            }  
        }
	          
	    int result = arr[middle];  
	    if(!checkMoreThanHalf(arr,result)){  
            result = -1;  
        }
		return result;
	}
	
	//��֤�Ƿ����  
    public boolean checkMoreThanHalf(int[] arr,int number){  
        int times = 0;  
        for(int i = 0;i<arr.length;i++){  
            if(arr[i] == number)  
                times ++;  
        }  
        boolean isMoreThanHalf = true;  
        if(times *2 <= arr.length){  
            isMoreThanHalf = false;  
        }  
        return isMoreThanHalf;  
    }  
    
    
    
  //�ⷨ����
   /* ��������һ�����ֳ��ֵĴ����������鳤�ȵ�һ�룬Ҳ����˵�����ֵĴ����������������ֳ��ֵĴ����ĺͻ�Ҫ�ࡣ
    ������ǿ��Ա��������ʱ�򱣴�����ֵ��һ���������е�һ�����֣�һ���Ǵ����������Ǳ�������һ�����ֵ�ʱ��
    �����һ�����ֺ�����֮ǰ�����������ͬ���������1�������һ�����ֺ�����֮ǰ��������ֲ�ͬ���������1.
    �������Ϊ0��������Ҫ������һ�����֣����Ѵ�����Ϊ1.��������Ҫ�ҵ����ֳ��ֵĴ����������������ֳ��ֵĴ���֮�ͻ�Ҫ�࣬
    ��ôҪ�ҵ����ֿ϶������һ�ΰѴ�����Ϊ1ʱ��Ӧ�����֡�*/
  	public int moreThanHalfNum2(int[] arr){
  		if(arr.length == 0)
  			return -1;
  		int result = arr[0];
  		int times = 1;
  		for(int i = 1;i<arr.length;i++){
  			if(times == 0){
  				result = arr[i];
  				times = 1;
  			}else if(arr[i] == result)
  				times++;
  			else
  				times--;
  		}
  		if(!checkMoreThanHalf(arr,result))
  			result = -1;
  		return result;
  	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int[] arr= {1,2,3,2,2,5,2,2};  
		 ArrayMoreThanHalf a=new ArrayMoreThanHalf();
		 int i=a.moreThanHalf(arr);
		 System.out.println(i);
	}

}
