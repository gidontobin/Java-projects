//320518020

import java.util.Map;
import java.util.TreeMap;

/**
 * The type Test part one.
 */
public class ExpressionsTest {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     * @throws Exception the exception
     */
    public static void main(String[] args) throws Exception {
        Expression e = new Not(new Xor(new And(new Val(true), new Or(new Var("x"), new Var("y"))), new Var("z")));
        Map<String, Boolean> assignment = new TreeMap<>();
        assignment.put("x", true);
        assignment.put("y", false);
        assignment.put("z", false);
        System.out.println(e);
        System.out.println(e.evaluate(assignment));
        System.out.println(e.nandify());
        System.out.println(e.norify());
        System.out.println(e.simplify());
    }
}
