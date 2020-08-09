import ch07.trees.*;
import ch04.queues.*;
import ch02.stacks.*;
import support.BSTNode;
import support.LLNode;

public class treeProject extends BinarySearchTree
{
   public static void main (String[] args)
   {
      treeProject tree = new treeProject();
      tree.add(7);
      tree.add(8);
      tree.add(3);
      tree.add(4);
      System.out.println(tree.toString());
      tree.inorder(tree.root);
      
   }

   public static void inorder(LLNode root)
   {
      Stack<LLNode> stack = new Stack();
      Node curr = root; //start at root node
   
      while (!stack.empty() || curr != null)
      {
      //if current is not null, push the info there onto stack and move to left child
         if (curr != null)
         {
            stack.push(curr);
            curr= curr.left;
         }
         //if current is null, we pop it, and move to right child by setting current node to that child
         else 
         {
            curr = stack.pop();
            System.out.print(curr.data + " ");
            curr = curr.right;
         }
      }
   
   }
}
