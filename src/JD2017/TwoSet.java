package JD2017;
/*�����������ϣ�Ҫ�� {A} + {B}��

ע��ͬһ�������в�����������ͬ��Ԫ�ء�*/
import java.util.Scanner;
import java.util.Arrays;
import java.util.HashSet;
public class TwoSet{
	
  public static void main(String args[]){
  	Scanner sc=new Scanner(System.in);
    while(sc.hasNext()){
    	int n=sc.nextInt();
    	int m=sc.nextInt();
      HashSet<Integer> hs=new HashSet<>();
      for(int i=0;i<n;i++){
      	hs.add(sc.nextInt());
      }
      for(int j=0;j<m;j++){
      	hs.add(sc.nextInt());
      }
      
     Object[]a= hs.toArray();
     Arrays.sort(a);
      for(int i=0;i<a.length;i++){
    	  System.out.print(a[i]+" ");
      }
     
      
    }
  }
}
