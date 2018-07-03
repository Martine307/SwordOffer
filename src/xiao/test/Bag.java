package xiao.test;

import java.util.Arrays;

public class Bag {
	public static int V[][];
	public static int findMax(int w[],int v[],int number,int capacity){
		
		 V=new int[number+1][capacity+1];
		for(int firstcol=0;firstcol<=capacity;firstcol++){
			V[0][firstcol]=0;
		}
		for(int firstrow=0;firstrow<=number;firstrow++){
			V[firstrow][0]=0;
		}
		for(int i=1;i<=number;i++){
			for(int j=1;j<=capacity;j++){
				if(j<w[i-1]){
					V[i][j]=V[i-1][j];
				}else{
					if(V[i-1][j]>V[i-1][j-w[i-1]]+v[i-1]){//不装价值大
						V[i][j]=V[i-1][j];
					}else{
						V[i][j]=V[i-1][j-w[i-1]]+v[i-1];
					}
				}
			}
		}
		return V[number][capacity];
	}
	
	public static int[] FindWhat(int i,int j,int item[])//寻找解的组成方式
	{
		
		
	    if(i>=1)
	    {
	        if(V[i][j]==V[i-1][j])//相等说明没装
	        {
	            item[i-1]=0;//全局变量，标记未被选中
	            FindWhat(i-1,j,item);
	        }
	        else if( j-weight[i-1]>=0 && V[i][j]==V[i-1][j-weight[i-1]]+value[i-1] )
	        {
	            item[i-1]=1;//标记已被选中
	            FindWhat(i-1,j-weight[i-1],item);//回到装包之前的位置
	        }
	    }
	    return item;
	}
	public static int[] weight={2,3,4,5};
	public static int[] value={3,4,5,6};
	public static void main(String[]args){
		
	    int capacity=8;
		int v=findMax(weight,value,weight.length,capacity);
		System.out.println(v);
		int item[]=new int[weight.length];
		int a[]=FindWhat(V.length-1,V[0].length-1,item);
		System.out.println(Arrays.toString(a));
		for(int i=0;i<V.length;i++)
		System.out.println(Arrays.toString(V[i]));
	}

}
