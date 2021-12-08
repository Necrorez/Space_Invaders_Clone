package SpaceX05.WallBuilder;

import SpaceX05.Sprite;

import java.util.ArrayList;

public class Wall extends Sprite {

    private final WallBlockTriangle triangle;
    private final WallBlockSquare square;
    private final int x;
    private final int y;
    private final int[][] placement;
    public Wall(WallBuilder builder) {
        this.triangle = builder.triangle;
        this.square = builder.square;
        this.x = builder.x;
        this.y = builder.y;
        this.placement = builder.placement;
    }

    public ArrayList<WallBlockSquare> getWallSquare(){
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

        public WallBuilder() {
        }
        public WallBuilder triangle(WallBlockTriangle c){
            this.triangle = c;
            return this;
        }
        public WallBuilder square(WallBlockSquare c){
            this.square = c;
            return this;
        }

        public WallBuilder x(int x){
            this.x = x;
            return this;
        }

        public WallBuilder y(int y){
            this.y=y;
            return this;
        }

        public WallBuilder placement(int[][] placement){
            this.placement = placement;
            return this;
        }

        public Wall build(){
            Wall wall = new Wall(this);
            return wall;
        }


    }
}
