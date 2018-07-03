package xiao.offer2;

import java.util.Arrays;
/*假设原始矩阵是一个3 * n 的矩阵，那么它的子矩阵可以是 1 * k, 2 * k, 3 * k，（1 <= k <= n）
。 如果是1*K，这里有3种情况：子矩阵在第一行，子矩阵在第二行，子矩阵在第三行。如果是 2 * k，
这里有两种情况，子矩阵在第一、二行，子矩阵在第二、三行。如果是3 * k，只有一种情况。*/
public class FindGreastedSumOfSubMaticx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int matrix[][]={{0,-2,-7,0},{9 ,2 ,-6 ,2},{-4 ,1 ,-4 ,1},{-1 ,8 ,0 ,-2 }};
		 int res=new FindGreastedSumOfSubMaticx().subMaxMatrix(matrix);
		 System.out.println(res);
	}


public int subMaxMatrix(int[][] matrix) {
	
	int[][] total = matrix;
	//它每一层上下相加后得到的矩阵是total
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
			//result 保存的是从 i 行 到第 j 行 所对应的矩阵上下值的和
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