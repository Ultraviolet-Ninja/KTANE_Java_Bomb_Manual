/*
 * Author: Ultraviolet-Ninja
 * Project: Bomb Defusal Manual for Keep Talking and Nobody Explodes [Vanilla]
 * Section: Wire Sequences
 */

package game.modules;

import game.objects.SequencedWires;
import javafx.scene.image.Image;

/**
 * Sequences class refers to the Wire Sequences module
 */
public class Sequences extends Attribute {
    private static final String stem = "file:src\\Occurrences\\";
    private static final String[] redOcc = {"C", "B", "A", "AC", "B", "AC", "All","AB", "B"},
            blueOcc = {"B", "AC", "B", "A", "B", "BC", "C", "AC","A"},
            blackOcc = {"All", "AC", "B", "AC", "B", "BC", "AB", "C", "C"};

    /**
     * nextOccurrence() tabs to the next occurrence of any colored wire.
     *
     * @param currentWire - the information of the current occurrence, including the number occurrence
     *                    and which color it is
     * @return - the Image of the next occurrence condition
     */
    public static Image nextOccurrence(SequencedWires currentWire){
        currentWire.setIndex(currentWire.getIdx() + 1);
        return guessColor(currentWire);
    }

    /**
     * prevOccurrence() tabs to the previous occurrence of any colored wire.
     *
     * @param currentWire - the information of the current occurrence, including the number occurrence
     *      *                    and which color it is
     * @return - the Image of the previous occurrence condition
     */
    public static Image prevOccurrence(SequencedWires currentWire){
        currentWire.setIndex(currentWire.getIdx() - 1);
        return guessColor(currentWire);
    }

    private static Image guessColor(SequencedWires currentWire){
        switch (currentWire) {
            case RED -> {
                return new Image(stem + redOcc[currentWire.getIdx()] + ".PNG");
            }
            case BLUE -> {
                return new Image(stem + blueOcc[currentWire.getIdx()] + ".PNG");
            }
            default -> {
                return new Image(stem + blackOcc[currentWire.getIdx()] + ".PNG");
            }
        }
    }
}
