package SpaceX05.Observer;

import java.util.ArrayList;
import java.util.List;

public class ServerCaster implements ServerCommander{
    private List<ServerCommandObserver> observerList = new ArrayList<ServerCommandObserver>();

    @Override
    public void addObserver(ServerCommandObserver observer) {
        observerList.add(observer);
    }

    @Override
    public void removeObserver(ServerCommandObserver observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyPlayers(String message) {
        for (var obs: observerList){
            obs.update(message);
        }
    }
}
