package xiao.offer4;

public class PrintProbability {

	private static final int g_maxValue = 6;
    //���ڵݹ������ӵ�����ʱ��Ч�ʲ���
    public static void PrintProbability(int number){
        if(number<1) return;
        int maxSum = number*g_maxValue;
        int[] pProbabilities = new int[maxSum-number+1];
        //��ʼ������ʼͳ��֮ǰ��Ϊ0��
        for(int i=number;i<=maxSum;i++){
            pProbabilities[i-number] = 0;
        }
        double total = Math.pow(g_maxValue,number);
        //probability(number,pProbabilities);�����������n~6nÿ��������ֵĴ���
        probability(number,pProbabilities);
        for(int i=number;i<=maxSum;i++){
            double ratio = pProbabilities[i-number]/total;
            System.out.println("i: "+i+" ratio: "+ratio);
        }
    }
    public static void probability(int number,int[] pProbabilities){
        for(int i=1;i<=g_maxValue;i++){//�ӵ�һ�����ӿ�ʼ
            probability(number,number,i,pProbabilities);
        }
    }
    //�ܹ�original�����ӣ���ǰ�� current�����ӣ���ǰ�ĺͣ��ᴩʼ�յ�����
    public static void probability(int original,int current,int sum,int[] pProbabilities){
        if(current==1){
            pProbabilities[sum-original]++;
        }else{
            for(int i=1;i<=g_maxValue;i++){
                probability(original,current-1,sum+i,pProbabilities);
            }
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new PrintProbability().PrintProbability_1(6);
	}
	
	
	//����ѭ�������ӵ���
    public static void PrintProbability_1(int number){
        if(number<1){
            return;
        }
        int[][] pProbabilities = new int[2][g_maxValue*number +1];
       /* for(int i=0;i<g_maxValue;i++){//��ʼ������
             pProbabilities[0][i] = 0;
             pProbabilities[1][i] = 0;
        }*/
        int flag = 0;
        for(int i=1;i<=g_maxValue;i++){//����һ����������ʱ����6�ֿ��ܣ�ÿ�ֿ��ܳ���һ��
            pProbabilities[flag][i] = 1;
        }
        //�ӵڶ��ο�ʼ�����ӣ������һ�������еĵ�n�����ֱ�ʾ���Ӻ�Ϊn���ֵĴ�����
        //����һѭ���У����Ǽ���һ�������ӣ���ʱ��Ϊn�����ӳ��ִ���Ӧ�õ�����һ��ѭ�������ӵ�����Ϊn-1,n-2,n-3,n-4,n-5��
        //n-6�Ĵ����ܺͣ��������ǰ���һ������ĵ�n��������Ϊǰһ�������Ӧ��n-1,n-2,n-3,n-4,n-5��n-6֮��
        for(int k =2;k<=number;k++){
            /*for(int i=0;i<k;i++){//����k�����ӣ�����СΪk��С��k������ǲ����ܷ����ģ����������ܷ����Ĵ�������Ϊ0��
                pProbabilities[1-flag][i] = 0;
            }*/
            for(int i=k;i<=g_maxValue*k;i++){//����k�����ӣ�����СΪk�����Ϊg_maxValue*k
              
                for(int j=1;j<=i&&j<=g_maxValue;j++){
                    pProbabilities[1-flag][i] += pProbabilities[flag][i-j];
                }
            }
            flag = 1-flag;
        }
        double total = Math.pow(g_maxValue, number);
        for(int i=number;i<=g_maxValue*number;i++){
            double ratio = pProbabilities[flag][i]/total;
            System.out.println("sum: "+i+" ratio: "+ratio);
        }
    }

}
