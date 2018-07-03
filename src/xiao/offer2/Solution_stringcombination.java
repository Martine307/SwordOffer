package xiao.offer2;

import java.util.ArrayList;
import java.util.List;

/**
 * ����һ���ַ���,���ֵ����ӡ�����ַ������ַ���������ϡ����������ַ���abc,���ӡ�����ַ�a,b,c�������г����������ַ���a,b,c,ab,ac,bc
 * ,abc �� ��n���ַ���ɳ���Ϊm���������
 * ��ϣ�

Ҫôѡ�񳤶�Ϊn���ַ����еĵ�һ���ַ�����ôҪ������ĳ���n-1���ַ�����ѡ��m-1���ַ�

Ҫô��ѡ�񳤶�Ϊn���ַ����еĵ�һ���ַ�����ôҪ������ĳ���n-1���ַ�����ѡ��m���ַ�
 * @author pomay
 *
 */
public class Solution_stringcombination
{
	// ���ַ����������ַ������abc>a,b,c,ab,ac,bc,abc
	public static void perm(String s)
	{
		List<String> result = new ArrayList<String>();
		// ��һ����ʼ
		for (int i = 1; i <= s.length(); i++)
		{
			combination(s, i, result);
		}
	}

	// ���ַ���s��ѡ��m���ַ�
	public static void combination(String s, int m, List<String> result)
	{
		// ���m==0����ݹ�����������ǰ���
		if (m == 0)
		{
			for (int i = 0; i < result.size(); i++)
			{
				System.out.print(result.get(i));
			}
			System.out.println("��");
			return;
		}

		if (s.length() != 0)
		{
			// ѡ��ǰԪ��
			result.add(s.charAt(0) + "");
			// substring�÷�����ȡ����1��ʼ��n�������ַ���
			combination(s.substring(1, s.length()), m - 1, result);
			result.remove(result.size() - 1);
			// ��ѡ��ǰԪ��
			combination(s.substring(1, s.length()), m, result);
		}
	}

	public static void main(String[] args)
	{
		String str = "abc";
		perm(str);
	}
}