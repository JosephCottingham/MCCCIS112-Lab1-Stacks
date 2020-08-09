import ch07.trees.*;
import ch04.queues.*;
import ch02.stacks.*;
import support.BSTNode;      
import support.LLNode;

public class treeProject extends BinarySearchTree<Integer>
{
   public static void main (String[] args)
   {
      treeProject tree = new treeProject();
      tree.add(7);
      tree.add(8);
      tree.add(3);
      tree.add(4);
      tree.inorder();
      
   }

   public void inorder()
   {
      ArrayBoundedStack<BSTNode> stack = new ArrayBoundedStack<BSTNode>();
      BSTNode curr = root; //start at root node
   
      while (!stack.isEmpty() || curr != null)
      {
      //if current is not null, push the info there onto stack and move to left child
         if (curr != null)
         {
            stack.push(curr);
            curr= curr.getLeft();
         }
         //if current is null, we pop it, and move to right child by setting current node to that child
         else 
         {
            curr = stack.top();
            stack.pop();
            System.out.print(String.valueOf(curr.getInfo()) + " ");
            curr = curr.getRight();
         }
      }
   
   }
}
