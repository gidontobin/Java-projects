//320518020

import java.util.Map;

/**
 * The type Nand.
 */
public class Nand extends BinaryExpression implements Expression {

    /**
     * Instantiates a new Nand.
     *
     * @param a the a
     * @param b the b
     */
    public Nand(Expression a, Expression b) {
        super(a, b);
    }

    @Override
    public Boolean evaluate(Map<String, Boolean> assignment) throws Exception {
        return !(super.getA().evaluate(assignment) && super.getB().evaluate(assignment));
    }

    @Override
    public Boolean evaluate() throws Exception {
        return !(super.getA().evaluate() && super.getB().evaluate());
    }

    @Override
    public String toString() {
        return "(" + super.getA().toString() + " A " + super.getB().toString() + ")";
    }

    @Override
    public Expression assign(String var, Expression expression) {
        return new Nand(super.getA().assign(var, expression), super.getB().assign(var, expression));
    }

    @Override
    public Expression nandify() {
        return new Nand(super.getA().nandify(), super.getB().nandify());
    }

    @Override
    public Expression norify() {
        Expression norA = super.getA().norify();
        Expression norB = super.getB().norify();
        return new Nor(new Nor(new Nor(norA, norA), new Nor(norB, norB)),
                new Nor(new Nor(norA, norA), new Nor(norB, norB)));
    }

    @Override
    public Expression simplify() {
        Expression simpA = super.getA().simplify();
        Expression simpB = super.getB().simplify();
        if (simpA.getValue() == null) {
            if (simpB.getValue() == null) {
                if (simpA.toString().equals(simpB.toString())) {
                    return new Not(simpA);
                }
                return new Nand(simpA, simpB);
            }
            if (simpB.getValue()) {
                return new Not(simpA);
            }
            return new Val(!simpB.getValue());
        }
        if (simpA.getValue()) {
            if (simpB.getValue() == null) {
                return new Not(simpB);
            }
            return new Val(!(simpA.getValue() && simpB.getValue()));
        }
        return new Val(!simpA.getValue());

    }

    @Override
    public Boolean getValue() {
        if (super.getA().getValue() == null || super.getB().getValue() == null) {
            return null;
        }
        return !(super.getA().getValue() && super.getB().getValue());
    }
}
