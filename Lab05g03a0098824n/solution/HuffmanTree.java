import java.io.*;
import java.util.Scanner;
import java.util.PriorityQueue;
import java.util.Comparator;

/**
 *  Class to test the HuffmanTree class
 */
public class HuffmanTree {
  
  private static BinaryTree<LabelFreq> huffmanTree;
  
  //override the default comparator and create a new one which sorts only frequency in ascending order
  private static class freqComparator implements Comparator<BinaryTree<LabelFreq>> {
     public int compare(BinaryTree<LabelFreq> leftSub, BinaryTree<LabelFreq> rightSub) {
        return Integer.compare(leftSub.getData().freq, rightSub.getData().freq);
     }
   }
  
  public static void buildHuffmanTree(PriorityQueue<BinaryTree<LabelFreq>> charQueue) {
    int i = 1;
    while(charQueue.size() > 1) {
      BinaryTree<LabelFreq> leftSub = charQueue.poll();
      BinaryTree<LabelFreq> rightSub = charQueue.poll();
      LabelFreq huffData = new LabelFreq("T"+i, leftSub.getData().freq + rightSub.getData().freq);
      BinaryTree<LabelFreq> newTree = new BinaryTree<LabelFreq>(huffData, leftSub, rightSub);
      charQueue.offer(newTree);
      i++;
    }
    huffmanTree = charQueue.poll();
  }
  
  public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);
    PriorityQueue<BinaryTree<LabelFreq>> charList = new PriorityQueue<BinaryTree<LabelFreq>>(10, new freqComparator());
    while(sc.hasNextLine()) {
      String labelInput = sc.next();
      if(labelInput.equals("exit")) {
        buildHuffmanTree(charList);
        System.out.println(huffmanTree.preorderToString()); 
        break;
      }
      else {
        int labelFreq = sc.nextInt();
        LabelFreq input = new LabelFreq(labelInput, labelFreq);
        BinaryTree<LabelFreq> tree  = new BinaryTree<LabelFreq>(input,null,null);
        charList.offer(tree);
      }
    }//end of while 
    
    
    
  }//end of main

}//end of class


