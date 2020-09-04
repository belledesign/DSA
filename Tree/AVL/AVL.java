package AVL;

class Node 
{ 
    int data, height; 
    Node left, right; 

    Node(int d) 
    { 
        data = d; 
        height = 1; 
    } 
} 

public class AVL 
{
    Node root; 

    // function to get the height of the tree 
    int height(Node N) { 
        if (N == null) 
            return 0; 
        return N.height; 
    }  

    // To right rotate subtree on root y 
    Node rightRotate(Node y) 
    { 
        Node x = y.left; 
        Node T2 = x.right; 

        // rotation 
        x.right = y; 
        y.left = T2; 

        // heights 
        y.height = Math.max(height(y.left), height(y.right)) + 1; 
        x.height = Math.max(height(x.left), height(x.right)) + 1; 

        // Return new root 
        return x; 
    } 

    // To left rotate subtree on root x 
    Node leftRotate(Node x) 
    { 
        Node y = x.right; 
        Node T2 = y.left; 

        // Perform rotation 
        y.left = x; 
        x.right = T2; 

        // Update heights 
        x.height = Math.max(height(x.left), height(x.right)) + 1; 
        y.height = Math.max(height(y.left), height(y.right)) + 1; 

        // Return new root 
        return y; 
    } 

    // Balance factor of node N 
    int getBalance(Node N) 
    { 
        if (N == null) 
            return 0; 

        return height(N.left) - height(N.right); 
    } 

    Node insert(Node node, int data) 
    { 
        // normal BST insertion
        if (node == null) 
            return (new Node(data)); 

        if (data < node.data) 
            node.left = insert(node.left, data); 
        else if (data > node.data) 
            node.right = insert(node.right, data); 
        else // Duplicate datas not allowed 
            return node; 

        // Updating height
        node.height = 1 + Math.max(height(node.left),height(node.right)); 

        // balance factor, to check whether this node is unbalanced
        int balance = getBalance(node); 

        // Left Left Case 
        if (balance > 1 && data < node.left.data) 
            return rightRotate(node); 

        // Right Right Case 
        if (balance < -1 && data > node.right.data) 
            return leftRotate(node); 

        // Left Right Case 
        if (balance > 1 && data > node.left.data) 
        { 
            node.left = leftRotate(node.left); 
            return rightRotate(node); 
        } 

        // Right Left Case 
        if (balance < -1 && data < node.right.data) 
        { 
            node.right = rightRotate(node.right); 
            return leftRotate(node); 
        } 

        return node; 
    } 

    
    void inorder(Node root)
    {
        if(root==null)
            return;
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
    
    void preorder(Node root)
    {
        if(root==null)
            return;
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }
    
    void postorder(Node root)
    {
        if(root==null)
            return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data+" ");
    }
    

    public static void main(String[] args) { 
        AVL tree = new AVL(); 

        /* Constructing tree given in the above figure */
        tree.root = tree.insert(tree.root, 10); 
        tree.root = tree.insert(tree.root, 20); 
        tree.root = tree.insert(tree.root, 30); 
        tree.root = tree.insert(tree.root, 40); 
        tree.root = tree.insert(tree.root, 50); 
        tree.root = tree.insert(tree.root, 25); 

        /* The constructed AVL Tree would be 
            30 
            / \ 
           20 40 
           / \  \ 
          10 25 50 
        */
        System.out.println("Preorder traversal of constructed tree is : "); 
        tree.preorder(tree.root);
        System.out.println();
        System.out.println("Inorder traversal of constructed tree is : "); 
        tree.inorder(tree.root);
        System.out.println();
        System.out.println("Postorder traversal of constructed tree is : "); 
        tree.postorder(tree.root);
        System.out.println(); 
    } 
} 