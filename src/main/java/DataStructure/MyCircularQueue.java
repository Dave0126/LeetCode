package DataStructure;

import java.util.Arrays;

/**
 * @Authur Guohao
 * @Date 2022-10-07
 *
 * 自定义一个循环队列，循环队列是一种线性数据结构，其操作表现基于 FIFO（先进先出）原则并且队尾被连接在队首之后以形成一个循环。
 * 它也被称为“环形缓冲器”。
 * 循环队列的一个好处是我们可以利用这个队列之前用过的空间。
 * 在一个普通队列里，一旦一个队列满了，我们就不能插入下一个元素，即使在队列前面仍有空间。
 * 但是使用循环队列，我们能使用这些空间去存储新的值。
 *
 * 我定义这个循环队列有四个状态：
 *      1 空状态：即初始状态。说明循环队列里没有元素，head与tail索引都指向-1；
 *      2 只有一个元素：即(head == tail)。说明循环队列里只有一个函数，即head与tail共同指向的元素；
 *      3 拥有若干元素：即head与tail之间有若干个元素；
 *      4 满状态：即(tail+1)%capacity == head。在循环队列中，说明该队列已满
 *
 * 这个循环队列的状态变化如下所示：
 *
 *      [空状态] --首次添加元素--> [单元素状态] --添加若干元素--> [若干元素状态] --添加一个元素--> [满状态]
 *
 *      [空状态] <--删除最后一个元素-- [单元素状态] <--删除若干元素-- [若干元素状态] <--删除一个元素-- [满状态]
 *
 * @parameter capacity  该循环队列的容量
 * @parameter queue     用来存贮该循环队列元素的数组
 * @parameter head      指向队列头元素的索引
 * @paramrter tail      指向队列尾元素的索引
 */

public class MyCircularQueue {
    int capacity;
    int[] queue;
    int head = -1;               // index of the head
    int tail = -1;               // index of the tail

    /**
     * 该循环队列的构造器
     * @param k     传入该循环队列的容量
     */
    public MyCircularQueue(int k) {
        this.capacity = k;
        this.queue = new int[k];
    }

    /**
     * 向循环队列的尾部添加元素
     * @param value 添加元素的值
     * @return  是否添加成功
     */
    public boolean enQueue(int value) {
        // 初始化状态，将两个指针统一指向首个元素：初始化状态 -> 已有一个元素
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
        if (isEmpty()) {
            return -1;
        }
        return queue[head];
    }

    public int Rear() {
        if(isEmpty()) {
            return -1;
        }
        return queue[tail];
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
