package algorithms.epi.stacks;

import java.util.AbstractMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by saima_000 on 2/6/2017.
 *
 * https://github.com/adnanaziz/epicode/blob/master/java/src/main/java/com/epi/StackWithMaxImproved.java
 * TODO : Implement the same with Deque
 */
public class MaxInStack {
    int[] data;
    int top;
    Stack<AbstractMap.SimpleEntry<Integer, Integer>> maxStack = new Stack<AbstractMap.SimpleEntry<Integer, Integer>>();

    public MaxInStack() {
        data = new int[1];
        top = -1;
    }

    public void push(int n) {
        if(top == data.length-1) {
            int[] newArray = new int[data.length * 2];
            for(int i=0;i<data.length;i++)
                newArray[i] = data[i];
            data = newArray;
        }
        if(top == -1) {
            data[++top] = n;
            maxStack.push(new AbstractMap.SimpleEntry<Integer, Integer>(n, 1));
            return;
        }
        data[++top] = n;
        if(n == maxStack.peek().getKey()) {
            maxStack.peek().setValue(maxStack.peek().getValue() + 1);
        }
        else if(n > maxStack.peek().getKey()) {
            maxStack.push(new AbstractMap.SimpleEntry<Integer, Integer>(n, 1));
        }
    }

    public int pop() throws Exception {
        if(top == -1)
            throw new Exception("Stack is empty!");
        if(data[top] == maxStack.peek().getKey()) {
            if(maxStack.peek().getValue() == 1)
                maxStack.pop();
            else
                maxStack.peek().setValue(maxStack.peek().getValue() - 1);
        }
        return data[top--];
    }

    public int max() throws Exception {
        if(top == -1)
            throw new Exception("Stack is empty!");
        return maxStack.peek().getKey();
    }

    public int size() {
        return top + 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public static void main(String[] args) throws Exception {
        int[] input = new int[]{2, 2, 1, 4, 5, 5, 3};
        MaxInStack stack = new MaxInStack();
        for(int i = 0; i < input.length; i++) {
            stack.push(input[i]);
            System.out.println("Element " + input[i] + " pushed into the stack. Max in stack is " + stack.max());
        }

        for(int i = 0; i < input.length; i++) {
            System.out.println("Element " + stack.pop() + " popped out of the stack. Max in stack is " + stack.max());
        }
    }
}
