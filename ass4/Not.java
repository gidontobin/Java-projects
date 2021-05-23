//320518020

import java.util.Map;

/**
 * The type Not.
 */
public class Not extends UnaryExpression implements Expression {

    /**
     * Instantiates a new Not.
     *
     * @param a the a
     */
    public Not(Expression a) {
        super(a);
    }

    @Override
    public Boolean evaluate(Map<String, Boolean> assignment) throws Exception {
        return !super.getA().evaluate(assignment);
    }

    @Override
    public String toString() {
        return "~(" + super.getA().toString() + ")";
    }

    @Override
    public Boolean evaluate() throws Exception {
        return !super.getA().evaluate();
    }

    @Override
    public Expression assign(String var, Expression expression) {
        return new Not(super.getA().assign(var, expression));
    }

    @Override
    public Expression nandify() {
        return new Nand(super.getA().nandify(), super.getA().nandify());
    }

    @Override
    public Expression norify() {
        return new Nor(super.getA().norify(), super.getA().norify());
    }

    @Override
    public Expression simplify() {
        if (super.getA().getValue() == null) {
            return new Not(super.getA().simplify());
        }
        return new Val(this.getValue());
    }

    @Override
    public Boolean getValue() {
        if (super.getA().getValue() == null) {
            return null;
        }
        return !super.getA().getValue();
    }
}
