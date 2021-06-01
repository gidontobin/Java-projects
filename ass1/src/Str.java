// ID: 320518020

/**
 * The program will receives two strings as arguments: query and sequence.
 * The program will print two groups of words:
 * The words in the sequence that start with the query,
 * and all words in the sequence that include the query.
 * Each group of words will be printed in the order they appear in
 * the original sequence. If the input is not valid, the program will
 * print out: Invalid input.
 *
 * @author Gidon tobin
 * @version 1.0 16 March 2021
 */
public class Str {
    private static final int MAX_ARGS = 2;

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
        str(args[0], args[1]);
    }

    /**
     * This method will print all words in the sequence that the
     * query is in them.
     *
     * @param query    any string.
     * @param sequence a list of words separated by _.
     */
    public static void str(String query, String sequence) {
        String[] words = sequence.split("_");
        //prints word that start with query
        for (String word : words) {
            if (word.startsWith(query)) {
                System.out.println(word);
            }
        }
        //prints word that dont start with query, but contain query
        for (String word : words) {
            if (!word.startsWith(query) && word.contains(query)) {
                System.out.println(word);
            }
        }
    }
}
