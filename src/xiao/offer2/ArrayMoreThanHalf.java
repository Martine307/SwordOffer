package xiao.offer2;

public class ArrayMoreThanHalf {
	/*
	 我们的算法是受快速排序的算法的启发。在随机快速排序的算法中，我们先在数组中随机的选择一个数字，
	 然后调数组中数字的顺序，使得比选中的数字小数字排在它的左边，比选中的数字大的数字都排在它的右边。
	 比如这个选中的数字的下标刚好是n/2，那么这个数字就是数组中的中位数。如果它的下标大于n/2，
	 那么中位数应该位于它的左边，我们可以接着在它的左边部分的数组中查找。
	 如果它的下标小于n/2，那么中位数应该在它的右边，我们可以接着在它的右边部分中查找。
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
	
	//验证是否存在  
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
    
    
    
  //解法二：
   /* 数组中有一个数字出现的次数超过数组长度的一半，也就是说它出现的次数比其他所有数字出现的次数的和还要多。
    因此我们可以遍历数组的时候保存两个值：一个是数组中的一个数字，一个是次数。当我们遍历到下一个数字的时候，
    如果下一个数字和我们之前保存的数字相同，则次数加1；如果下一个数字和我们之前保存的数字不同，则次数减1.
    如果次数为0，我们需要保存下一个数字，并把次数设为1.由于我们要找的数字出现的次数比其他所有数字出现的次数之和还要多，
    那么要找的数字肯定是最后一次把次数设为1时对应的数字。*/
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
