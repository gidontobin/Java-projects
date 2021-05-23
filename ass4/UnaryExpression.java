//320518020

import java.util.List;

/**
 * The type Unary expression.
 */
public abstract class UnaryExpression extends BaseExpression implements Expression {
    private Expression a;

    /**
     * Instantiates a new Unary expression.
     *
     * @param a the a
     */
    public UnaryExpression(Expression a) {
        this.a = a;
    }

    @Override
    public List<String> getVariables() {
        return this.a.getVariables();
    }

    /**
     * Gets a.
     *
     * @return the a
     */
    public Expression getA() {
        return this.a;
    }
}
