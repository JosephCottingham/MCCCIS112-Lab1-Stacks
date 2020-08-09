//---------------------------------------------------------------------------
// BinarySearchTree.java          by Dale/Joyce/Weems               Chapter 7
//
// Defines all constructs for a reference-based BST.
// Supports three traversal orders Preorder, Postorder & Inorder ("natural")
//---------------------------------------------------------------------------

package ch07.trees;

import java.util.*;   // Iterator, Comparator

import ch04.queues.*;
import ch02.stacks.*;
import support.BSTNode;      

public class BinarySearchTree<T> implements BSTInterface<T>
{
   protected BSTNode<T> root;      // reference to the root of this BST
   protected Comparator<T> comp;   // used for all comparisons

   protected boolean found;   // used by remove

   public BinarySearchTree() 
    // Precondition: T implements Comparable
    // Creates an empty BST object - uses the natural order of elements.
   {
      root = null;
      comp = 
         new Comparator<T>()
         {
            public int compare(T element1, T element2)
            {
               return ((Comparable)element1).compareTo(element2);
            }
         };
   }

   public BinarySearchTree(Comparator<T> comp) 
    // Creates an empty BST object - uses Comparator comp for order
    // of elements.
   {
      root = null;
      this.comp = comp;
   }

   public boolean isFull()
    // Returns false; this link-based BST is never full.
   {
      return false;
   }

   public boolean isEmpty()
    // Returns true if this BST is empty; otherwise, returns false.
   {
      return (root == null);
   }

   public T min()
    // If this BST is empty, returns null;
    // otherwise returns the smallest element of the tree.
   {
      if (isEmpty())
         return null;
      else
      {
         BSTNode<T> node = root;
         while (node.getLeft() != null)
            node = node.getLeft();
         return node.getInfo();
      }
   }
   
   public T min2(BSTNode<T> root)
    //recursive method to return smallest element of tree
   {
     
      BSTNode<T> node = root;
      if (node.getLeft() == null)
      {
         return node.getInfo();
      }
      else
      {
         return min2(node.getLeft());
            
      }
     
   }
   public int height (BSTNode<T> node)
    //height method  for binary search tree that returns the height of the tree
   { 
      if (node== null)
      {
         return -1;
      }
      if (node.getLeft() == null && node.getRight() == null)
      {
         return 0;
      }
      else
      { 
         int leftCount = 0;
         int rightCount = 0;
         
         if (node.getLeft()!= null)
         {
           leftCount ++;
           leftCount+= height(node.getLeft());
         }
         if (node.getRight()!= null)
         {
            rightCount++;
            rightCount+= height(node.getRight());
         }
         if (leftCount> rightCount)
         {
            return leftCount;
         }
         else
          {
            return rightCount;
          }

      }
         
   }
   public double minHeight(BSTNode<T> node) 
   //returns optimal/minimum height of tree
   {
      return Math.log(height(node))/Math.log(2);
   }
   public double fRatio(BSTNode<T> node) 
   //calculates and returns fullness ration of tree
   {
      //BSTNode<T> node
      double height = height(node);
      double min = minHeight(node);
      Math.ceil(min);
     
      return min/height;
   
   }
 
   public T max()
    // If this BST is empty, returns null;
    // otherwise returns the largest element of the tree.
   {
      if (isEmpty())
         return null;
      else
      {
         BSTNode<T> node = root;
         while (node.getRight() != null)
            node = node.getRight();
         return node.getInfo();
      }
   }

   private int recSize(BSTNode<T> node)
    // Returns the number of elements in subtree rooted at node.
   {
      if (node == null)    
         return 0;
      else
         return 1 + recSize(node.getLeft()) + recSize(node.getRight());
   }

   public int size()
    // Returns the number of elements in this BST.
   {
      return recSize(root);
   }

   public int size2()
    // Returns the number of elements in this BST.
   {
      int count = 0;
      if (root != null)
      {
         LinkedStack<BSTNode<T>> nodeStack = new LinkedStack<BSTNode<T>>();
         BSTNode<T> currNode;
         nodeStack.push(root);
         while (!nodeStack.isEmpty())
         {
            currNode = nodeStack.top();
            nodeStack.pop();
            count++;
            if (currNode.getLeft() != null)
               nodeStack.push(currNode.getLeft());
            if (currNode.getRight() != null)
               nodeStack.push(currNode.getRight());
         }
      }
      return count;
   }

   private boolean recContains(T target, BSTNode<T> node)
    // Returns true if the subtree rooted at node contains info i such that 
    // comp.compare(target, i) == 0; otherwise, returns false.
   {
      if (node == null)
         return false;       // target is not found
      else if (comp.compare(target, node.getInfo()) < 0)
         return recContains(target, node.getLeft());   // Search left subtree
      else if (comp.compare(target, node.getInfo()) > 0)
         return recContains(target, node.getRight());  // Search right subtree
      else
         return true;        // target is found
   }

   public boolean contains (T target)
    // Returns true if this BST contains a node with info i such that 
    // comp.compare(target, i) == 0; otherwise, returns false.
   {
      return recContains(target, root);
   }

   
   private T recGet(T target, BSTNode<T> node)
    // Returns info i from the subtree rooted at node such that 
    // comp.compare(target, i) == 0; if no such info exists, returns null.
   {
      if (node == null)
         return null;             // target is not found
      else if (comp.compare(target, node.getInfo()) < 0)
         return recGet(target, node.getLeft());         // get from left subtree
      else
         if (comp.compare(target, node.getInfo()) > 0)
            return recGet(target, node.getRight());        // get from right subtree
         else
            return node.getInfo();  // target is found
   }

   public T get(T target)
    // Returns info i from node of this BST where comp.compare(target, i) == 0;
    // if no such node exists, returns null.
   {
      return recGet(target, root);
   }

   private BSTNode<T> recAdd(T element, BSTNode<T> node)
    // Adds element to tree rooted at node; tree retains its BST property.
   {
      if (node == null)
         // Addition place found
         node = new BSTNode<T>(element);
      else if (comp.compare(element, node.getInfo()) <= 0)
         node.setLeft(recAdd(element, node.getLeft()));    // Add in left subtree
      else
         node.setRight(recAdd(element, node.getRight()));   // Add in right subtree
      return node;
   }

   public boolean add (T element)
    // Adds element to this BST. The tree retains its BST property.
   {
      root = recAdd(element, root);
      return true;
   }
}

  