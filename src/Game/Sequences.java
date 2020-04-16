package Game;

import Game.Mod.Attribute;
import javafx.scene.image.Image;

public class Sequences extends Attribute {
    private static final String[] redOcc = {"C", "B", "A", "AC", "B", "AC", "All","AB", "B"},
            blueOcc = {"B", "AC", "B", "A", "B", "BC", "C", "AC","A"},
            blackOcc = {"All", "AC", "B", "AC", "B", "BC", "AB", "C", "C"};

    public static Image nextOccurrence(SequencedWires currentWire){
        switch (currentWire){
            case RED:
                currentWire.setIndex(currentWire.getIdx() + 1);
                return new Image(currentWire.getLabel() + redOcc[currentWire.getIdx()] + ".PNG");
            case BLUE:
                currentWire.setIndex(currentWire.getIdx() + 1);
                return new Image(currentWire.getLabel() + blueOcc[currentWire.getIdx()] + ".PNG");
            default:
                currentWire.setIndex(currentWire.getIdx() + 1);
                return new Image(currentWire.getLabel() + blackOcc[currentWire.getIdx()] + ".PNG");
        }
    }

    public static Image prevOccurrence(SequencedWires currentWire){
        switch (currentWire){
            case BLACK:
                currentWire.setIndex(currentWire.getIdx() - 1);
                return new Image(currentWire.getLabel() + blackOcc[currentWire.getIdx()] + ".PNG");
            case BLUE:
                currentWire.setIndex(currentWire.getIdx() - 1);
                return new Image(currentWire.getLabel() + blueOcc[currentWire.getIdx()] + ".PNG");
            default:
                currentWire.setIndex(currentWire.getIdx() - 1);
                return new Image(currentWire.getLabel() + redOcc[currentWire.getIdx()] + ".PNG");
        }
    }
}
