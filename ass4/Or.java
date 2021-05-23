//320518020

import java.util.Map;

/**
 * The type Or.
 */
public class Or extends BinaryExpression implements Expression {

    /**
     * Instantiates a new Or.
     *
     * @param a the a
     * @param b the b
     */
    public Or(Expression a, Expression b) {
        super(a, b);
    }

    @Override
    public Boolean evaluate(Map<String, Boolean> assignment) throws Exception {
        return super.getA().evaluate(assignment) || super.getB().evaluate(assignment);
    }

    @Override
    public Boolean evaluate() throws Exception {
        return super.getA().evaluate() || super.getB().evaluate();
    }

    @Override
    public String toString() {
        return "(" + super.getA().toString() + " | " + super.getB().toString() + ")";
    }

    @Override
    public Expression assign(String var, Expression expression) {
        return new Or(super.getA().assign(var, expression), super.getB().assign(var, expression));
    }

    @Override
    public Expression nandify() {
        Expression nandA = super.getA().nandify();
        Expression nandB = super.getB().nandify();
        return new Nand(new Nand(nandA, nandA), new Nand(nandB, nandB));
    }

    @Override
    public Expression norify() {
        Expression norA = super.getA().norify();
        Expression norB = super.getB().norify();
        return new Nor(new Nor(norA, norB), new Nor(norA, norB));
    }

    @Override
    public Expression simplify() {
        Expression simpA = super.getA().simplify();
        Expression simpB = super.getB().simplify();
        if (simpA.getValue() == null) {
            if (simpB.getValue() == null) {
                if (simpA.toString().equals(simpB.toString())) {
                    return simpA;
                }
                return new Or(simpA, simpB);
            }
            if (simpB.getValue()) {
                return new Val(simpB.getValue());
            }
            return simpA;
        }
        if (simpA.getValue()) {
            return new Val(simpA.getValue());
        }
        if (simpB.getValue() == null) {
            return simpB;
        }
        return new Val(simpA.getValue() || simpB.getValue());
    }

    @Override
    public Boolean getValue() {
        if (super.getA().getValue() == null || super.getB().getValue() == null) {
            return null;
        }
        return super.getA().getValue() || super.getB().getValue();
    }
}
