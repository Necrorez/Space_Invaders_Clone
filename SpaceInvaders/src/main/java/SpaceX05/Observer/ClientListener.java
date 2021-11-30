package SpaceX05.Observer;

import java.io.PrintWriter;

public class ClientListener implements ServerCommandObserver{
    private final PrintWriter writer;
    /**
     * TODO | DOING | DONE
     * DONE
     * Constructor for the ClientListener object
     * @param writer
     */
    @SuppressWarnings("SSDoc")
    public ClientListener(PrintWriter writer) {
        this.writer = writer;
    }
    @Override
    public void update(String message) {
            writer.println(message);
            writer.flush();
    }
}
