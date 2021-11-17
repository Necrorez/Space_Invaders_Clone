package SpaceX05.Observer;

import java.io.PrintWriter;

public class ClientListener implements ServerCommandObserver{
    private  PrintWriter writer;
    public ClientListener(PrintWriter writer){
        this.writer = writer;
    }
    @Override
    public void update(String message) {
            writer.println(message);
            writer.flush();
    }
}
