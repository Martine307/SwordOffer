package shenxinfu;



import java.util.Arrays;
import java.util.Scanner;

/**
 * �о�����������Ԫ�غ�Ϊ��ֵ�����
 */
public class SolveProb {
    // Arrays.sort(arr);
    static int[] flag = new int[100];
    static int index = 0;// ��¼��ǰ
    public SolveProb() {        
    }
    public static void numGroupAll(int[] arr, int start, int length, int sum) {
        if (sum == 0) {
            for (int j = 0; j < index; j++) {
                System.out.print(flag[j]);
            }
            System.out.println();
        } 
        else if(sum>0) {
            for (int i = start; i < length; i++) {
                flag[index++] = arr[i];
                System.out.println(index);
                SolveProb.numGroupAll(arr, i + 1, length-1, sum - arr[i]);
                
             } 
        }
        index--;   //��sum<0  ���ʾ������������������Ҫindex--, ��Ϊ֮ǰ��������������� index++�Ҹ�����һ����
    }

    public static void numGroup(int[] arr, int start, int length, int sum) {
        if (sum == 0) {
            for (int j = 0; j < index; j++) {
                System.out.print(flag[j]);
            }
            System.out.println();
        } 
        else if(sum>0) {
            for (int i = start; i < length; i++) {
            	int temp_sum=sum - arr[i];

                if(temp_sum>=0) 
                {
                  flag[index++] = arr[i];
                  System.out.println(index);
                  SolveProb.numGroup(arr, i + 1, length-1, sum - arr[i]);
                }
                else	//��Ϊ������������������ʱtemp_sumС��0�����������������������������ٽ���ѭ��
                	break;
             } 
        }
        index--;
      //  System.out.println(index);
    }
    
    
    public static void main(String[] args) {
       
        int sum = 100;
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();
        int[] arr=new int[num] ;
        for(int i=0;i<num;i++){
        	arr[i]=sc.nextInt();
        }
        System.out.println(Arrays.toString(arr));
        SolveProb.numGroupAll(arr, 0, arr.length, sum);//����δ����
        
        /*Arrays.sort(arr);  //��������������Ļ���������numGroup����
        
        SolveProb.numGroup(arr, 0, arr.length, sum);*/
    }
}