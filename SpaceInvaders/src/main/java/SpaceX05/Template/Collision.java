package SpaceX05.Template;


public abstract class Collision {
    protected boolean hit;
    abstract void gotHit(Object item, Object nextItem);
    abstract void doAction(Object first,Object second);

    /**
     * TODO | DOING | DONE
     * DONE
     * checks if the object gets hit with a collision and if it does get it the object does an action
     * @param item, nextItem
     * @return
     */
    @SuppressWarnings("SSDoc")
    public final void checkHit(Object item, Object nextItem) {
            gotHit(item, nextItem);
            if (hit){
                doAction(item, nextItem);
            }
        }
}
