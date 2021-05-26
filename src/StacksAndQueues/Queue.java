package StacksAndQueues;

import ArraysAndSorts.ArrayBub;

public class Queue {
    private int maxSize;
    private long[] queArray;
    private int front;
    private int rear;
    private int nItems;

    // ctor
    public Queue(int s) {
        maxSize = s;
        queArray = new long[maxSize];
        front = 0;
        rear = -1;
        nItems = 0;
    }

    public void insert(long j) {
        if (rear == maxSize - 1) // deal with wrap around
            rear = -1;
        queArray[++rear] = j;   // increment rear and insert
        nItems++;               // one more time
    }

    // take item from front of queue
    public long remove() {
        long temp = queArray[front++];  // get value and increment front
        if (front == maxSize)            // deal with wrap around
            front = 0;
        nItems--;                       // one less item
        return temp;
    }

    // peek at top of queue
    public long peekFront() {
        return queArray[front];
    }

    // true if queue is empty
    public boolean isEmpty() {
        return (nItems == 0);
    }

    // true if queue is full
    public boolean isFull() {
        return (nItems == maxSize);
    }

    public int size() {
        return nItems;
    }

    /** PROGRAMMING CHALLENGE 4.1:
     * Write a method for the Queue class that displays the contents of the queue. Note that this does not mean
     * simply displaying the contents of the underlying array. You should show the queue contents from the first item
     * inserted to the last, without indicating to the viewer whether the sequence is broken by wrapping around the
     * end of the array. Be careful that one item and no items display properly, no matter where front and rear are.
     */
    public void display()
    {
        // case to handle wrap around
        if(front > rear) {
            // to handle the front until wrap around
            for (int i = front - 1; i <= nItems; i++) {
                System.out.print(queArray[i]);
                System.out.print(" ");
            }
            // to handle from wrap around to rear
            for (int i = 0; i < front - 1; i++) {
                System.out.print(queArray[i]);
                System.out.print(" ");
            }
        }
        else
        {
            // We can display the queue normally
            for(int i = front; i <= rear; i++)
                System.out.println(queArray[i] + " ");
            System.out.println("");
        }
    }
}

class QueueApp {
    public static void main(String[] args) {
        Queue theQueue = new Queue(5);      // queue holds 5 items
        theQueue.insert(10);                // insert 4 items
        theQueue.insert(20);
        theQueue.insert(30);
        theQueue.insert(40);

        theQueue.display();

        theQueue.remove();
        theQueue.remove();
        theQueue.remove();
        theQueue.remove();

        theQueue.insert(50);                // insert 4 more items (wraps around);
        theQueue.insert(60);
        theQueue.insert(70);
        theQueue.insert(80);

        theQueue.display();

        /*while (!theQueue.isEmpty())          // remove and display
        {
            long n = theQueue.remove();         // (40, 50, 60, 70, 80);
            System.out.print(n);
            System.out.print(" ");
        }*/
        System.out.println("");
    }
}


