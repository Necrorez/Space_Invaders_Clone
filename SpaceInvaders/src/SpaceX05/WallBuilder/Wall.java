package SpaceX05.WallBuilder;

import java.util.ArrayList;

public class Wall {

    private final String color;
    private final int x;
    private final int y;
    private final int[][] placement;
    public Wall(WallBuilder builder) {
        this.color = builder.color;
        this.x = builder.x;
        this.y = builder.y;
        this.placement = builder.placement;
    }
    public String getColor(){
        return color;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public int[][] getPlacement(){
        return placement;
    }

    public ArrayList<WallBlock> getWall(){
        ArrayList<WallBlock> wallBlocks = new ArrayList<>();
        int offset = 10;
        int i = 0;
        for (int[] innerArray: this.placement) {
            int j =0;
            // second for...each loop access each element inside the row
            for(int data: innerArray) {
                if(data == 1){
                    WallBlock wallBlock = new WallBlock((y+j*offset),(x+i*offset), this.color);
                    wallBlocks.add(wallBlock);
                }
                j++;
            }
            i++;
        }
        return wallBlocks;
    }

    public static class WallBuilder{
        private String color;
        private int x;
        private int y;
        private int[][] placement;

        public WallBuilder() {
        }
        public WallBuilder color(String c){
            String toSet = "";
            switch (c){
                case "White": toSet = "/SpaceX05/Images/WallBlock.png"; break;
                case "Blue": toSet= "/SpaceX05/Images/WallBlockBlue.png"; break;
                case "Purple": toSet= "/SpaceX05/Images/WallBlockPurple.png"; break;
                default: throw new RuntimeException("Invalid entry");
            }
            this.color = toSet;
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
