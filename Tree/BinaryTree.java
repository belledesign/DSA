import java.util.*;

class BinaryTree{
    
    private Node root;
    public BinaryTree(int data) 
    { 
        root = new Node(data);
    } 
    public BinaryTree() 
    { 
        root = null; 
    } 
    public void insertLevelOrder(int data)
    {
        if(root==null)
        {
            root=new Node(data);
        }    
        else
        {
            Queue<Node> q=new LinkedList<Node>();
            q.offer(root);
            Node temp;
            while(!q.isEmpty())
            {
                temp=q.remove();
                if (temp.left==null)
                {
                    temp.left=new Node(data);
                    break;
                }
                if (temp.right==null)
                {
                    temp.right=new Node(data);
                    break;
                }
                q.offer(temp.left);
                q.offer(temp.right);
            }
        }
    }
    public void BFS()
    {
        System.out.println("The BFS Traversal of tree is:");
        Queue<Node> q=new LinkedList<Node>();
        q.offer(root);
        Node temp;
        while(!q.isEmpty())
        {
            temp=q.remove();
            System.out.print(temp.data+" ");
            if(temp.left!=null)
                q.offer(temp.left);
            if(temp.right!=null)
                q.offer(temp.right);
        }   
        System.out.println();
    }
    void inorder(Node root)
    {
        if(root==null)
            return;
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
    void inorder()
    {
        System.out.println("Inorder Traversal of tree is:");
        inorder(root);
        System.out.println();
    }
    void preorder(Node root)
    {
        if(root==null)
            return;
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }
    void preorder()
    {
        System.out.println("Preorder Traversal of tree is:");
        preorder(root);
        System.out.println();
    }
    void postorder(Node root)
    {
        if(root==null)
            return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data+" ");
    }
    void postorder()
    {
        System.out.println("Postorder Traversal of tree is:");
        postorder(root);
        System.out.println();
    }
}