package Game.Objects;

import Game.Structures.Labeled;

public enum SimpleWires implements Labeled {
    RED("Red"), BLUE("Blue"), BLACK("Black"),
    WHITE("White"), YELLOW("Yellow");

    private final String label;

    @Override
    public String getLabel() {
        return label + "\n";
    }

    SimpleWires(String label){
        this.label = label;
    }
}