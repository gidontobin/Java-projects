//320518020

import java.util.List;
import java.util.Map;

/**
 * The type Base expression.
 */
public abstract class BaseExpression implements Expression {

    @Override
    public abstract Boolean evaluate(Map<String, Boolean> assignment) throws Exception;

    @Override
    public abstract Boolean evaluate() throws Exception;

    @Override
    public abstract List<String> getVariables();

    @Override
    public abstract Expression assign(String var, Expression expression);
}

