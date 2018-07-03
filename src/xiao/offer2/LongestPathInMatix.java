package xiao.offer2;

/*
 *  ��Ŀ��������һ��m��n�ľ�����Ҫ�����Ͻ��ߵ����½ǣ����ҷ���ֻ�������»�������

�ֹ涨һ��·����ȨֵΪ�ߴ�·����������ֵ�ĺ͡�����һ���������ҳ�Ȩֵ����һ��

·����
maxpath[i][j] = MAX{ maxpath[i-1][j], maxpath[i][j+1] }  + maxpath[i][j];
maxpath[0][n-1] = path[0][n-1];

dp
 */

public class LongestPathInMatix {
	private void print(int path[][])// ��ӡ·��
	{
		for (int i = 0; i < path.length; i++) {
			for (int j = 0; j < path[i].length; j++) {
				System.out.print(path[i][j] + " ");
			}
			System.out.println("");
		}
	}

	public int findMaxPath(int path[][]) {
		for (int i = path[0].length - 2; i >= 0; i--)// ��һ�е�ֵ
		{
			path[0][i] += path[0][i + 1];
		}
		for (int i = 1; i < path.length; i++) // ���һ�е�ֵ
		{
			path[i][path[i].length - 1] += path[i - 1][path[i - 1].length - 1];
		}
		for (int i = 1; i < path.length; i++)// ���Ʒ�,��������Ĺ�ʽ
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
		return path[path.length - 1][0];// ���λ�õ�ֵ��ΪҪ������Ȩֵ
	}

	public static void main(String args[]) {
		int[][] path = { { 2, 5, 6 }, { 3, 9, 4 }, { 7, 9, 1 } };
		System.out.println(new LongestPathInMatix().findMaxPath(path));
	}
}
