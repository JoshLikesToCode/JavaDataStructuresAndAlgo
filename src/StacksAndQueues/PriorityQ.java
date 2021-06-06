package StacksAndQueues;

import javax.management.remote.rmi._RMIConnection_Stub;

public class PriorityQ {
    // array in sorted order, from max at 0 to min at size - 1
    private int maxSize;
    private long[] queArray;
    private int nItems;

    public PriorityQ(int s)
    {
        maxSize = s;
        queArray = new long[maxSize];
        nItems = 0;
    }

    public void original_insert(long item)
    {
        int j;

        if(nItems == 0)                             // if no items,
            queArray[nItems++] = item;              // insert at 0
        else                                        // if items,
        {
            for(j = nItems-1; j >= 0; j--)          // start at end,
            {
                if (item > queArray[j])             // if new item is larger,
                {
                    queArray[j + 1] = queArray[j];    // then shift upward
                } else                                // if smaller,
                {
                    break;                          // done shifting
                }
            }
                queArray[j+1] = item;               // insert it
                nItems++;
        }                                           // end else
    }                                               // end insert

    public long original_remove()
    {
        return queArray[--nItems];
    }

    public long peekMin()
    {
        return queArray[nItems-1];
    }

    public boolean isEmpty()
    {
        return (nItems==0);
    }

    public boolean isFull()
    {
        return (nItems==maxSize);
    }

    /**
     * PROGRAMMING CHALLENGE 4.4:
     * The PriorityQ shown above features fast removal of the high-priority item but slow insertion of new items.
     * Write a program with a revised PriorityQ class that has O(1) insertion time but slower removal of the
     * high-priority item. Include a method that displays the contents of the priority queue.
     */
    public void new_insert(long value)
    {
        queArray[nItems++] = value;
    }

    public long new_remove()
    {
        if(nItems == 0)
        {
            System.out.println("PriorityQ is empty.");
            return -1;
        }
       for(int i = 0; i < nItems - 1; i++)
       {
           int min_index = i;
           for(int j = i+1; j < nItems; j++) {
               if (queArray[j] < queArray[min_index])
               {
                   min_index = j;
               }
           }
           long temp = queArray[min_index];
           queArray[min_index] = queArray[i];
           queArray[i] = temp;
       }
       return queArray[maxSize-(nItems--)];
    }
}

class PriQApp
{
    public static void main(String[] args) {
        /*PriorityQ thePQ = new PriorityQ(5);
        thePQ.original_insert(30);
        thePQ.original_insert(50);
        thePQ.original_insert(10);
        thePQ.original_insert(40);
        thePQ.original_insert(20);

        while( !thePQ.isEmpty() )
        {
            long item = thePQ.original_remove();
            System.out.println(item + " "); // 10, 20, 30, 40, 50
        }
        System.out.println(" ");
   }*/
        PriorityQ thePQ = new PriorityQ(5);
        thePQ.new_insert(30);
        thePQ.new_insert(50);
        thePQ.new_insert(10);
        thePQ.new_insert(40);
        thePQ.new_insert(20);

        while (!thePQ.isEmpty()) {
            long item = thePQ.new_remove();
            System.out.println(item + " "); // 10, 20, 30, 40, 50
        }
        System.out.println(" ");
    }
}
