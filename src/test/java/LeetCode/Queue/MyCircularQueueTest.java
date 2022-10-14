package LeetCode.Queue;

import org.junit.Test;

import static org.junit.Assert.*;

public class MyCircularQueueTest {
    MyCircularQueue myCircularQueue = new MyCircularQueue(5);

    @Test
    public void testEnQueue() {
        while (myCircularQueue.enQueue(1)){
            System.out.println(myCircularQueue.toString());
        }
    }

    @Test
    public void testDeQueue() {
        myCircularQueue.enQueue(1);
        myCircularQueue.enQueue(1);

        while(myCircularQueue.deQueue()) {
            System.out.println(myCircularQueue.toString());
        }
    }

    @Test
    public void testFront() {
        for (int i = 0; i < myCircularQueue.capacity; i++) {
            myCircularQueue.enQueue(1);
        }
        System.out.println(myCircularQueue.toString());
        for (int i = 0; i < myCircularQueue.capacity; i++) {
            System.out.println(myCircularQueue.Front());
        }
        System.out.println(myCircularQueue.toString());
        assert(-1 == myCircularQueue.Front());
    }

    @Test
    public void testRear() {
        assert(myCircularQueue.isEmpty());
        for (int i = 0; i < myCircularQueue.capacity; i++) {
            myCircularQueue.enQueue(i+1);
        }
        System.out.println(myCircularQueue.toString());
        assert myCircularQueue.isFull();
        for (int i = 0; i < myCircularQueue.capacity; i++) {
            System.out.println(myCircularQueue.Rear());
        }
        System.out.println(myCircularQueue.toString());
        assert(myCircularQueue.isEmpty());
    }

    @Test
    public void test5() {
        MyCircularQueue myCircularQueue1 = new MyCircularQueue(3);
        myCircularQueue1.enQueue(1);
        myCircularQueue1.enQueue(2);
        System.out.println(myCircularQueue1.enQueue(3));
        System.out.println(myCircularQueue1.enQueue(4));
        System.out.println(myCircularQueue1.isFull());
        System.out.println(myCircularQueue1.Rear());
        System.out.println(myCircularQueue.isFull());
        myCircularQueue1.deQueue();
        System.out.println(myCircularQueue1.toString());
        System.out.println(myCircularQueue1.enQueue(5));
    }
}