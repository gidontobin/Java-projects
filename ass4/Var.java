//320518020

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * The type Var.
 */
public class Var implements Expression {
    private String varuble;

    /**
     * Instantiates a new Var.
     *
     * @param var the var
     */
    public Var(String var) {
        this.varuble = var;
    }

    @Override
    public Boolean evaluate(Map<String, Boolean> assignment) throws Exception {
        if (!assignment.containsKey(this.varuble)) {
            throw new Exception("the expression contains a variable which is not in the assignment");
        }
        return assignment.get(this.varuble);
    }

    @Override
    public Boolean evaluate() throws Exception {
        throw new Exception("the expression contains a variable which is not in the assignment");
    }

    @Override
    public List<String> getVariables() {
        List<String> newList = new ArrayList<>();
        newList.add(this.varuble);
        return newList;
    }

    @Override
    public Expression assign(String var, Expression expression) {
        if (this.varuble.equals(var)) {
            return expression;
        }
        return this;
    }

    @Override
    public Expression nandify() {
        return this;
    }

    @Override
    public Expression norify() {
        return this;
    }

    @Override
    public Expression simplify() {
        return this;
    }

    @Override
    public Boolean getValue() {
        return null;
    }

    @Override
    public String toString() {
        return this.varuble;
    }
}
