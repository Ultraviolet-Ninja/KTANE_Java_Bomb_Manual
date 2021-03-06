package game.objects;

import game.structures.Labeled;

public enum SimonSays implements Labeled {
    RED("R"), YELLOW("Y"), GREEN("G"), BLUE("B");

    private final String label;

    @Override
    public String getLabel() {
        return label;
    }

    SimonSays(String label){
        this.label = label;
    }
}
