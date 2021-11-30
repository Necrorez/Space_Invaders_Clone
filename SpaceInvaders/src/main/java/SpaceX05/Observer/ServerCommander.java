package SpaceX05.Observer;

public interface ServerCommander {
     /**
     * TODO | DOING | DONE
     * DONE
      * Method to add observers to the array
     * @param observer
     */
    @SuppressWarnings("SSDoc")
    void addObserver(ServerCommandObserver observer);
    /**
     * TODO | DOING | DONE
     * DONE
     * Method to remove observers to the array
     * @param observer
     */
    @SuppressWarnings("SSDoc")
     void removeObserver(ServerCommandObserver observer);
    /**
     * TODO | DOING | DONE
     * DONE
     * Method to notify observers in the array of observers
     * @param message
     */
    @SuppressWarnings("SSDoc")
     void notifyPlayers(String message);

}
