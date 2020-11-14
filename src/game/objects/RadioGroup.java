package game.objects;

import game.structures.Index;

public enum RadioGroup implements Index {
    BUTTON_COLOR(0), BUTTON_LABEL(1), MAZE(2);

    private final int index;

    @Override
    public int getIdx() {
        return index;
    }

    RadioGroup(int index){
        this.index = index;
    }
}