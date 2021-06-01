package StacksAndQueues;

/** Programming Challenge 4.3:
 * Write a program that implements a stack class that is based on the Deque class in Programming Project 4.2.
 * This stack class should have the same methods and capabilities as the StackX class in the textbook.
 * The StackX class had the following methods: push(), pop(), peek(), isEmpty()
 */
public class StackXDeque extends Deque {

    public StackXDeque(int s) {
        super(s);
    }

    public void push(long val)
    {
        if(super.isFull())
        {
            System.out.println("StackXDeque is full.");
            return;
        }
        super.insertLeft(val);
    }

    public boolean pop()
    {
        //System.out.println(super.getRight());
        //System.out.println(super.getLeft());
        if(isEmpty())
        {
            System.out.println("StackXDeque is empty.");
            return false;
        }


        // need to figure out below
        else if(super.getRight() < 0)
        {
            super.removeLeft();
            return true;
        }
        else
        {
            super.removeRight();
            return true;
        }
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
    }
}
