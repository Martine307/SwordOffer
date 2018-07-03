package xiao.offer2;

/*
 *  题目描述：有一个m×n的矩阵，现要从右上角走到左下角，并且方向只能是向下或者向左，

现规定一条路径的权值为走此路径所经过的值的和。给定一个矩阵，请找出权值最大的一条

路径。
maxpath[i][j] = MAX{ maxpath[i-1][j], maxpath[i][j+1] }  + maxpath[i][j];
maxpath[0][n-1] = path[0][n-1];

dp
 */

public class LongestPathInMatix {
	private void print(int path[][])// 打印路径
	{
		for (int i = 0; i < path.length; i++) {
			for (int j = 0; j < path[i].length; j++) {
				System.out.print(path[i][j] + " ");
			}
			System.out.println("");
		}
	}

	public int findMaxPath(int path[][]) {
		for (int i = path[0].length - 2; i >= 0; i--)// 第一行的值
		{
			path[0][i] += path[0][i + 1];
		}
		for (int i = 1; i < path.length; i++) // 最后一列的值
		{
			path[i][path[i].length - 1] += path[i - 1][path[i - 1].length - 1];
		}
		for (int i = 1; i < path.length; i++)// 倒推法,利用上面的公式
		{
			for (int j = path[i].length - 2; j >= 0; j--) {
				if (path[i - 1][j] >= path[i][j + 1]) {
					path[i][j] = path[i][j] + path[i - 1][j];
				} else {
					path[i][j] = path[i][j] + path[i][j + 1];
				}
			}
		}
		print(path);
		return path[path.length - 1][0];// 最后位置的值即为要求的最大权值
	}

	public static void main(String args[]) {
		int[][] path = { { 2, 5, 6 }, { 3, 9, 4 }, { 7, 9, 1 } };
		System.out.println(new LongestPathInMatix().findMaxPath(path));
	}
}
