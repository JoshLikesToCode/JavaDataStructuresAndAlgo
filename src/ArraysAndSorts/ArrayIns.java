package ArraysAndSorts;/*
    Exercise 3.2:
        Add a method called median() to the ArraysAndSorts.ArrayIns class. This method should return the median value in the array.
        Recall that in a group of numbers, half are larger than the median and half are smaller.) Do it the easy way.

    Exercise 3.3:
        Add a method called noDups() that removes duplicates from a previously sorted array without disrupting the order.
        (You can use insertionSort() method to sort the data, or you can simply use main() to insert the data in sorted
        order.) One can imagine schemes in which all the items from the place where a duplicate was discovered to the end
        of the array would be shifted down one space everytime a duplicate was discovered, but this would lead to slow
        O(N^2) time, at least when there were a lot of duplicates. In your algorithm, make sure no item is moved more
        than once, no matter how many duplicates there are. This will give you an algorithm with O(N) time.

    Exercise 3.5:
        Modify the insertionSort() method so it counts the number of copies and the number of comparisons it makes during
        a sort and displays the totals. To count the comparisons, you'll need to break up the double condition in the inner
        while loop. Use this program to measure the number of copies and comparisons for different amounts of inversely
        sorted data. Do the results verify O(N^2) efficiency? Do the same for almost-sorted dat (only a few items out
        of place.) What can you deduce about the efficiency of this algorithm for almost-sorted data?

    Exercise 3.6:
        Here's an interesting way to remove duplicates from an array. The insertion soert uses a loop-within-a-loop algorithm
        that compares every item in the array with every other item. If you want to remove duplicates, this is one way to start.
        Modify the insertionSort() method so that it removes duplicates as it sorts. Here's one approach: When a duplicate is
        found, write over one of the duplicates items with a key value less than any normally used (such as -1, if all the normal
        keys are positive). Then the normal insertion sort algorithm, treating this new key like any other item, will put it at
        index 0. From now on the algorithm can ignore this item. The next duplicate will go at index 1, and so on. When the sort
        is finished, all the removed dupes (now represented by -1 values) will be found at the beginning of the array. The array
        can then be resized and shifted down so it starts at 0.
 */


public class ArrayIns {
    private long[] a;
    private int nElems;

    public ArrayIns(int max)
    {
        a = new long[max];
        nElems = 0;
    }

    public void insert(long value)
    {
        a[nElems] = value;
        nElems++;
    }

    public void display()
    {
        for(int j = 0; j < nElems; j++)
            System.out.print(a[j] + " ");
        System.out.println("");
    }

    public void insertionSort()
    {
        int in, out;

        for(out = 1; out < nElems; out++)       // out is the dividing line
        {
            long temp = a[out];                 // remove marked item
            in = out;                           // start shifts at out
            while(in > 0 && a[in-1] >= temp)    // until one is smaller,
            {
                a[in] = a[in-1];                // shift item to right
                --in;                           // go left one position
            }
            a[in] = temp;                       // insert marked item
        }
    }

    /**
     *     Exercise 3.5:
     *         Modify the insertionSort() method so it counts the number of copies and the number of comparisons it makes during
     *         a sort and displays the totals. To count the comparisons, you'll need to break up the double condition in the inner
     *         while loop. Use this program to measure the number of copies and comparisons for different amounts of inversely
     *         sorted data. Do the results verify O(N^2) efficiency? Do the same for almost-sorted dat (only a few items out
     *         of place.) What can you deduce about the efficiency of this algorithm for almost-sorted data?
     */
    public void modified_insertionSort()
    {
        int in, out;
        int num_of_copies = 0, num_of_comp = 0;

        for(out = 1; out < nElems; out++)       // out is the dividing line
        {
            long temp = a[out];                 // remove marked item
            in = out;                           // start shifts at out
            while(in > 0 && a[in-1] >= temp)    // until one is smaller,
            {
                a[in] = a[in - 1];                // shift item to right
                num_of_copies++;
                num_of_comp++;
                --in;                           // go left one position
            }
            num_of_comp++;
            a[in] = temp;                       // insert marked item
            num_of_copies++;
        }
        System.out.println("Input = " + this.nElems);
        System.out.println("Number of copies = " + num_of_copies);
        System.out.println("Number of comparisions = " + num_of_comp);
    }

    /**
     * Exercise 3.6:
     *         Here's an interesting way to remove duplicates from an array. The insertion soert uses a loop-within-a-loop algorithm
     *         that compares every item in the array with every other item. If you want to remove duplicates, this is one way to start.
     *         Modify the insertionSort() method so that it removes duplicates as it sorts. Here's one approach: When a duplicate is
     *         found, write over one of the duplicates items with a key value less than any normally used (such as -1, if all the normal
     *         keys are positive). Then the normal insertion sort algorithm, treating this new key like any other item, will put it at
     *         index 0. From now on the algorithm can ignore this item. The next duplicate will go at index 1, and so on. When the sort
     *         is finished, all the removed dupes (now represented by -1 values) will be found at the beginning of the array. The array
     *         can then be resized and shifted down so it starts at 0.
     */
    public void noDups_insertionSort()
    {
        int in, out;
        int noDups = 0;

        for(out = 1; out < nElems; out++)
        {
            long temp = a[out];
            in = out;

            while(in > 0 && a[in-1] >= temp)
            {
                if(a[in-1] == temp)
                {
                    temp = -1;
                    noDups++;
                }
                a[in] = a[in-1];
                --in;
            }
            a[in] = temp;
        }

        /* removed marked dupes */
        if(noDups != 0)
        {
            for(int i = noDups; i < nElems; i++)
            {
                a[i - noDups] = a[i];
            }
        }
        nElems -= noDups;
    }

    /**
     * Exercise 3.2 : median() function
     * @return the median value of the array
     */
    public long median()
    {
        if(nElems % 2 == 0) {
            return a[(nElems / 2) - 1];
        } else
        {
            return a[(nElems / 2)];
        }
    }

    /** Helper function for Exercise 3.3: noDups() below
     * @param index for element that needs to be deleted from array
     */
    public void delete(int index)
    {
        for(int k = index; k < nElems; k++)
            a[k] = a[k+1];
        nElems--;
    }

    /**
     * Exercise 3.3: noDups() function
     */
    public void noDups()
    {
        for(int i = 0; i < nElems; i++)
        {
            long temp = a[i];
            for(int j = i+1; j < nElems - 1; j++)
            {
                if(a[j] == a[i])
                {
                    this.delete(j);
                    nElems--;
                }
            }
        }
    }
}

class InsertSortApp
{
    public static void main(String[] args)
    {
        int maxSize = 100;
        ArrayIns arr;
        arr = new ArrayIns(maxSize);

        arr.insert(77);
        arr.insert(77);
        arr.insert(99);
        arr.insert(44);
        arr.insert(55);
        arr.insert(55);
        arr.insert(22);
        arr.insert(88);
        arr.insert(11);
        arr.insert(00);
        arr.insert(66);
        arr.insert(33);
        arr.insert(12);
        arr.insert(12);

        arr.noDups_insertionSort();
        arr.display();

        System.out.println("Array median = " + arr.median());
        //arr.noDups();
        //arr.display();

        arr.insertionSort();
        arr.modified_insertionSort();
        arr.display();
    }
}
