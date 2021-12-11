package SpaceX05.Observer;

public interface ServerCommander {
    void addObserver(ServerCommandObserver observer);
    void removeObserver(ServerCommandObserver observer);
    void notifyPlayers(String message);

}
