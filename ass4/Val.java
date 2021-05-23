//320518020

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * The type Val.
 */
public class Val implements Expression {
    private Boolean val;

    /**
     * Instantiates a new Val.
     *
     * @param val the val
     */
    public Val(Boolean val) {
        this.val = val;
    }

    @Override
    public Boolean evaluate(Map<String, Boolean> assignment) throws Exception {
        return this.val;
    }

    @Override
    public Boolean evaluate() throws Exception {
        return this.val;
    }

    @Override
    public List<String> getVariables() {
        return new ArrayList<>();
    }

    @Override
    public Expression assign(String var, Expression expression) {
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
        return this.val;
    }

    @Override
    public String toString() {
        if (this.val) {
            return "T";
        }
        return "F";
    }
}
