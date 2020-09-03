public class Driver
{
	public static void main(String[] args) 
	{
        BinaryTree tree = new BinaryTree();
        tree.insertLevelOrder(1);
        tree.insertLevelOrder(2);
        tree.insertLevelOrder(3);
        tree.insertLevelOrder(4);
        tree.insertLevelOrder(5);
        tree.BFS();
        tree.inorder();
        tree.preorder();
        tree.postorder();
	    	
    }


}