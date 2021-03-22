/* We will demonstrate exercises 2.1-2.3 in this class.

    Exercise 2.1: Add a method called getMax() that returns the value of the highest
    key in the array or -1 if the array is empty. Assume all key's are positive numbers.

    Exercise 2.2: Modify the above method of getMax() so that the item with the highest key
    is not only returned by the method but also removed from the array. Call this function
    removeMax()

    Exercise 2.3: Using only the main in the HighArrayMap, create a second array and inversely
    sort it.
 */

public class HighArray {
    private long[] a;           // ref to array a
    private int nElems;         // number of data items

    // constructor
    public HighArray(int max) {
        a = new long[max];
        nElems = 0;
    }

    public int getnElems() {
        return nElems;
    }

    // find a specific value
    public boolean find(long searchKey) {
        int i;              // search index
        for (i = 0; i < nElems; i++) {
            if (a[i] == searchKey) {
                break;      // found item
            }
        }
        return i != nElems; // false if i == nElems, false otherwise
    }

    // put element into array
    public void insert(long value) {
        a[nElems] = value;
        nElems++;
    }

    // delete a specific value
    public boolean delete(long value) {
        int i;
        for (i = 0; i < nElems; i++) {
            if (value == a[i])
                break;
        }
        if (i == nElems)
            return false;
        else    // found it and now we need to delete it
        {
            for (int k = i; k < nElems; k++) {
                a[k] = a[k + 1];              // decrement size
            }
            nElems--;
            return true;
        }
    }

    // print array
    public void display() {
        for (int i = 0; i < nElems; i++) {
            System.out.println(a[i] + " ");
        }
        System.out.println("");
    }

    /**
     * THIS IS THE METHOD FOR EXERCISE 2.1
     *
     * @return the highest key in the array or -1 if the array is empty
     */
    public long getMax() {
        if (nElems == 0)
            return -1;

        long highestValue = a[0];
        for (int j = 0; j < nElems; j++) {
            if (a[j] > highestValue)
                highestValue = a[j];
        }
        return highestValue;
    }

    /**
     * THIS IS THE METHOD FOR EXERCISE 2.2
     * @return true if item is removed and false if the array is empty
     */
    public boolean removeMax() {
        if(getMax() != -1)
        {
            this.delete(getMax());
            return true;
        }
        else
            return false;   // the array is empty
    }

}
// for testing HighArrayApp
class HighArrayApp {
    public static void main(String[] args)
    {
        int maxSize = 100;
        HighArray arr;
        arr = new HighArray(maxSize);

        /*System.out.println("Trying to delete an invalid value: " + arr.delete(0));
        System.out.println("Trying to use getMax() on an empty array: " + arr.getMax());
        System.out.println("Trying to use removeMax() on an empty array: " + arr.removeMax() + "\n");*/


        arr.insert(77);
        arr.insert(99);
        arr.insert(44);
        arr.insert(55);
        arr.insert(22);
        arr.insert(11);
        arr.insert(00);
        arr.insert(66);
        arr.insert(33);

        arr.display();

        // NOW ATTEMPTING EXERCISE 2.3
        // WE MUST CREATE AN INVERSELY SORTED NEW ARRAY ONLY USING CODE IN MAIN
        // *****************************************************************
        int maxSize2 = 100;
        HighArray arr2;
        arr2 = new HighArray(maxSize);
        int numberOfElements = arr.getnElems();
        for(int i = 0; i < numberOfElements; i++)
        {
            arr2.insert(arr.getMax());
            arr.removeMax();
        }
        arr2.display();


        /*
        System.out.println("Highest value in the array is " + arr.getMax());
        System.out.println("We will now remove the highest value of " + arr.getMax() + "\n");
        arr.removeMax();
        arr.display();


        int searchKey = 35;
        if(arr.find(searchKey))
            System.out.println("Found " + searchKey);
        else
            System.out.println("Didn't find " + searchKey);

        arr.delete(00);
        arr.delete(55);
        arr.delete(99);

        arr.display();
         */
    }
}
