package LeetCode.Queue;

import java.util.Arrays;

public class MyCircularQueue {
    /**
     * Your MyCircularQueue object will be instantiated and called as such:
     * MyCircularQueue obj = new MyCircularQueue(k);
     * boolean param_1 = obj.enQueue(value);
     * boolean param_2 = obj.deQueue();
     * int param_3 = obj.Front();
     * int param_4 = obj.Rear();
     * boolean param_5 = obj.isEmpty();
     * boolean param_6 = obj.isFull();
     */
    int capacity;
    int[] queue;
    int head = -1;               // index of the head
    int tail = -1;               // index of the tail

    public MyCircularQueue(int k) {
        this.capacity = k;
        this.queue = new int[k];
    }

    public boolean enQueue(int value) {
        // 初始化状态，将两个指针统一指向首个元素
        if(isEmpty()) {
            head = 0;
            tail = 0;
            queue[tail] = value;
            return true;
        }

        // 队列里已经满，禁止添加
        if(isFull()) {
            return false;
        }

        tail = (tail+1) % capacity;
        queue[tail] = value;
        return true;
    }

    public boolean deQueue() {
        // 是否为初始状态
        if(isEmpty()) {
            return false;
        }

        // 如果两个指针相等，说明队列中只剩这两个指针所指的元素了
        // 将其退回为初始状态，说明队列中没有元素了
        if (head == tail) {
            head = -1;
            tail = -1;
            return true;
        }

        // 其他正常情况
        head = (head+1) % capacity;
        return true;
    }

    public int Front() {
        int res;
        if (isEmpty()) {
            return -1;
        }
        res = queue[head];
        deQueue();
        return res;
    }

    public int Rear() {
        int res;
        if(isEmpty()) {
            return -1;
        }
        res = queue[tail];

        if (head == tail) {
            head = -1;
            tail = -1;
        }
        else {
            tail = (tail-1) % capacity;
        }
        return res;
    }

    public boolean isEmpty() {
        return tail ==-1 && head==-1;
    }

    public boolean isFull() {
        return (tail+1) % capacity == head;
    }

    @Override
    public String toString() {
        return "MyCircularQueue{" +
                "  queue=" + Arrays.toString(queue) +
                ", head=" + head +
                ", tail=" + tail +
                '}';
    }
}
