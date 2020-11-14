package game.objects;

import game.structures.Coordinate;
import game.structures.Labeled;

public enum MazeTop implements Coordinate, Labeled {
    TOP_LEFT1(1,2, "Top Left"), TOP_MIDDLE1(2,4,"Top Middle"),
    TOP_RIGHT1(4, 4,"Top Right"), MIDDLE_LEFT1(1,1,"Middle Left"),
    CENTER1(5,3, "Center"), MIDDLE_RIGHT1(5,1,"Middle Right"),
    BOTTOM_LEFT1(2,1,"Bottom Left"), BOTTOM_MID1(4, 1, "Bottom Middle"),
    BOTTOM_RIGHT1(3,2,"Bottom Right"),

    TOP_LEFT2(6,3,"Top Left"), TOP_MIDDLE2(5,2,"Top Middle"),
    TOP_RIGHT2(6,4,"Top Right"), MIDDLE_LEFT2(1,4,"Middle Left"),
    CENTER2(4,6,"Center"), MIDDLE_RIGHT2(3,5,"Middle Right"),
    BOTTOM_LEFT2(2,6,"Bottom Left"), BOTTOM_MID2(3,4,"Bottom Middle"),
    BOTTOM_RIGHT2(1,5,"Bottom Right");

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

    MazeTop(int x, int y, String label){
        coordinates = new int[]{x ,y};
        this.label = label;
    }
}
