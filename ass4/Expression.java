//320518020

import java.util.List;
import java.util.Map;

/**
 * The interface Expression.
 */
public interface Expression {
    /**
     * Evaluate the expression using the variable values provided in the assignment.
     *
     * @param assignment the assignment
     * @return the result of Evaluation
     * @throws Exception if the expression contains a variable which is not in the assignment
     */
    Boolean evaluate(Map<String, Boolean> assignment) throws Exception;

    /**
     * Evaluate A convenience method. Like the `evaluate(assignment)` method above,
     * but uses an empty assignment.
     *
     * @return the boolean
     * @throws Exception the exception
     */
    Boolean evaluate() throws Exception;

    /**
     * Gets variables.
     *
     * @return a list of the variables in the expression
     */
    List<String> getVariables();

    /**
     * To string.
     *
     * @return a nice string representation of the expression.
     */
    String toString();

    /**
     * Assign expression.
     *
     * @param var        the var
     * @param expression the expression
     * @return a new expression in which all occurrences of the variable
     * var are replaced with the provided expression (Does not modify the
     * current expression).
     */
    Expression assign(String var, Expression expression);

    /**
     * Nandify expression.
     *
     * @return the expression tree resulting from converting all the operations to the logical Nand operation.
     */
    Expression nandify();

    /**
     * Norify expression.
     *
     * @return the expression tree resulting from converting all the operations to the logical Nor operation.
     */
    Expression norify();

    /**
     * Simplify expression.
     *
     * @return a simplified version of the current expression.
     */
    Expression simplify();

    /**
     * Gets value.
     *
     * @return the value of an exprision. If there are vars in the expresion, a null will be returned.
     */
    Boolean getValue();
}
