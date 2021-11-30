package SpaceX05.WallBuilder;

import java.util.ArrayList;

public class Wall {

    private final WallBlockTriangle triangle;
    private final WallBlockSquare square;
    private final int x;
    private final int y;
    private final int[][] placement;
    /**
     * TODO | DOING | DONE
     * DONE
     * Constructor for the wall object
     * @param builder
     */
    @SuppressWarnings("SSDoc")
    public Wall(WallBuilder builder) {
        this.triangle = builder.triangle;
        this.square = builder.square;
        this.x = builder.x;
        this.y = builder.y;
        this.placement = builder.placement;
    }

    /**
     * TODO | DOING | DONE
     * DONE
     * Creates an array of square walls
     * @param
     * @return array of square walls
     */
    @SuppressWarnings("SSDoc")
    public ArrayList<WallBlockSquare> getWallSquare() {
        ArrayList<WallBlockSquare> wallBlocks = new ArrayList<>();
        int offset = 10;
        int i = 0;
        for (int[] innerArray: this.placement) {
            int j =0;
            // second for...each loop access each element inside the row
            for(int data: innerArray) {
                if(data == 1){
                    if (this.square != null){

                        WallBlockSquare newWallBlockSquare = new WallBlockSquare((y+j*offset),(x+i*offset),this.square.getImage());
                        wallBlocks.add(newWallBlockSquare);
                    }
                }
                j++;
            }
            i++;
        }
        return wallBlocks;
    }
    /**
     * TODO | DOING | DONE
     * DONE
     * Creates an array of triangle walls
     * @param
     * @return array of triangle walls
     */
    @SuppressWarnings("SSDoc")
    public ArrayList<WallBlockTriangle> getWallTriangle(){
        ArrayList<WallBlockTriangle> wallBlocks = new ArrayList<>();
        int offset = 10;
        int i = 0;
        for (int[] innerArray: this.placement) {
            int j =0;
            // second for...each loop access each element inside the row
            for(int data: innerArray) {
                if(data == 1){
                    if ( this.triangle != null){
                        WallBlockTriangle newWallBlock = new WallBlockTriangle((y+j*offset),(x+i*offset),this.triangle.getImage());
                        wallBlocks.add(newWallBlock);
                    }
                }
                j++;
            }
            i++;
        }
        return wallBlocks;
    }

    public static class WallBuilder{
        private WallBlockTriangle triangle;
        private WallBlockSquare square;
        private int x;
        private int y;
        private int[][] placement;

        /**
         * TODO | DOING | DONE
         * DONE
         * default constructor
         */
        @SuppressWarnings("SSDoc")
        public WallBuilder() {
        }

        /**
         * TODO | DOING | DONE
         * DONE
         * creation of WallBlockTriangle object
         * @return this
         */
        @SuppressWarnings("SSDoc")
        public WallBuilder triangle(WallBlockTriangle c){
            this.triangle = c;
            return this;
        }
        /**
         * TODO | DOING | DONE
         * DONE
         * creation of WallBlockSquare object
         * @return this
         */
        @SuppressWarnings("SSDoc")
        public WallBuilder square(WallBlockSquare c){
            this.square = c;
            return this;
        }
        /**
         * TODO | DOING | DONE
         * DONE
         * creation of x coordinate
         * @return this
         */
        @SuppressWarnings("SSDoc")
        public WallBuilder x(int x){
            this.x = x;
            return this;
        }
        /**
         * TODO | DOING | DONE
         * DONE
         * creation of y coordinate
         * @return this
         */
        @SuppressWarnings("SSDoc")
        public WallBuilder y(int y){
            this.y=y;
            return this;
        }

        /**
         * TODO | DOING | DONE
         * DONE
         * creation of placement array
         * @return this
         */
        @SuppressWarnings("SSDoc")
        public WallBuilder placement(int[][] placement){
            this.placement = placement;
            return this;
        }

        /**
         * TODO | DOING | DONE
         * DONE
         * builds the entire Wall object
         * @return this
         */
        @SuppressWarnings("SSDoc")
        public Wall build(){
            Wall wall = new Wall(this);
            return wall;
        }


    }
}
