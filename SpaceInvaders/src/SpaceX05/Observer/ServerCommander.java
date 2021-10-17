package SpaceX05.Observer;

public interface ServerCommander {
    public void addObserver(ServerCommandObserver observer);
    public void removeObserver(ServerCommandObserver observer);
    public void notifyPlayers(String message);

}
