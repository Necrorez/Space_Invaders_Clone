package SpaceX05.Interpreter;

public class TerminalExpression implements Expression {
    private  String data;

    /**
     * TODO | DOING | DONE
     * DONE
     * Constructor for the TerminalExpression object
     * @param data
     */
    @SuppressWarnings("SSDoc")
    public TerminalExpression(String data) {
        this.data = data;
    }

    @Override
    public boolean interpret(String context) {

        return context.contains(data);
    }
}
