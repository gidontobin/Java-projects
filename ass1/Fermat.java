// ID: 320518020

/**
 * The program will print all a b c for which
 * the Pythagorean equation a^n + b^n = c^n is respected,
 * s.t a, b and c are between 1 and range (the second argument).
 * If no Pythagorean equation is found, the program will print "no".
 *
 * @author Gidon tobin
 * @version 1.0 16 March 2021
 */
public class Fermat {
    private static final int MAX_ARGS = 2;

    /**
     * This method will check if args are valid, and if so
     * will send them to fermat function.
     *
     * @param args command line arguments.
     */
    public static void main(String[] args) {
        //incase wrong number of args are given
        if (args.length != MAX_ARGS) {
            System.out.println("Invalid input");
            return;
        }
        //checking if the numbers are positive
        int[] arr = new int[MAX_ARGS];
        int i = 0;
        for (String s : args) {
            arr[i] = Integer.parseInt(s);
            if (arr[i] <= 0) {
                System.out.println("Invalid input");
                return;
            }
            i++;
        }
        fermat(arr[0], arr[1]);
    }

    /**
     * This method will print all combinations in a^n+b^n=c^n format,
     * in the range given.
     *
     * @param n     the number that a b and c will be powered by.
     * @param range the range from one that a b and c will be chosen from.
     */
    public static void fermat(int n, int range) {
        boolean flag = false;
        for (int a = 1; a < range; a++) {
            for (int b = a; b < range; b++) {
                double c = Math.pow(a, n) + Math.pow(b, n);
                c = Math.pow(c, (float) 1 / n);
                //is c natrule and in the range
                if (c == Math.floor(c) && c < range) {
                    System.out.println(a + "," + b + "," + (int) c);
                    flag = true;
                }
            }
        }
        //incase no combination are printed
        if (!flag) {
            System.out.println("no");
        }
    }
}
