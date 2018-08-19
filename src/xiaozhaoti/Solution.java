package xiaozhaoti;


public class Solution {
    public void reOrderArray(int [] array) {
       
        int count=0;
        int arr[]=new int[array.length];
        for(int i=0;i<array.length;i++){
            if((array[i]&1)!=0) arr[count++]=array[i];
        }
        for(int i=0;i<array.length;i++){
            if((array[i]&1)==0) arr[count++]=array[i];
        }
       array=arr;
       for(int i=0;i<array.length;i++){
           System.out.println(array[i]);
       }
    }
    
    public static void main(String[] args) {
		new Solution().reOrderArray(new int[]{1,2,3,4,5,6,7});
	}
}