package xiao.offer2;

import java.util.Arrays;
/*����ԭʼ������һ��3 * n �ľ�����ô�����Ӿ�������� 1 * k, 2 * k, 3 * k����1 <= k <= n��
�� �����1*K��������3��������Ӿ����ڵ�һ�У��Ӿ����ڵڶ��У��Ӿ����ڵ����С������ 2 * k��
����������������Ӿ����ڵ�һ�����У��Ӿ����ڵڶ������С������3 * k��ֻ��һ�������*/
public class FindGreastedSumOfSubMaticx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int matrix[][]={{0,-2,-7,0},{9 ,2 ,-6 ,2},{-4 ,1 ,-4 ,1},{-1 ,8 ,0 ,-2 }};
		 int res=new FindGreastedSumOfSubMaticx().subMaxMatrix(matrix);
		 System.out.println(res);
	}


public int subMaxMatrix(int[][] matrix) {
	
	int[][] total = matrix;
	//��ÿһ��������Ӻ�õ��ľ�����total
	for (int i =1; i < matrix.length; i++) {
		for (int j = 0; j < matrix[0].length; j++) {
			total[i][j] += total[i-1][j];
			
		}
	}
	/*for(int i=0;i<total.length;i++){
		for(int j=0;j<total[0].length;j++)
			System.out.print(total[i][j]);
		System.out.println();
	}*/
	int maximum = Integer.MIN_VALUE;
	for (int i = 0; i < matrix.length; i++) {
		for (int j = i; j < matrix.length; j++) {
			//result ������Ǵ� i �� ���� j �� ����Ӧ�ľ�������ֵ�ĺ�
                            int[] result = new int[matrix[0].length];
			for (int f = 0; f < matrix[0].length; f++) {
				if (i == 0) {
					result[f] = total[j][f];
					System.out.print(result[f]+"\t");
					
				} else {
					result[f] = total[j][f] - total[i - 1][f];
					System.out.print(result[f]+"\t");
				}
			}
			System.out.println();
			int maximal =new FindGreatestSumOfSubArray().findSum(result);
			
			if (maximal > maximum) {
				maximum = maximal;
			}
		}
	}
	
	return maximum;
}

}