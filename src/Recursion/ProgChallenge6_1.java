package Recursion;
/*  Suppose you buy a budget-priced pocket PC and discover that the chip inside can't do multiplication,
    only addition. You program your way out of this quandary by writing a recursive method, mult(), that
    performs multiplication of x and y by adding x to itself y times. It's arguments are x and y and its
    return value is the product of x and y. Write such a method and call it.
 */
public class ProgChallenge6_1 {
    static public int mult(int x, int y)
    {
        int res = 0;
        if(y == 0)
            return 0;
        res = x + mult(x, y-1);
        return res;
    }
    public static void main(String[] args) {
        System.out.println(mult(3, 5));
        System.out.println(mult(10, 10));
        System.out.println(mult(0,0));
        System.out.println(mult(1,0));
        System.out.println(mult(0,1));
        System.out.println(mult(1,1));
    }
}
