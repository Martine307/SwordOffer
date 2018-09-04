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
	        System.out.println("DFS�ݹ�");
	        graph.DFSTraverse();
	        System.out.println();
	        System.out.println("DFS�ǵݹ�");
	        //graph.DFS_Map_tree();
	        graph.DFS_Map();
	        System.out.println();
	        System.out.println("BFS�ǵݹ�");
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
					if(j==number){//ջ��Ԫ�ز�����δ�����ʵ��ڽӽڵ�
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
	    ��������������ô�˼·������ӡ���ڳ�ջʱ��
	    ˼·������ÿһ����ͨͼ��ȡһ��δ���ʵĽڵ���ջ��ֻҪջ��Ϊ�գ�ѭ����ջ��Ԫ�س�ջ������
	    ջ��Ԫ�أ�����ջ��Ԫ���б���δ�����ʵ�Ԫ����ջ��������ͨ��֧�����꣬�㷨������
	    ��ÿ��ջ��Ԫ�����������б���δ�����ʵ�Ԫ�ر����ʣ�
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
	                //for�н���k���ӵ���û�����ʵĽڵ���ջ��
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
