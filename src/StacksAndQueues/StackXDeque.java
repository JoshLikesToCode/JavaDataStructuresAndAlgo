package StacksAndQueues;

/** Programming Challenge 4.3:
 * Write a program that implements a stack class that is based on the Deque class in Programming Project 4.2.
 * This stack class should have the same methods and capabilities as the StackX class in the textbook.
 * The StackX class had the following methods: push(), pop(), peek(), isEmpty()
 */
public class StackXDeque {
    static Deque deque;
    int max_size;
    int nItems;
    public StackXDeque(int s)
    {
        deque = new Deque(s);
        max_size = s;
        nItems = 0;
    }

    public boolean push(int val)
    {
        if(this.nItems == max_size)
        {
            System.out.println("StackXQueue is full.");
            return false;
        }
        deque.insertRight(val);
        nItems++;
        return true;
    }

    public boolean pop()
    {
        if(this.nItems == 0)
        {
            System.out.println("StackXQueue is empty.");
            return false;
        }
        deque.removeRight();
        nItems--;
        return true;
    }
}

class StackXDequeApp {
    public static void main(String[] args) {
        StackXDeque sxd = new StackXDeque(5);
        sxd.push(5);
        sxd.push(10);
        sxd.push(11);
        sxd.push(12);
        sxd.push(66);
        sxd.push(444);
        sxd.pop();
        sxd.pop();
        sxd.pop();
        sxd.pop();
        sxd.pop();
        sxd.pop();
    }
}
