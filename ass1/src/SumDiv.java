// ID: 320518020

/**
 * The program will receive 3 positive Integers 'a,b,c' as arguments
 * and prints out the numbers between 1 and 'a' (including a itself)
 * that are divisible by b or c, and the sum of all these numbers.
 * If the arguments are invalid or there less or more than 3 arguments,
 * the program will print Invalid input.
 *
 * @author Gidon tobin
 * @version 1.0 16 March 2021
 */
public class SumDiv {
    private static final int MAX_ARGS = 3;

    /**
     * This method will check if args are valid, and if so
     * will send them to sumDiv function.
     *
     * @param args command line arguments.
     */
    public static void main(String[] args) {
        if (args.length != MAX_ARGS) {
            System.out.println("Invalid input");
            return;
        }
        int[] arr = new int[MAX_ARGS];
        int index = 0;
        for (String s : args) {
            arr[index] = Integer.parseInt(s);
            //checking if number are natrual
            if (arr[index] <= 0) {
                System.out.println("Invalid input");
                return;
            }
            index++;
        }
        sumDiv(arr[0], arr[1], arr[2]);
    }

    /**
     * This method will print out the numbers between 1 and 'a'
     * that are divisible by b or c, and the sum of all these numbers.
     *
     * @param a first argument.
     * @param b second argument.
     * @param c third argument.
     */
    public static void sumDiv(int a, int b, int c) {
        int sum = 0;
        for (int i = 1; i <= a; i++) {
            if (i % b == 0 || i % c == 0) {
                System.out.println(i);
                sum += i;
            }
        }
        System.out.println(sum);
    }
}
