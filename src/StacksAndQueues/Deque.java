package StacksAndQueues;

/** PROGRAMMING CHALLENGE 4.2:
 * Create a Deque class, based on the discussion of dequeues (double-ended queues) in this chapter. It should include
 * insertLeft(), insertRight(), removeLeft(), removeRight(), isEmpty(), and isFull() methods. It will need to support
 * wrap around at the end of the array, as queues do.
 */


public class Deque {
    private int left;
    private int right;
    private int nItems;
    private int maxSize;
    private long[] deqArr;

    public Deque(int s) {
        maxSize = s;
        deqArr = new long[s];
        left = -1;
        right = 0;
        nItems = 0;
    }

    public boolean insertLeft(long val) {
        if(isFull())
        {
            System.out.println("Overflow from inserting left.");
            return false;
        }
        // if dequeue is initially empty
        if(left == -1)
        {
            left = 0;
            right = 0;
        }
        else if(left == 0)
            left = maxSize - 1;
        else
            left--;

        deqArr[left] = val;
        nItems++;
        System.out.println("Inserted " + deqArr[left] + " to the left.");
        return true;
    }

    public boolean insertRight(long val) {
        if(isFull())
        {
            System.out.println("Overflow from inserting right.");
            return false;
        }
        // if dequeue is initially empty
        if(left == -1)
        {
            left = 0;
            right = 0;
        }
        else if(right == maxSize - 1)
            right = 0;
        else
            right++;

        deqArr[right] = val;
        nItems++;
        System.out.println("Inserted " + deqArr[right] + " to the right.");
        return true;
    }

    public boolean removeLeft() {
        if (nItems == 0) {
            System.out.println("Deque is empty.");
            return false;
        }
        System.out.println("Removing " + deqArr[left] + " from the left.");
        left++;
        nItems--;
        return true;
    }

    public boolean removeRight()
    {
        if(nItems == 0)
        {
            System.out.println("Deque is empty");
            return false;
        }
        System.out.println("Removing " + deqArr[right] + " from the right.");
        right--;
        nItems--;
        return true;
    }


    public boolean isEmpty()
    {
        if(nItems == 0)
            return true;
        return false;
    }

    public boolean isFull()
    {
        if(nItems == maxSize)
            return true;
        return false;
    }

   public void display()
    {
        System.out.print("Queue currently holds = ");
        for(int i = left; i <= right; i++)
        {
            System.out.print(deqArr[i] + " ");
        }
        System.out.println("");
    }
}

class DequeApp {
    public static void main(String[] args) {
        Deque q = new Deque(5);
        q.insertRight(10);
        q.insertRight(20);
        q.insertRight(30);
        q.insertRight(40);
        q.insertRight(50);
        q.insertRight(60);

        q.display();

        q.removeLeft();
        q.removeLeft();

        q.removeRight();
        q.removeLeft();

        q.display();

        q.insertLeft(10);
        q.insertLeft(20);
        q.insertLeft(80);
        q.display();
        q.insertLeft(70);
        q.insertRight(60);
    }
}

