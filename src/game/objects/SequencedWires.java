package game.objects;

import game.structures.Index;

public enum SequencedWires implements Index {
    RED(0), BLUE(0), BLACK(0);

    private int index;

    public void setIndex(int index){
        this.index = index;
    }

    @Override
    public int getIdx() {
        return index;
    }

    SequencedWires(int index){
        this.index = index;
    }
}