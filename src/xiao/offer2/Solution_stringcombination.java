package xiao.offer2;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入一个字符串,按字典序打印出该字符串中字符的所有组合。例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串a,b,c,ab,ac,bc
 * ,abc 。 求n个字符组成长度为m的组合问题
 * 组合：

要么选择长度为n的字符串中的第一个字符，那么要在其余的长度n-1的字符串中选择m-1个字符

要么不选择长度为n的字符串中的第一个字符，那么要在其余的长度n-1的字符串中选择m个字符
 * @author pomay
 *
 */
public class Solution_stringcombination
{
	// 求字符串中所有字符的组合abc>a,b,c,ab,ac,bc,abc
	public static void perm(String s)
	{
		List<String> result = new ArrayList<String>();
		// 从一个开始
		for (int i = 1; i <= s.length(); i++)
		{
			combination(s, i, result);
		}
	}

	// 从字符串s中选择m个字符
	public static void combination(String s, int m, List<String> result)
	{
		// 如果m==0，则递归结束。输出当前结果
		if (m == 0)
		{
			for (int i = 0; i < result.size(); i++)
			{
				System.out.print(result.get(i));
			}
			System.out.println("、");
			return;
		}

		if (s.length() != 0)
		{
			// 选择当前元素
			result.add(s.charAt(0) + "");
			// substring用法，截取出从1开始到n结束的字符串
			combination(s.substring(1, s.length()), m - 1, result);
			result.remove(result.size() - 1);
			// 不选当前元素
			combination(s.substring(1, s.length()), m, result);
		}
	}

	public static void main(String[] args)
	{
		String str = "abc";
		perm(str);
	}
}