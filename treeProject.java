import ch07.trees.*;
import ch04.queues.*;
import ch02.stacks.*;
import support.BSTNode;      
import support.LLNode;
import java.util.concurrent.ThreadLocalRandom;

public class treeProject extends BinarySearchTree<Integer>
{
   public static void main (String[] args)
   {
      treeProject tree = new treeProject();
      for (int x = 0; x < 15; x++) tree.add(ThreadLocalRandom.current().nextInt(-1000, 1000));
     System.out.print("\n\nIterative\n\n");
      tree.inorder();
      System.out.print("\n\nRecurive\n\n");
      tree.inorderRec(tree.root);
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
            System.out.println(String.valueOf(curr.getInfo()) + " ");
            curr = curr.getRight();
         }
      }
   
   }
   public void inorderRec(BSTNode node)
   {
   if(node != null) {
      inorderRec(node.getLeft());   
      System.out.println(node.getInfo());
      inorderRec(node.getRight());  
  }
}
}
