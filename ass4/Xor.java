//320518020

import java.util.Map;

/**
 * The type Xor.
 */
public class Xor extends BinaryExpression implements Expression {

    /**
     * Instantiates a new Xor.
     *
     * @param a the a
     * @param b the b
     */
    public Xor(Expression a, Expression b) {
        super(a, b);
    }

    @Override
    public Boolean evaluate(Map<String, Boolean> assignment) throws Exception {
        return super.getA().evaluate(assignment) ^ super.getB().evaluate(assignment);
    }

    @Override
    public Boolean evaluate() throws Exception {
        return super.getA().evaluate() ^ super.getB().evaluate();
    }

    @Override
    public String toString() {
        return "(" + super.getA().toString() + " ^ " + super.getB().toString() + ")";
    }

    @Override
    public Expression assign(String var, Expression expression) {
        return new Xor(super.getA().assign(var, expression), super.getB().assign(var, expression));
    }

    @Override
    public Expression nandify() {
        Expression nandA = super.getA().nandify();
        Expression nandB = super.getB().nandify();
        return new Nand(new Nand(nandA, new Nand(nandA, nandB)),
                new Nand(nandB, new Nand(nandA, nandB)));
    }

    @Override
    public Expression norify() {
        Expression norA = super.getA().norify();
        Expression norB = super.getB().norify();
        return new Nor(new Nor(new Nor(norA, norA), new Nor(norB, norB)), new Nor(norA, norB));
    }

    @Override
    public Expression simplify() {
        Expression simpA = super.getA().simplify();
        Expression simpB = super.getB().simplify();
        if (simpA.getValue() == null) {
            if (simpB.getValue() == null) {
                if (simpA.toString().equals(simpB.toString())) {
                    return new Val(false);
                }
                return new Xor(simpA, simpB);
            }
            if (simpB.getValue()) {
                return new Not(simpA);
            }
            return simpA;
        }
        if (simpA.getValue()) {
            if (simpB.getValue() == null) {
                return new Not(simpB);
            }
            return new Val(simpA.getValue() ^ simpB.getValue());
        }
        if (simpB.getValue() == null) {
            return simpB;
        }
        return new Val(simpA.getValue() ^ simpB.getValue());
    }

    @Override
    public Boolean getValue() {
        if (super.getA().getValue() == null || super.getB().getValue() == null) {
            return null;
        }
        return super.getA().getValue() ^ super.getB().getValue();
    }
}
