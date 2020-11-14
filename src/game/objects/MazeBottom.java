package game.objects;

import game.structures.Coordinate;
import game.structures.Labeled;

public enum MazeBottom implements Coordinate, Labeled {
    TOP_LEFT1(1,5,"Top Left"), TOP_MIDDLE1(2,3,"Top Middle"),
    TOP_RIGHT1(4,3,"Top Right"), MIDDLE_LEFT1(1,3,"Middle Left"),
    CENTER1(5,4,"Center"), MIDDLE_RIGHT1(5,6,"Middle Right"),
    BOTTOM_LEFT1(2,6,"Bottom Left"), BOTTOM_MID1(4,6,"Bottom Middle"),
    BOTTOM_RIGHT1(3,5,"Bottom Right"),

    TOP_LEFT2(6,4,"Top Left"), TOP_MIDDLE2(5,5,"Top Middle"),
    TOP_RIGHT2(6,3,"Top Right"), MIDDLE_LEFT2(1,6,"Middle Left"),
    CENTER2(4,1,"Center"), MIDDLE_RIGHT2(3,2,"Middle Right"),
    BOTTOM_LEFT2(2,1,"Bottom Left"), BOTTOM_MID2(3,3,"Bottom Middle"),
    BOTTOM_RIGHT2(1,2,"Bottom Right");

    private final int[] coordinates;
    private final String label;

    @Override
    public int[] getCoords() {
        return coordinates;
    }

    @Override
    public String getLabel() {
        return "file:src\\Mazes\\" + label + ".PNG";
    }

    MazeBottom(int x, int y, String label){
        coordinates = new int[]{x ,y};
        this.label = label;
    }
}
