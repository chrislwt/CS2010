import java.util.Scanner;
import java.util.Random;
import java.util.PriorityQueue;
import java.util.*;

public class TopK
{
  //Assume earners need at least $0 and at the most $500,000,000 as salary
  private static final int MAX = 500000000;
  private static final int MIN = 0;

  //override the default comparator and create a new one which sorts in descending order
   private static class salaryComparator implements Comparator<Integer> {
     public int compare(Integer salary1, Integer salary2) {
        return salary2 - salary1;
     }
   }
   
  public static void main( String [ ] args )
  {
    long startTime = System.currentTimeMillis();
    Scanner sc = new Scanner(System.in);
    Random randomNumber = new Random();

    System.out.print("Enter m value: ");
    int m = sc.nextInt();
    if(m < 0)
      throw new IllegalArgumentException("Invalid input.");
    if(m > 1000000)
      throw new IllegalArgumentException("Salary earners cannot exceed 1000000");
    
    System.out.print("Enter k value: ");
    int k = sc.nextInt();
    
    if(k < 0)
      throw new IllegalArgumentException("Invalid input.");
    
    if(k > 100)
      throw new IllegalArgumentException("Top k of the salary earners cannot exceed 100");
    
    if(k > m)
      throw new IllegalArgumentException("Top k of salary earners cannot exceed the total number of salary earners");
    
    PriorityQueue<Integer> queue = new PriorityQueue<Integer>(m, new salaryComparator());
    
    //System.out.println("All earners: ");
    for(int i = 0; i < m ; i++) {
      int randomNum = randomNumber.nextInt((MAX - MIN) + 1) + MIN;
      //System.out.println(randomNum);
      queue.add(randomNum);
    }
    
    System.out.println("Top k values: ");
    for(int i = 0; i < k; i++) {
      int value = queue.poll();
      System.out.println(value);
    }

    System.out.println("Time taken:  " + (System.currentTimeMillis() - startTime) + "ms");
  } 
}