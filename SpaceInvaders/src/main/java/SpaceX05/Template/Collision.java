package SpaceX05.Template;


public abstract class Collision {
    protected boolean hit;
    abstract void gotHit(Object item, Object nextItem);
    abstract void doAction(Object first,Object second);
    public final boolean returnHit() {
                return hit;
    }

    public final void checkHit(Object item, Object nextItem) {
            gotHit(item, nextItem);
            if (hit){
                doAction(item, nextItem);
            }
        }
}
