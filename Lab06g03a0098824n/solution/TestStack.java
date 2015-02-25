import java.util.*;
import java.math.*;

public class TestStack {
  public static void main(String[] args) {
    MyStack<Integer> st = new MyStack<Integer>();
    Stack<Integer> st1 = new Stack<Integer>();
    
    int j;
    System.out.println("Fill a Java stack and MyStack with some random numbers " );
    for (int i = 0; i < 5; ++i) {
    	//generate a number from 0 to 100
    	j = (int)(Math.random()*100);
    	st.push(j);
    	st1.push(j);
    	
    }

    System.out.println("Print the 2 stacks for comparison" );
    System.out.println("API Stack: " + st1.toString());
    System.out.println("My Stack: " + st.toString());

  }
}

// Implement the following class
class MyNode<E> {
	private BigInteger priority;
	private E data;
	
	public MyNode(E node, BigInteger priorityIndex) {
		priority = priorityIndex;
		data = node;
	}
	
	public E getData() {
		return data;
	}
	
	public BigInteger getPriority() {
		return priority;
	}
	
	public String toString() {
		return data.toString();
	}
}

// Implement the comparator class needed when a PriorityQueue object is created
class ComparatorMyNode<E> implements Comparator<MyNode<E>> {
  public int compare(MyNode<E> node1, MyNode<E> node2) {
	  return node1.getPriority().compareTo(node2.getPriority());
  
  }
}  

// Implement the stack using PriorityQueue
class MyStack<E> {
  private PriorityQueue<MyNode<E>> priorityQ;
  private int MIN_SIZE = 5;
  private BigInteger priorityIndex;

  public MyStack() {
	  priorityQ = new PriorityQueue<MyNode<E>>(MIN_SIZE, new ComparatorMyNode<E>());
	  priorityIndex = new BigInteger("0");
  }
  
  public boolean isEmpty() {
	 return priorityQ.isEmpty();
  }
  
  public E push(E node) {
	  priorityIndex = priorityIndex.add(BigInteger.ONE);
	  priorityQ.offer(new MyNode<E>(node, priorityIndex));
	  return node;
  }
  
  public E peek() {
	  return priorityQ.peek().getData();
  }
  
  public E pop() {
	  priorityIndex = priorityIndex.subtract(BigInteger.ONE);
	  return priorityQ.poll().getData();
  }
  
  public String toString() {
	  MyStack<E> tempStack = new MyStack<E>();
	  E tempNode = null;
	  StringBuilder resultStr= new StringBuilder();
	  
	  while (!isEmpty()) {
		  tempNode = pop();
          tempStack.push(tempNode);
      }
	  
	  resultStr.append("[");
	  
	  while(!tempStack.isEmpty()) {
		  resultStr.append(tempStack.peek() + ", ");
		  tempStack.pop();
	  }
	  
	  resultStr.replace(resultStr.length() - 2, resultStr.length() - 1, "]");
	  return resultStr.toString();
  }
  
}


  
  