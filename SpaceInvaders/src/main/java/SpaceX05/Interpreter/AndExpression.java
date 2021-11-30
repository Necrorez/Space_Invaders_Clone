package SpaceX05.Interpreter;

public class AndExpression implements Expression {
    private Expression expr1 = null;
    private Expression expr2 = null;

    /**
     * TODO | DOING | DONE
     * DONE
     * Constructor for the AndExpression object
     * @param expr1, expr2
     */
    @SuppressWarnings("SSDoc")
    public AndExpression(Expression expr1, Expression expr2) {
        this.expr1 = expr1;
        this.expr2 = expr2;
    }


    @Override
    public boolean interpret(String context) {
        return expr1.interpret(context) && expr2.interpret(context);
    }
}
