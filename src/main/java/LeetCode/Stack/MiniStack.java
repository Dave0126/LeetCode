package LeetCode.Stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author Guohao
 * @Date 2022-10-10
 * @Despristion
 */

class MinStack {
    private List<Integer> data;

    public MinStack() {
        data = new ArrayList<>();
    }

    public void push(int val) {
        data.add(val);
    }

    public void pop() {
        if (isEmpty()) {
            return;
        }
        data.remove(data.size()-1);
    }

    public int top() {
        if(isEmpty()) {
            return -1;
        }
        return data.get(data.size()-1);
    }

    public int getMin() {
        List<Integer> sortVal = new ArrayList<>();
        sortVal.addAll(data);
        sortVal.sort((obj1, obj2) -> (obj1.compareTo(obj2)));
        return sortVal.get(0);
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public String toString() {
        return "MinStack{" +
                "data=" + Arrays.toString(data.toArray()) +
                "\t min=" + getMin() +
                '}';
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
