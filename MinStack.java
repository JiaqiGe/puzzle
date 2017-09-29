// 实现一个栈（元素遵守先入后出顺序），能够通过 min 方法在 O(1)时间内获取栈中的最小元素。同时，栈的基本操作：入栈(Push)、出栈(Pop)，也是在O(1)时间内完成的。
//

import java.util.*;

public class MinStack{
  Stack<Integer> stack;
  Stack<Integer> minStack;

  public MinStack(){
    this.stack = new Stack<>();
    this.minStack = new Stack<>();
  }

  public void push(int val){
    // push to stack
    stack.push(val);

    // update minStack
    if(minStack.isEmpty() || minStack.peek() > val){
      minStack.push(val);
    }
  }

  public int pop(){
    if(stack.peek() == minStack.peek()){
      minStack.pop();
    }
    return stack.pop();
  }

  public int getMin(){
    return minStack.peek();
  }

  public static void main(String[] args){
    MinStack m = new MinStack();
    m.push(1);
    m.push(2);
    m.push(3);
    m.push(0);
    System.out.println(m.getMin());
    m.pop();
    System.out.println(m.getMin());
    m.push(-1);
    System.out.println(m.getMin());
    
  }
}
