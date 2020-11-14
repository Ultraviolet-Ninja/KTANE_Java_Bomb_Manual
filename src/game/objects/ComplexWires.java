package game.objects;

import game.structures.Labeled;

public enum ComplexWires implements Labeled {
    RED("Red"), BLUE("Blue"), STAR("Star"), LIT("LED"), BLANK("White");

    private final String label;

    @Override
    public String getLabel() {
        return label;
    }

    ComplexWires(String label){
        this.label = label;
    }
}
