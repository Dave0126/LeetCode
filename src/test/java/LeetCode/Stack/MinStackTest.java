package LeetCode.Stack;

import org.junit.Test;

import static org.junit.Assert.*;

public class MinStackTest {

    MinStack minStack = new MinStack();

    @Test
    public void testCreateMinStack() {
        System.out.println(minStack.toString());
    }

    @Test
    public void testPushAndPop() {
        minStack.push(-1);
        minStack.push(23);
        minStack.push(-9);
        System.out.println(minStack.toString());
        minStack.pop();
        System.out.println(minStack.toString());
    }

    @Test
    public void testTop() {
        minStack.push(-1);
        minStack.push(23);
        minStack.push(-9);
        System.out.println(minStack.toString());
        assert minStack.top() == -9;
        System.out.println(minStack.toString());
    }

    @Test
    public void testGetMin() {
        minStack.push(-1);
        minStack.push(23);
        minStack.push(-9);
        assert minStack.getMin() == -9;
        minStack.pop();
        assert minStack.getMin() == -1;
        System.out.println(minStack.toString());
    }

}