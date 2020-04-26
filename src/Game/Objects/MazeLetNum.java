package Game.Objects;

import Game.Structures.Coordinate;
import Game.Structures.Labeled;

public enum MazeLetNum implements Coordinate, Labeled {
    TOP_LEFT1(11,1,"Top Left"), TOP_MIDDLE1(11,5,"Top Middle"),
    TOP_RIGHT1(13,4,"Top Right"), MIDDLE_LEFT1(10,1,"Middle Left"),
    CENTER1(15,4,"Center"), MIDDLE_RIGHT1(10,5,"Middle Right"),
    BOTTOM_LEFT1(15,2,"Bottom Left"), BOTTOM_MID1(10,4,"Bottom Middle"),
    BOTTOM_RIGHT1(14,1,"Bottom Right"),

    TOP_LEFT2(12,6,"Top Left"), TOP_MIDDLE2(13,2,"Top Middle"),
    TOP_RIGHT2(13,6,"Top Right"), MIDDLE_LEFT2(13,1,"Middle Left"),
    CENTER2(12,5,"Center"), MIDDLE_RIGHT2(14,3,"Middle Right"),
    BOTTOM_LEFT2(10,2,"Bottom Left"), BOTTOM_MID2(13,3,"Bottom Middle"),
    BOTTOM_RIGHT2(11,3,"Bottom Right");

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

    MazeLetNum(int x, int y, String label){
        coordinates = new int[]{x ,y};
        this.label = label;
    }
}
