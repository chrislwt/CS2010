import java.io.*;
import java.util.*;

/**
 * Class for a binary tree that stores type E objects.
 * Node is a public class.
 **/
public class BinaryTree<E> implements Serializable {

    // Data Field
    /** The root of the binary tree */
    protected Node<E> root;

    /** Construct an empty BinaryTree */
    public BinaryTree() {
        root = null;
    }
    


    /**
     * Construct a BinaryTree with a specified root.
     * Should only be used by subclasses.
     * @param root The node that is the root of the tree.
     */
    protected BinaryTree(Node<E> root) {
        this.root = root;
    }

    /**
     * Constructs a new binary tree with data in its root,leftTree
     * as its left subtree and rightTree as its right subtree.
     */
    public BinaryTree(E data, BinaryTree<E> leftTree,
            BinaryTree<E> rightTree) {
        root = new Node<E>(data);
        if (leftTree != null) {
            root.left = leftTree.root;
        } else {
            root.left = null;
        }
        if (rightTree != null) {
            root.right = rightTree.root;
        } else {
            root.right = null;
        }
    }

    /**
     * Return the left subtree.
     * @return The left subtree or null if either the root or
     * the left subtree is null
     */
    public BinaryTree<E> getLeftSubtree() {
        if (root != null && root.left != null) {
            return new BinaryTree<E>(root.left);
        } else {
            return null;
        }
    }

    /**
     * Return the right sub-tree
     * @return the right sub-tree or
     *         null if either the root or the
     *         right subtree is null.
     */
    public BinaryTree<E> getRightSubtree() {
        if (root != null && root.right != null) {
            return new BinaryTree<E>(root.right);
        } else {
            return null;
        }
    }

    /**
     * Return the data field of the root
     * @return the data field of the root
     *         or null if the root is null
     */
    public E getData() {
        if (root != null) {
            return root.data;
        } else {
            return null;
        }
    }

    /**
     * Determine whether this tree is a leaf.
     * @return true if the root has no children
     */
    public boolean isLeaf() {
        return (root == null || (root.left == null && root.right == null));
    }
  
    public int height() {
      return height(root);
    }
    
    public int height(Node<E> r) {
      if (r == null) return 0;
      return 1 + Math.max(height(r.left), height(r.right));
    }

    public int size() {
      return size(root);
    }
    
    public int size(Node<E> r) {
      if (r == null) return 0;
      return 1 + size(r.left) + size(r.right);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        preOrderTraverse(root, 1, sb);
        return sb.toString();
    }
     
    /**
     * Perform a preorder traversal.
     * @param node The local root
     * @param depth The depth
     * @param sb The string buffer to save the output
     */
    private void preOrderTraverse(Node<E> node, int depth,
            StringBuilder sb) {
        for (int i = 1; i < depth; i++) {
            sb.append("  ");
        }
        if (node == null) {
            sb.append("null\n");
        } else {
            sb.append(node.toString());
            sb.append("\n");
            preOrderTraverse(node.left, depth + 1, sb);
            preOrderTraverse(node.right, depth + 1, sb);
        }
    }

    /* Implement the following method to read the path encodings and create the nodes.
     * 
     * Sample Input

(11,LL) (7,LLL) (8,R)
(5,) (4,L) (13,RL) (2,LLR) (1,RRR) (4,RR) ()
*/
   public static BinaryTree<String> readBinaryTree1(BufferedReader bR)
     throws IOException {
        Scanner scan = new Scanner(bR);
        BinaryTree<String> tree = null;
       
        while(scan.hasNext()){
          String token = scan.next();
          
          if(token.equals("()")){
               break;
          }

          //create tree with a root
          if(tree == null){
            tree = new BinaryTree<String>(new Node<String>("-1"));
          }
          
          //retrieve necessary node information
          String nodeValue = token.substring(token.indexOf('(') + 1, token.indexOf(','));
          String pathInfo = token.substring(token.indexOf(',') + 1, token.indexOf(')'));
          
          //to check against no data value node
          if(nodeValue.equals("")){
            nodeValue = "-1";
          }

          insertNode(tree.root, nodeValue, pathInfo);
            
        }
          
          //to create an empty tree if there are no input nodes or input is "()"
          if(tree == null){
            tree = new BinaryTree<String>();
          }

          return tree;  
     }

    /**
     * Method to insert node into binary tree
     * from root then to left then to right
     */
   
    private static void insertNode(Node<String> root, String value, String path) {

        if (path.equals("")) {
            root.setData(value);
            return;
        }
        
        

        if (path.charAt(0) == 'L') {
            if (root.getLeft() == null) {
                root.setLeft(new Node<String>("-1"));
            }
            insertNode(root.getLeft(), value, path.substring(1));
            
        } else if (path.charAt(0) == 'R') {
            if (root.getRight() == null) {
                root.setRight(new Node<String>("-1"));
            }
            insertNode(root.getRight(), value, path.substring(1));
        }
    }

   

   
   
     /**
     * Method to return the preorder traversal of the binary tree
     * as a sequence of strings each separated by a space.
     * @return A preorder traversal as a string
     */
    public String preorderToString() {
        StringBuilder stb = new StringBuilder();
        preorderToString(stb, root);
        return stb.toString();
    }

    private void preorderToString(StringBuilder stb, Node<E> root) {
        stb.append(root);
        if (root.left != null) {
            stb.append(" ");
            preorderToString(stb, root.left);
        }
        if (root.right != null) {
            stb.append(" ");
            preorderToString(stb, root.right);
        }
    }

    /**
     * Method to return the postorder traversal of the binary tree
     * as a sequence of strings each separated by a space.
     * @return A postorder traversal as a string
     */
    public String postorderToString() {
        StringBuilder stb = new StringBuilder();
        postorderToString(stb, root);
        return stb.toString();
    }

    private void postorderToString(StringBuilder stb, Node<E> root) {
        if (root.left != null) {
            postorderToString(stb, root.left);
            stb.append(" ");
        }
        if (root.right != null) {
            postorderToString(stb, root.right);
            stb.append(" ");
        }
        stb.append(root);
    }

    /** 
     * A method to display the inorder traversal of a binary tree 
     * placeing a left parenthesis before each subtree and a right 
     * parenthesis after each subtree. For example the expression 
     * tree shown in Figure 6.12 would be represented as
     * (((x) + (y)) * ((a) / (b))).
     * @return An inorder string representation of the tree
     */
    public String inorderToString() {
        StringBuilder stb = new StringBuilder();
        inorderToString(stb, root);
        return stb.toString();
    }

    private void inorderToString(StringBuilder stb, Node<E> root) {
        if (root.left != null) {
            stb.append("(");
            inorderToString(stb, root.left);
            stb.append(") ");
        }
        stb.append(root);
        if (root.right != null) {
            stb.append(" (");
            inorderToString(stb, root.right);
            stb.append(")");
        }
    }

    public String levelorderToString() {
        StringBuilder stb = new StringBuilder();
        levelorderToString(stb, root);
        return stb.toString();
    }
        
    private void levelorderToString(StringBuilder stb, Node<E> root) {
      boolean complete = false;
      if (root == null) {
        stb.append("An empty tree");
        return;
      }
      Queue<Node<E>> q = new LinkedList<Node<E>>();
      q.offer(root);
      while (!q.isEmpty()) {
        Node<E>  curr = q.poll();
        
        //display message only once if a tree is not completely specified, i.e. some node in the tree is NOT given a value
        if(curr.toString().equals("-1") && (!complete)){
          System.out.println("not complete");
          complete = true;
        }
        
        stb.append(curr);
        stb.append(" ");
        if (curr.left != null) {
            q.offer(curr.left);
        }
        if (curr.right != null) {
            q.offer(curr.right);
        }
      }
    }
}