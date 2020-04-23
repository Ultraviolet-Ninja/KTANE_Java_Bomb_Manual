/*
 * Author: Ultraviolet-Ninja
 * Project: Bomb Defusal Manual for Keep Talking and Nobody Explodes [Vanilla]
 * Section: Structures
 */

package Game;

/**
 * Structures contains all the interfaces used by the Enum types
 */

interface Labeled {
    String getLabel();
}

interface Coordinate {
    int[] getCoords();
}

interface Index{
    int getIdx();
}

interface Frequency{
    double frequency();
}

interface Flaggable{
    void setFlag(boolean flag);

    boolean getFlag();
}

interface Listed{
    String[] getWords();
}