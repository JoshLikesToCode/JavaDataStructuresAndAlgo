/********************************************
 * Programming Projects 2.4 - 2.6
 *
 * Exercise 2.4: Modify the orderedArray.java program so that the insert() and the
 * delete() routines, as wel as the find(), use a binary search as suggested in the text.
 *
 * Exercise 2.5: add a merge() method so that you can merge two ordered source arrays into
 * an ordered destination array. In your algorithm, you will need to compare the keys of the
 * two source arrays, picking the smallest one to copy to the destination. You'll also need to
 * handle the situation when one source array exhausts it's contents before the other.
 */

public class OrdArray {
    private long[] a;
    private int nElems;

    // constructor
    public OrdArray(int max)
    {
        a = new long[max];
        nElems = 0;
    }

    // get array size
    public int size()
    {
        return nElems;
    }

    // find specific value
    public int find(long searchKey) {
        int lowerBound = 0;
        int upperBound = nElems - 1;
        int curIn;

        while (true)
        {
            curIn = (lowerBound + upperBound) / 2;
            if(a[curIn] == searchKey)
                return curIn;                       // found it
            else if(lowerBound > upperBound)
                return nElems;                      // cant find it
            else                                    // divide range
            {
                if(a[curIn] < searchKey)
                    lowerBound  = curIn + 1;        // it's in upper half
                else
                    upperBound = curIn - 1;         // it's in lower half
            }
        }
    }

    public void insert(long value)
    {
        int j;
        for(j = 0; j < nElems; j++)
            if(a[j] > value)
                break;
        for(int k = nElems; k > j; k--)
            a[k] = a[k-1];
        a[j] = value;
        nElems++;
    }

    public boolean delete(long value)
    {
        int j = find(value);
        if(j == nElems)
            return false;
        else
        {
            for(int k = j; k < nElems; k++)
                a[k] = a[k+1];
            nElems--;
            return true;
        }
    }

    public void display()
    {
        for(int j = 0; j < nElems; j++)
            System.out.println(a[j] + " ");
        System.out.println("");
    }
}

class OrderedApp
{
    public static void main(String[] args)
    {
        int maxSize = 100;
        OrdArray arr;
        arr = new OrdArray(maxSize);

        arr.insert(77);
        arr.insert(99);
        arr.insert(44);
        arr.insert(55);
        arr.insert(22);
        arr.insert(88);
        arr.insert(11);
        arr.insert(0);
        arr.insert(66);
        arr.insert(33);

        int searchKey = 55;
        if(arr.find(searchKey) != arr.size())
            System.out.println("Found " + searchKey);
        else
            System.out.println("Cant find " + searchKey);

        arr.display();

        arr.delete(0);
        arr.delete(55);
        arr.delete(99);

        arr.display();
    }
}
