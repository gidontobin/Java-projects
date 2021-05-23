//320518020

import java.util.Map;

/**
 * The type Xnor.
 */
public class Xnor extends BinaryExpression implements Expression {

    /**
     * Instantiates a new Xnor.
     *
     * @param a the a
     * @param b the b
     */
    public Xnor(Expression a, Expression b) {
        super(a, b);
    }

    @Override
    public Boolean evaluate(Map<String, Boolean> assignment) throws Exception {
        return super.getA().evaluate(assignment) == super.getB().evaluate(assignment);
    }

    @Override
    public Boolean evaluate() throws Exception {
        return super.getA().evaluate() == super.getB().evaluate();
    }

    @Override
    public String toString() {
        return "(" + super.getA().toString() + " # " + super.getB().toString() + ")";
    }

    @Override
    public Expression assign(String var, Expression expression) {
        return new Xnor(super.getA().assign(var, expression), super.getB().assign(var, expression));
    }

    @Override
    public Expression nandify() {
        Expression nandA = super.getA().nandify();
        Expression nandB = super.getB().nandify();
        return new Nand(new Nand(new Nand(nandA, nandA), new Nand(nandB, nandB)),
                new Nand(nandA, nandB));
    }

    @Override
    public Expression norify() {
        Expression norA = super.getA().norify();
        Expression norB = super.getB().norify();
        return new Nor(new Nor(norA, new Nor(norA, norB)), new Nor(norB, new Nor(norA, norB)));
    }


    @Override
    public Expression simplify() {
        Expression simpA = super.getA().simplify();
        Expression simpB = super.getB().simplify();
        if (simpA.getValue() == null && simpB.getValue() == null && simpA.toString().equals(simpB.toString())) {
            return new Val(true);
        } else if (simpA.getValue() != null && simpB.getValue() != null) {
            return new Val(simpA.getValue() == simpB.getValue());
        }
        return new Xnor(simpA, simpB);
    }

    @Override
    public Boolean getValue() {
        if (super.getA().getValue() == null || super.getB().getValue() == null) {
            return null;
        }
        return super.getA().getValue() == super.getB().getValue();
    }
}
