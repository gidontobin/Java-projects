//320518020

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * The type Binary expression.
 */
public abstract class BinaryExpression extends BaseExpression implements Expression {
    private Expression a;
    private Expression b;

    /**
     * Instantiates a new Binary expression.
     *
     * @param a the a expression
     * @param b the b expression
     */
    public BinaryExpression(Expression a, Expression b) {
        this.a = a;
        this.b = b;
    }

    /**
     * Gets a.
     *
     * @return the a
     */
    public Expression getA() {
        return this.a;
    }

    /**
     * Gets b.
     *
     * @return the b
     */
    public Expression getB() {
        return this.b;
    }

    @Override
    public abstract Boolean evaluate(Map<String, Boolean> assignment) throws Exception;

    @Override
    public abstract Boolean evaluate() throws Exception;


    @Override
    public List<String> getVariables() {
        List<String> c = new ArrayList<>();
        List<String> varsA = this.a.getVariables();
        List<String> varsB = this.b.getVariables();
        for (String aVar : varsA) {
            varsB.removeIf(aVar::equals);
        }
        c.addAll(varsA);
        c.addAll(varsB);
        return c;
    }

    @Override
    public abstract Expression assign(String var, Expression expression);
}

