package xiaozhaoti;

import java.util.Arrays;
import java.util.Scanner;

public class HeChangTuan {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int studentNum=sc.nextInt();
		int ability[]=new int[studentNum+1];//��i���˶�Ӧ����Ϊability[i]
		for(int i=1;i<=studentNum;i++){
			ability[i]=sc.nextInt();
		}
		
		int selectStudentNum=sc.nextInt();
		int distance=sc.nextInt();
		//����ֵ�����и�
		long dpMax[][]=new long[studentNum+1][selectStudentNum+1];
		long dpMin[][]=new long[studentNum+1][selectStudentNum+1];
		
		for(int i=1;i<=studentNum;i++){
			dpMax[i][1]=ability[i];
			dpMin[i][1]=ability[i];
		}
		
		for(int k=2;k<=selectStudentNum;k++){
			for(int n=k;n<=studentNum;n++){
				long tempMax=Long.MIN_VALUE;
				long tempMin=Long.MAX_VALUE;
				//left��ʾ����ǰk-1���е�k-1����λ�ã���ˣ�left>=k-1�����ң���k-1��ѧ���͵�k��ѧ��������d�����left>=one-d�������߶���ȷʵӦ����max
				for(int left=Math.max(n-distance, k-1);left<=n-1;left++){
					if(tempMax<Math.max(dpMax[left][k-1]*ability[n], dpMin[left][k-1]*ability[n])){
						tempMax=Math.max(dpMax[left][k-1]*ability[n], dpMin[left][k-1]*ability[n]);
					}
					if(tempMin>Math.min(dpMax[left][k-1]*ability[n], dpMin[left][k-1]*ability[n])){
						tempMin=Math.min(dpMax[left][k-1]*ability[n], dpMin[left][k-1]*ability[n]);
					}
				}
				
				dpMax[n][k]=tempMax;
				dpMin[n][k]=tempMin;
			}
		}
		for(int i=0;i<dpMax.length;i++){
			System.out.println(Arrays.toString(dpMax[i]));
		}
		for(int i=0;i<dpMin.length;i++){
			System.out.println(Arrays.toString(dpMin[i]));
		}
		long res=Long.MIN_VALUE;
		for(int i=selectStudentNum;i<=studentNum;i++){
			if(dpMax[i][selectStudentNum]>res) res=dpMax[i][selectStudentNum];
		}
		System.out.println(res);
	}

}
