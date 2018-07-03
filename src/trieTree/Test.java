package trieTree;

import trieTree.myTrieTree;

public class Test {
    public static void main(String[]args){
		
    	myTrieTree mytreetest=new myTrieTree();
    	mytreetest.createTrieTree("abce");
    	mytreetest.display();
    	//System.out.println("000");
    	mytreetest.createTrieTree("aefh");
    	mytreetest.display();
    	/*mytreetest.createTrieTree("abcehdjf");
    	mytreetest.display();
    	int i=mytreetest.queryTrieWord("abce".toCharArray(), 0, 3, mytreetest.getRoot());*/
		//System.out.println(i);
	}

}
