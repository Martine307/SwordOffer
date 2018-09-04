package xiao.test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DFSandBFS {
	 	private int number = 9;
	    private boolean[] flag;
	    private String[] vertexs = {"A", "B", "C", "D", "E", "F", "G", "H", "I"};
	    private int[][] edges = {
	        {0, 1, 0, 0, 0, 1, 1, 0, 0},
	        {1, 0, 1, 0, 0, 0, 1, 0, 1},
	        {0, 1, 0, 1, 0, 0, 0, 0, 1},
	        {0, 0, 1, 0, 1, 0, 1, 1, 1},
	        {0, 0, 0, 1, 0, 1, 0, 1, 0},
	        {1, 0, 0, 0, 1, 0, 1, 0, 0},
	        {0, 1, 0, 1, 0, 1, 0, 1, 0},
	        {0, 0, 0, 1, 1, 0, 1, 0, 0},
	        {0, 1, 1, 1, 0, 0, 0, 0, 0},
	    };
	    public static void main(String[] args){
	    	DFSandBFS graph = new DFSandBFS();
	        System.out.println("DFS递归");
	        graph.DFSTraverse();
	        System.out.println();
	        System.out.println("DFS非递归");
	        //graph.DFS_Map_tree();
	        graph.DFS_Map();
	        System.out.println();
	        System.out.println("BFS非递归");
	        graph.BFS_Map();
	    }
		private void BFS_Map() {
			// TODO Auto-generated method stub
			flag = new boolean[number];
	        Queue<Integer> queue = new LinkedList<Integer>();
	        for(int i = 0; i < number; i++){
	            if(flag[i] == false){
	                flag[i] = true;
	                System.out.print(vertexs[i] + " ");
	                queue.add(i);
	                while(!queue.isEmpty()){
	                    int k = queue.poll();
	                    for(int j = 0; j < number; j++){
	                        if(edges[k][j] == 1 && flag[j] == false){
	                            flag[j] = true;
	                            System.out.print(vertexs[j] + " ");
	                            queue.add(j);
	                        }
	                    }
	                }
	            }
	        }
		}
		private void DFS_Map() {
			// TODO Auto-generated method stub
			flag=new boolean[number];
			Stack<Integer> stack = new Stack<Integer>();
			for(int i=0;i<number;i++){
				if(flag[i]==false){
					flag[i]=true;
					System.out.print(vertexs[i] + " ");
					stack.push(i);
				}
				
				while(!stack.isEmpty()){
					int k=stack.peek();
					int j=0;
					for(j=0;j<number;j++){
						if(edges[k][j]==1&&flag[j]==false){
							flag[j]=true;
							System.out.print(vertexs[j] + " ");
							stack.push(j);
							break;
						}
					}
					if(j==number){//栈顶元素不存在未被访问的邻接节点
						stack.pop();
					}
					
				}
			}
		}
		private void DFSTraverse() {
			// TODO Auto-generated method stub
			flag=new boolean[number];
			for(int i=0;i<number;i++){
				if(flag[i]==false){
					DFS(i);
				}
			}
		}
		private void DFS(int i) {
			// TODO Auto-generated method stub
			flag[i]=true;
			System.out.print(vertexs[i] + " ");
			for(int j=0;j<number;j++){
				if(edges[i][j]==1&&flag[j]==false){
					DFS(j);
				}
			}
		}
	
		/*
	    如果是树，可以用此思路，将打印放在出栈时，
	    思路：对于每一个连通图，取一个未访问的节点入栈，只要栈不为空，循环：栈顶元素出栈并访问
	    栈顶元素，将与栈顶元素有边且未被访问的元素入栈。所有连通分支访问完，算法结束。
	    （每个栈顶元素先于与其有边且未被访问的元素被访问）
	    */
	    /*void DFS_Map_tree(){
	        flag = new boolean[number];
	        Stack<Integer> stack = new Stack<Integer>();
	        for(int i = 0; i < number; i++){
	            if(flag[i] == false){
	                flag[i] = true;
	                //System.out.print(vertexs[i] + " ");
	                stack.push(i);
	            }
	            while(!stack.isEmpty()){
	                int k = stack.pop();
	                System.out.print(vertexs[k] + " ");
	                //for中将与k连接但是没被访问的节点入栈。
	                for(int j = 0; j < number; j++){
	                    if(edges[k][j] == 1 && flag[j] == false){
	                        flag[j] = true;
	                        //System.out.print(vertexs[j] + " ");
	                        stack.push(j);
	                        //break;
	                    }
	                }
	            }
	        }
	    }*/
}
