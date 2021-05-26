package ArraysAndSorts;/*
    Exercise 3.1:
        In the bubblesort() the in index always goes from left to right, finding the largest item and carrying
        it toward out on the right. Modify the bubbleSort() method so that it's bidirectional. This means the in
        index will first carry the largest item from left to right as before, but when it reaches out, it will
        reverse and carry the smallest item from right to left. You'll need two outer indexes, one on the right
        (the old out) and another on the left.

        Exercise 3.4:
        Another simple sort is the odd-even sort. The idea is to repeatedly make two passes through the array. On the
        first pass you look at all the pairs of items, a[j] and a[j+1], where j is odd (j = 1, 3, 5...). If their key
        values are out of order, you swap them. One the second pass you do the same for all the even values (j = 2, 4, 6...).
        You do these two passes repeatedly until the array is sorted. Replace the bubbleSort() method with an oddEvenSort()
        method. Make sure it works for varying amounts of data. You'll need to figure out how many times to do the two passes.
        The odd-even sort is actually useful in a multiprocessor environment, where a separate processor can operate on each
        odd pair simultaneously and then on each even pair. Because the odd pairs are independent of each other, each pair
        can be checked - and swapped, if necessary - by a different processor. This makes for a very fast sort.
 */

public class ArrayBub {
    private long[] a;
    private int nElems;

    // ctor
    public ArrayBub(int max)
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
        {
            System.out.print(a[j] + " ");
        }
        System.out.println("");
    }

    private void swap(int one, int two)
    {
        long temp = a[one];
        a[one] = a[two];
        a[two] = temp;
    }

    public void bubbleSort()
    {
        int out, in;

        for(out = nElems - 1; out > 1; out--)
        {
            for(in = 0; in < out; in++)
            {
                if(a[in] > a[in+1])
                {
                    swap(in, in+1);
                }
            }
        }
    }

    /** Exercise 3.1:
    In the bubblesort() the in index always goes from left to right, finding the largest item and carrying
    it toward out on the right. Modify the bubbleSort() method so that it's bidirectional. This means the in
    index will first carry the largest item from left to right as before, but when it reaches out, it will
    reverse and carry the smallest item from right to left. You'll need two outer indexes, one on the right
            (the old out) and another on the left. */
    public void exercise_bubbleSort()
    {
        int out = nElems - 1, in, left_out = 0;
        boolean swap = true;

        while(swap) {
            swap = false;

            for(in = left_out; in < out; in++)
            {
                if(a[in] > a[in+1])
                {
                    swap(in, in+1);
                    swap = true;
                }
            }

            for(in = out-1; in > left_out; in--)
            {
                if(a[in] < a[in-1])
                {
                    swap(in, in-1);
                    swap = true;
                }
            }

            left_out++;
            out--;
        }
    }

    /**
     *         Exercise 3.4:
     *         Another simple sort is the odd-even sort. The idea is to repeatedly make two passes through the array. On the
     *         first pass you look at all the pairs of items, a[j] and a[j+1], where j is odd (j = 1, 3, 5...). If their key
     *         values are out of order, you swap them. One the second pass you do the same for all the even values (j = 2, 4, 6...).
     *         You do these two passes repeatedly until the array is sorted. Replace the bubbleSort() method with an oddEvenSort()
     *         method. Make sure it works for varying amounts of data. You'll need to figure out how many times to do the two passes.
     *         The odd-even sort is actually useful in a multiprocessor environment, where a separate processor can operate on each
     *         odd pair simultaneously and then on each even pair. Because the odd pairs are independent of each other, each pair
     *         can be checked - and swapped, if necessary - by a different processor. This makes for a very fast sort.
     */
    public void odd_even_sort() {
        boolean swap = true;

        while(swap)
        {
            swap = false;

            for(int in = 1; in < nElems - 1; in += 2)
            {
                if(a[in] > a[in+1])
                {
                    swap(in, in+1);
                    swap = true;
                }
            }

            for(int in = 0; in < nElems - 1; in += 2)
            {
                if(a[in] > a[in+1])
                {
                    swap(in, in+1);
                    swap = true;
                }
            }
        }
    }
}

class BubbleSortApp{
    public static void main(String[] args)
    {
        int maxSize = 100;
        ArrayBub arr;
        arr = new ArrayBub(maxSize);

        arr.insert(77);
        arr.insert(99);
        arr.insert(44);
        arr.insert(55);
        arr.insert(22);
        arr.insert(88);
        arr.insert(11);
        arr.insert(00);
        arr.insert(66);
        arr.insert(33);
        arr.display();

        //arr.bubbleSort();
        arr.odd_even_sort();
        arr.display();
    }
}
