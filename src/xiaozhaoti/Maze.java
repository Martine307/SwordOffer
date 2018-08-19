package xiaozhaoti;



public class Maze {
	public String getMaze(String str){
		
		String news[]=str.split("\n");
		int rows=news[0].charAt(0)-'0';
		int cols=news[0].charAt(2)-'0';
		String s=news[1];
		
		int [][]mazeNum=new int[rows*2+1][cols*2+1];
		String[] point=s.split(";");
		int mazex[]=new int[2];
		int mazey[]=new int[2];
		
		for(int i=0;i<point.length;i++){
			String []newpoint=point[i].split(" ");
				for(int j=0;j<newpoint.length;j++){
					String[] xy1=newpoint[j].split(",");
					if(!Character.isDigit(xy1[0].charAt(0))||!Character.isDigit(xy1[1].charAt(0))) 
						return "Invalid number format.";
					int x1=Integer.valueOf(xy1[0]);				
					int y1=Integer.valueOf(xy1[1]);	
					if(x1<0||y1<0||x1>rows*2+1||y1>cols*2+1) 
						return "Number out of range.";				
					mazex[j]=x1*2+1;				
					mazey[j]=y1*2+1;
				}
				
				if(mazex[0]!=mazex[1]&&mazey[0]!=mazey[1]||mazex[0]==mazex[1]&&mazey[0]==mazey[1]){
					return "Maze format error.";
				}
				if(mazex[0]==mazex[1]&&mazey[0]<mazey[1]){
					for(int k=mazey[0];k<=mazey[1];k++){
						mazeNum[mazex[0]][k]=1;
					}
				}
				if(mazex[0]<mazex[1]&&mazey[0]==mazey[1]){
					for(int k=mazex[0];k<=mazex[1];k++){
						mazeNum[k][mazey[0]]=1;
					}
				}
				
				
			
			
			
		}
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<mazeNum.length;i++){
			for(int j=0;j<mazeNum[0].length;j++){
				if(mazeNum[i][j]==0)
					sb.append("[W] ");
				if(mazeNum[i][j]==1)
					sb.append("[R] ");
				
			}
			sb.append("\r\n");
			
		}
		
		return sb.toString();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str="3,3 \n"
				+ "0,10 0,2;0,0 1,0;0,1 1,1;0,2 1,2;1,0 1,1;1,1 1,2;1,1 2,1;1,2 2,2;2,0 2,1";
		
		
		String t=new Maze().getMaze(str);
		System.out.println(t);
	}

}
